package br.gov.sp.fatec.springboot3topicos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3topicos.entity.Trabalho;
import br.gov.sp.fatec.springboot3topicos.repository.TrabalhoRepository;

@Service
public class TrabalhoService {
    
    @Autowired
    private TrabalhoRepository trabalhoRepo;

    public List<Trabalho> buscarTodosTrabalhos(String titulo, Integer nota){
        List<Trabalho> trabalho = trabalhoRepo.findByTituloContainsAndNotaGreaterThan(titulo, nota);
        return trabalho;
    }

    public Trabalho cadastrarTrabalho (Trabalho trabalho) {
        if (trabalho == null ||
                trabalho.getTitulo() == null ||
                trabalho.getTitulo().isBlank() ||
                trabalho.getDataHora() == null ||
                trabalho.getGrupo() == null ||
                trabalho.getGrupo().isBlank()
        ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos!");
        }

        return trabalhoRepo.save(trabalho);
    }

    public Trabalho buscarTrabalhoPorId(Long id){
        Optional<Trabalho> trabalhoOp = trabalhoRepo.findById(id);
        if(trabalhoOp.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tabalho não encontrado");
        }
        return trabalhoOp.get();
    }
}

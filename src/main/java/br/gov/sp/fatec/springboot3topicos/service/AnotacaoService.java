package br.gov.sp.fatec.springboot3topicos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.fatec.springboot3topicos.entity.Anotacao;
import br.gov.sp.fatec.springboot3topicos.entity.Usuario;
import br.gov.sp.fatec.springboot3topicos.repository.AnotacaoRepository;

@Service
public class AnotacaoService {
    @Autowired
    private AnotacaoRepository anotacaoRepo;

    @Autowired
    private UsuarioService usuarioService;

    public Anotacao nova(Anotacao anotacao){
        if (anotacao == null ||
        anotacao.getTexto() == null ||
        anotacao.getTexto().isBlank() ||
        anotacao.getUsuario().getId() ==  null
        ){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Deu paia");
        }
        Usuario usuario = usuarioService
            .buscarUsuarioPorId(anotacao.getId());
        anotacao.setUsuario(usuario);
        return anotacaoRepo.save(anotacao);
    }
}

package br.gov.sp.fatec.springboot3topicos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.springboot3topicos.entity.Trabalho;

public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
    
    public List<Trabalho> findByTituloContainsAndNotaGreaterThan(String tituloTrabalho, Integer notaTrabalho);

}

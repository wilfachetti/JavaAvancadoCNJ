package br.cnj.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.cnj.projeto.models.CasoJudicial;

@Repository
public interface CasosJudiciaisRepository extends JpaRepository<CasoJudicial, Long> {

}

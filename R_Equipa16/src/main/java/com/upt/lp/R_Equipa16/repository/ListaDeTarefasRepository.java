package com.upt.lp.R_Equipa16.repository;

import com.upt.lp.R_Equipa16.model.ListaDeTarefas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaDeTarefasRepository extends JpaRepository<ListaDeTarefas, Long> {
}
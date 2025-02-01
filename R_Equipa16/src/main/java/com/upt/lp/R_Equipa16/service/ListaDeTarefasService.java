package com.upt.lp.R_Equipa16.service;

import com.upt.lp.R_Equipa16.model.ListaDeTarefas;
import com.upt.lp.R_Equipa16.repository.ListaDeTarefasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListaDeTarefasService {

    @Autowired
    private ListaDeTarefasRepository repository;

    public List<ListaDeTarefas> listarTodas() {
        return repository.findAll();
    }

    public Optional<ListaDeTarefas> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ListaDeTarefas salvar(ListaDeTarefas tarefa) {
        return repository.save(tarefa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
package com.upt.lp.R_Equipa16.controller;

import com.upt.lp.R_Equipa16.model.ListaDeTarefas;
import com.upt.lp.R_Equipa16.service.ListaDeTarefasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tarefas")
public class ListaDeTarefasController {

    @Autowired
    private ListaDeTarefasService service;

    @GetMapping
    public List<ListaDeTarefas> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<ListaDeTarefas> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public ListaDeTarefas adicionar(@RequestBody ListaDeTarefas tarefa) {
        return service.salvar(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}

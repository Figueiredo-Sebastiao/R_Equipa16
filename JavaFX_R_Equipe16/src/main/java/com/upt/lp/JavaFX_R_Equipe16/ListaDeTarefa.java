package com.upt.lp.JavaFX_R_Equipe16;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaDeTarefa extends Application {
    private List<Tarefa> tarefas = new ArrayList<>();
    private File arquivo = new File("tarefas.txt");
    private ListView<String> listaTarefas = new ListView<>();

    @Override
    public void start(Stage palco) {
        TextField campoDescricao = new TextField();
        DatePicker campoData = new DatePicker();
        ComboBox<String> campoPrioridade = new ComboBox<>();
        campoPrioridade.getItems().addAll("Baixa", "Média", "Alta");
        campoPrioridade.setValue("Média");
        Button botaoAdicionar = new Button("Adicionar");
        Button botaoRemover = new Button("Remover");

        carregarTarefas();
        atualizarLista();

        botaoAdicionar.setOnAction(e -> {
            String descricao = campoDescricao.getText();
            LocalDate data = campoData.getValue();
            String prioridade = campoPrioridade.getValue();
            if (!descricao.isEmpty() && data != null) {
                tarefas.add(new Tarefa(descricao, data, prioridade));
                salvarTarefas();
                atualizarLista();
                campoDescricao.clear();
                campoData.setValue(null);
                campoPrioridade.setValue("Média");
            }
        });

        botaoRemover.setOnAction(e -> {
            int index = listaTarefas.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                tarefas.remove(index);
                salvarTarefas();
                atualizarLista();
            }
        });

        VBox layout = new VBox(10, campoDescricao, campoData, campoPrioridade, botaoAdicionar, listaTarefas, botaoRemover);
        palco.setScene(new Scene(layout, 400, 400));
        palco.setTitle("Lista de Tarefas");
        palco.show();
    }

    private void salvarTarefas() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Tarefa tarefa : tarefas) {
                writer.write(tarefa.descricao + "|" + tarefa.data + "|" + tarefa.prioridade);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarTarefas() {
        if (arquivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] partes = linha.split("\\|");
                    if (partes.length == 3) {
                        tarefas.add(new Tarefa(partes[0], LocalDate.parse(partes[1]), partes[2]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void atualizarLista() {
        listaTarefas.getItems().clear();
        for (Tarefa tarefa : tarefas) {
            listaTarefas.getItems().add(tarefa.toString());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class Tarefa {
    String descricao;
    LocalDate data;
    String prioridade;

    public Tarefa(String descricao, LocalDate data, String prioridade) {
        this.descricao = descricao;
        this.data = data;
        this.prioridade = prioridade;
    }

    @Override
    public String toString() {
        return descricao + " (" + data + ", Prioridade: " + prioridade + ")";
    }
}

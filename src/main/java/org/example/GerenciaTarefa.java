package org.example;

import java.util.ArrayList;

public class GerenciaTarefa {
    private ArrayList<Tarefa> listaTarefas;

    public GerenciaTarefa() {
        this.listaTarefas = new ArrayList<>();
    }

    public void adicionarTarefa(Tarefa tarefa) {
        listaTarefas.add(tarefa);
    }

    public ArrayList<Tarefa> listarTarefas() {
        return listaTarefas;
    }
}
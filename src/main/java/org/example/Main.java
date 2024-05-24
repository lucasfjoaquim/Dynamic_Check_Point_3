package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Cria uma instância de GerenciaTarefa
        GerenciaTarefa gerenciaTarefa = new GerenciaTarefa();

        // Cria e exibe o formulário de cadastro de tarefas
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarefaForm(gerenciaTarefa).setVisible(true);
            }
        });
    }
}
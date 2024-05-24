package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarefaListForm extends JFrame {
    private JTable tabelaTarefas;
    private GerenciaTarefa gerenciaTarefa;

    public TarefaListForm(GerenciaTarefa gerenciaTarefa) {
        this.gerenciaTarefa = gerenciaTarefa;
        setTitle("Lista de Tarefas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();

        JButton cadastrarTarefaButton = new JButton("Cadastrar Nova Tarefa");
        add(cadastrarTarefaButton, "North");

        cadastrarTarefaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TarefaForm(gerenciaTarefa).setVisible(true);
                dispose(); // Fecha o formulário atual
            }
        });
    }

    private void initComponents() {
        String[] colunas = {"Título", "Descrição"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);
        tabelaTarefas = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tabelaTarefas);
        add(scrollPane);

        JButton atualizarButton = new JButton("Atualizar");
        add(atualizarButton, "South");

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atualizarTabela();
            }
        });
    }

    private void atualizarTabela() {
        DefaultTableModel model = (DefaultTableModel) tabelaTarefas.getModel();
        model.setRowCount(0); // Limpa a tabela
        for (Tarefa tarefa : gerenciaTarefa.listarTarefas()) {
            Object[] row = {tarefa.getTitulo(), tarefa.getDescricao()};
            model.addRow(row);
        }
    }
}
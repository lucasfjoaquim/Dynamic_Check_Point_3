package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TarefaForm extends JFrame {
    private JTextField tituloField;
    private JTextArea descricaoArea;
    private JButton cadastrarButton;
    private GerenciaTarefa gerenciaTarefa;

    public TarefaForm(GerenciaTarefa gerenciaTarefa) {
        this.gerenciaTarefa = gerenciaTarefa;
        setTitle("Cadastro de Tarefa");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        tituloField = new JTextField(20);
        descricaoArea = new JTextArea(5, 20);
        cadastrarButton = new JButton("Cadastrar");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Título:"));
        panel.add(tituloField);
        panel.add(new JLabel("Descrição:"));
        panel.add(new JScrollPane(descricaoArea));
        panel.add(cadastrarButton);

        add(panel);

        JButton listaTarefasButton = new JButton("Ver Lista de Tarefas");
        panel.add(listaTarefasButton);

        listaTarefasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TarefaListForm(gerenciaTarefa).setVisible(true);
                dispose(); // Fecha o formulário atual
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String titulo = tituloField.getText();
                String descricao = descricaoArea.getText();
                if (!titulo.isEmpty() && !descricao.isEmpty()) {
                    Tarefa novaTarefa = new Tarefa(titulo, descricao);
                    gerenciaTarefa.adicionarTarefa(novaTarefa);
                    JOptionPane.showMessageDialog(null, "Tarefa cadastrada com sucesso!");
                    tituloField.setText("");
                    descricaoArea.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                }
            }
        });
    }
}

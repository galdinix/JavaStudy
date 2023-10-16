package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame janela = new JFrame("Calculadora");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(200, 200);

        JPanel panel = new JPanel();
        janela.add(panel);

        JLabel numA = new JLabel("a: ");
        panel.add(numA);
        JTextField textField = new JTextField(5);
        panel.add(textField);

        JLabel numB = new JLabel("B: ");
        panel.add(numB);
        JTextField textFieldB = new JTextField(5);
        panel.add(textFieldB);

        JLabel resultado = new JLabel("Resultado: ");
        panel.add(resultado);
        JTextField result = new JTextField(5);
        panel.add(result);

        JButton botao = new JButton("Somar");
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double num = Double.parseDouble(textField.getText());
                double numB = Double.parseDouble(textFieldB.getText());
                result.setText(String.valueOf(Calculadora.Somar(num, numB)));

            }
        });

        JButton botaoSub = new JButton("Subtrair");
        botaoSub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(textField.getText());
                int numB = Integer.parseInt(textFieldB.getText());
                result.setText(String.valueOf(num - numB));
            }
        });

        JButton botaoMulti = new JButton("Multiplicação");
        botaoMulti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(textField.getText());
                int numB = Integer.parseInt(textFieldB.getText());
                result.setText(String.valueOf(num * numB));
            }
        });

        JButton botaoDivisao = new JButton("Divisão");
        botaoDivisao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(textField.getText());
                int numB = Integer.parseInt(textFieldB.getText());
                result.setText(String.valueOf(num / numB));
            }
        });



        janela.setVisible(true);
        panel.add(botao);
        panel.add(botaoSub);
        panel.add(botaoMulti);
        panel.add(botaoDivisao);

    }



}

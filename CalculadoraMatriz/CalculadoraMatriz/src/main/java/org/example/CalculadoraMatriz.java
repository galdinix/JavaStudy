package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.*;

public class CalculadoraMatriz {
    public static void main(String[] args) {
        JPanel panel = new JPanel();
        panel.setLayout(null); // Define o layout como null para usar o setBounds

        JLabel labelA = new JLabel("Matriz A");
        labelA.setBounds(0, 0, 100, 25);
        panel.add(labelA);

        JTextField inputA11 = new JTextField();
        inputA11.setBounds(0, 25, 100, 25); // Define o tamanho 4x4
        JTextField inputA12 = new JTextField();
        inputA12.setBounds(100, 25, 100, 25);
        JTextField inputA21 = new JTextField();
        inputA21.setBounds(0, 50, 100, 25);
        JTextField inputA22 = new JTextField();
        inputA22.setBounds(100, 50, 100, 25);

        JLabel labelB = new JLabel("Matriz B");
        labelB.setBounds(200, 0, 100, 25);
        panel.add(labelB);

        JTextField inputB11 = new JTextField();
        inputB11.setBounds(200, 25, 100, 25);
        JTextField inputB12 = new JTextField();
        inputB12.setBounds(300, 25, 100, 25);
        JTextField inputB21 = new JTextField();
        inputB21.setBounds(200, 50, 100, 25);
        JTextField inputB22 = new JTextField();
        inputB22.setBounds(300, 50, 100, 25);

        JLabel labelC = new JLabel("Matriz C");
        labelC.setBounds(0, 75, 100, 25);
        panel.add(labelC);

        JTextField outputC11 = new JTextField();
        outputC11.setBounds(0, 100, 100, 25);
        JTextField outputC12 = new JTextField();
        outputC12.setBounds(100, 100, 100, 25);
        JTextField outputC21 = new JTextField();
        outputC21.setBounds(0, 125, 100, 25);
        JTextField outputC22 = new JTextField();
        outputC22.setBounds(100, 125, 100, 25);

        panel.add(inputA11);
        panel.add(inputA12);
        panel.add(inputA21);
        panel.add(inputA22);

        panel.add(inputB11);
        panel.add(inputB12);
        panel.add(inputB21);
        panel.add(inputB22);

        panel.add(outputC11);
        panel.add(outputC12);
        panel.add(outputC21);
        panel.add(outputC22);

        String[] buttonLabels = {
                "Somar", "Subtrair", "Multi", "Escalar"
        };

        int x = 200;
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 12));
            button.setBounds(x, 100, 80, 30); // Define o tamanho do botão
            panel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    double [][] matrizA = new double[2][2];
                    double [][] matrizB = new double [2][2];
                    double [][] matrizC = new double[2][2];
                    matrizA[0][0] = parseDouble(inputA11.getText());
                    matrizA[0][1] = parseDouble(inputA12.getText());
                    matrizA[1][0] = parseDouble(inputA21.getText());
                    matrizA[1][1] = parseDouble(inputA22.getText());

                    matrizB[0][0] = parseDouble(inputB11.getText());
                    matrizB[0][1] = parseDouble(inputB12.getText());
                    matrizB[1][0] = parseDouble(inputB21.getText());
                    matrizB[1][1] = parseDouble(inputB22.getText());


                    try {

                        if (label.equals("Somar")) {
                            for (int i = 0; i<matrizA.length; i++){
                                for (int k=0;k<matrizB.length;k++){
                                    matrizC[i][k] = matrizA[i][k] + matrizB[i][k];
                                }
                            }
                            outputC11.setText(String.valueOf(matrizC[0][0]));
                            outputC12.setText(String.valueOf(matrizC[0][1]));
                            outputC21.setText(String.valueOf(matrizC[1][0]));
                            outputC22.setText(String.valueOf(matrizC[1][1]));
                            return;
                        }
                        if (label.equals("Subtrair")) {
                            for (int i = 0; i<matrizA.length; i++){
                                for (int k=0;k<matrizB.length;k++){
                                    matrizC[i][k] = matrizA[i][k] - matrizB[i][k];
                                }
                            }
                            outputC11.setText(String.valueOf(matrizC[0][0]));
                            outputC12.setText(String.valueOf(matrizC[0][1]));
                            outputC21.setText(String.valueOf(matrizC[1][0]));
                            outputC22.setText(String.valueOf(matrizC[1][1]));
                            return;
                        }
                        if (label.equals("Multi")) {
                            outputC11.setText(String.valueOf((matrizA[0][0] * matrizB[0][0]) + (matrizA[0][1] * matrizB[1][0])));
                            outputC12.setText(String.valueOf(matrizA[0][0] * matrizB[0][1] + matrizA[0][1] * matrizB[1][1]));
                            outputC21.setText(String.valueOf(matrizA[1][0] * matrizB[0][0] + matrizA[1][1] * matrizB[1][0]));
                            outputC22.setText(String.valueOf(matrizA[1][0] * matrizB[0][1] + matrizA[1][1] * matrizB[1][1]));
                        }
                        if  (label.equals("Escalar")){
                            for (int i = 0; i<matrizA.length; i++){
                                for (int k=0;k<matrizA.length;k++){
                                    matrizC[i][k] = matrizA[i][k] * 2;
                                }
                            }
                            outputC11.setText(String.valueOf(matrizC[0][0]));
                            outputC12.setText(String.valueOf(matrizC[0][1]));
                            outputC21.setText(String.valueOf(matrizC[1][0]));
                            outputC22.setText(String.valueOf(matrizC[1][1]));
                        }
                    } catch (Exception ex) {
                        outputC21.setText("Erro: Entrada invalida!!!!!!!!!!!!!!!");
                    }
                }
            });

            x += 80; // Incrementa a posição X para o próximo botão

        }
        JFrame frame = new JFrame("Matrizes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.add(panel);
        frame.setVisible(true);
    }

}

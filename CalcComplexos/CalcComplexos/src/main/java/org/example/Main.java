package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Números Complexos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize( 800,  400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 6));

        JTextField inputField1 = new JTextField();
        JTextField inputField2 = new JTextField();
        JTextField inputField3 = new JTextField();
        JTextField inputField4 = new JTextField();
        JTextField outputField = new JTextField();
        JTextField outputField2 = new JTextField();
        JTextField outputField3 = new JTextField();
        outputField.setEditable(false);
        outputField2.setEditable(false);
        outputField2.setBorder(null);
        outputField3.setEditable(false);

        inputField1.setFont((new Font("Arial", Font.PLAIN, 15)));
        inputField2.setFont((new Font("Arial", Font.PLAIN, 15)));
        inputField3.setFont((new Font("Arial", Font.PLAIN, 15)));
        inputField4.setFont((new Font("Arial", Font.PLAIN, 15)));
        outputField.setFont((new Font("Arial", Font.PLAIN, 15)));

        JLabel complex1 = new JLabel("Números Reais:");
        complex1.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel complex2 = new JLabel("Números imaginários:");
        complex2.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel result = new JLabel("Resultado");
        result.setFont((new Font("Arial", Font.BOLD,  20)));
        JLabel result1 = new JLabel("Resultado");
        result1.setFont((new Font("Arial", Font.BOLD,  20)));
        JLabel imagin = new JLabel("i");
        JLabel imagin1 = new JLabel("i");
        JLabel label = new JLabel();
        label.setFont((new Font("Arial", Font.BOLD, 20)));
        JLabel label1 = new JLabel();
        label.setFont((new Font("Arial", Font.BOLD, 20)));


        panel.add(complex1);
        panel.add(complex2);
        panel.add(label);
        panel.add(inputField1);
        panel.add(inputField2);
        panel.add(imagin);
        panel.add(inputField3);
        panel.add(inputField4);
        panel.add(imagin1);
        panel.add(result);
        panel.add(result1);
        panel.add(label1);
        panel.add(outputField);
        panel.add(outputField3);



        String[] buttonLabels = {"Somar", "Subtrair", "Módulo"};


        for(String botao: buttonLabels) {
            JButton button = new JButton(botao);
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            panel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double firstnumReal = Double.parseDouble(inputField1.getText());
                    double secondNumReal = Double.parseDouble(inputField3.getText());
                    double firstNumImaginario = Double.parseDouble(inputField2.getText());
                    double secondNumImaginario = Double.parseDouble(inputField4.getText());

                    if(botao == "Somar"){
                        double somaReal = CalcularComplexos.somar(firstnumReal, secondNumReal);
                        double somaImaginario = CalcularComplexos.somarImaginario(firstNumImaginario, secondNumImaginario);
                        outputField.setText(String.valueOf(somaReal));
                        outputField3.setText(String.valueOf(somaImaginario));
                    }
                    if(botao == "Subtrair"){
                        double subReal = CalcularComplexos.sub(firstnumReal, secondNumReal);
                        double subImaginario = CalcularComplexos.subImaginario(firstNumImaginario, secondNumImaginario);
                        outputField.setText(String.valueOf(subReal));
                        outputField3.setText(String.valueOf(subImaginario));
                    }
                    if(botao == "Módulo"){
                        double mod = CalcularComplexos.modulo(firstnumReal, firstNumImaginario);
                        outputField.setText(String.valueOf(mod));
                    }

                }
            });

        }


        frame.add(panel);
        frame.setVisible(true);
    }
}

   // No teste de Caixa Branca, também chamado de Teste Estrutural, a ênfase está no entendimento interno do componente de software, onde o testador tem acesso ao código-fonte. Essa abordagem permite a criação de códigos específicos para conectar bibliotecas e componentes, destacando-se pelo exame detalhado da estrutura interna do software. O uso de ferramentas como o JUnit exemplifica essa prática ao desenvolver casos de teste para avaliar diretamente classes ou métodos em Java. A escolha pelo teste de Caixa Branca visa uma compreensão profunda do funcionamento interno do software, possibilitando a identificação de falhas e garantindo uma cobertura abrangente dos diferentes caminhos e lógicas do código. Essa estratégia é particularmente valiosa para assegurar a qualidade e robustez do software por meio da análise direta de sua implementação.

   //Por outro lado, o teste de Caixa Preta, ou Teste Funcional, é o oposto do teste de Caixa Branca. Nele, os dados de entrada são fornecidos, o teste é executado, e o resultado obtido é comparado com um resultado esperado previamente conhecido. O teste é considerado bem-sucedido se o resultado obtido corresponder ao esperado. Em resumo, esse tipo de teste verifica se o resultado alcançado é igual ao resultado desejado, baseando-se nos requisitos de uma lista anteriormente definida. O teste de Caixa Preta não envolve a análise do código-fonte, pois sua abordagem é orientada pelos requisitos previamente estabelecidos.





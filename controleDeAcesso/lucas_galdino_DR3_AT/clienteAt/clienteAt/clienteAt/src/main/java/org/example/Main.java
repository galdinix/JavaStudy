package org.example;
import netscape.javascript.JSObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import  java.awt.*;
import  java.awt.event.ActionEvent;
import  java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.exit;
public class Main {
    static JTextField inputField1 = new JTextField();
    public static void main(String[] args) throws InterruptedException {

        JFrame frame = new JFrame("Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 200);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 1));

        JLabel label1 = new JLabel("Id:");
        label1.setFont((new Font("Arial", Font.BOLD, 30)));
        panel.add(label1);



        JLabel label2 = new JLabel("Response:");
        label2.setFont((new Font("Arial", Font.BOLD, 30)));
        panel.add(label2);
        inputField1.setFont((new Font("Arial", Font.PLAIN, 30)));
        panel.add(inputField1);
        JTextField inputField2 = new JTextField();
        inputField2.setFont((new Font("Arial", Font.PLAIN, 30)));
        panel.add(inputField2);


    inputField1.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void insertUpdate(DocumentEvent e) {
            String id = inputField1.getText();
            boolean trocaDeCor;
            if(inputField1.getText().length() == 10) {
                System.out.println("entrei");
                trocaDeCor = enviarRequest(id);


                if (trocaDeCor) {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                inputField2.setBackground(Color.GREEN);
                                Thread.sleep(3000);
                                inputField2.setBackground(Color.WHITE);
                                inputField1.setText("");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t.start();
                } else {
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                inputField2.setBackground(Color.RED);
                                Thread.sleep(3000);
                                inputField2.setBackground(Color.WHITE);
                                inputField1.setText("");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    t.start();
                }
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e) {}
        @Override
        public void changedUpdate(DocumentEvent e) {}
    });

        frame.add(panel);
        frame.setVisible(true);

    }

    public static boolean enviarRequest(String id){
        boolean trocaDeCor = false;
        String idCartao = id;
        try {
            // Configuração da URL do servidor Apache Spark
            String url = "http://localhost:8080/verificarCartao";

            // Configuração da requisição HTTP POST com o Apache HttpClient
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json");

            // Construção do corpo da requisição
            String jsonInputString = "{\"id\":\"" + idCartao + "\"}";
            httpPost.setEntity(new StringEntity(jsonInputString, StandardCharsets.UTF_8));

            // Envio da requisição para o servidor
            HttpResponse response = httpClient.execute(httpPost);

            // Leitura da resposta do servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            StringBuilder responseBody = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                responseBody.append(line);
            }

            // Processar resposta e atualizar a interface gráfica
            trocaDeCor = processarResposta(responseBody.toString());

        } catch (IOException e) {
            e.printStackTrace();
            // Tratar exceções de requisição, como conexão perdida, timeout, etc.
        }
        return trocaDeCor;
    }



    private static boolean processarResposta(String resposta) {

        if (resposta != null && resposta.contains("1"))
            return false;
        return true;
    }



}



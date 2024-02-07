package org.example;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame {

    private JLabel temperaturaLabel;
    private JLabel umidadeLabel;
    private JLabel cidadeLabel;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        setTitle("Previsão do Tempo");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(3, 1));

        temperaturaLabel = new JLabel("Temperatura: ");
        umidadeLabel = new JLabel("Umidade: ");
        cidadeLabel = new JLabel("Cidade: Rio de Janeiro"); // Cidade fixa

        infoPanel.add(temperaturaLabel);
        infoPanel.add(umidadeLabel);
        infoPanel.add(cidadeLabel);

        panel.add(infoPanel, BorderLayout.CENTER);

        // Botão removido, pois a cidade é fixa
        // JButton botao = new JButton("Obter Clima");

        // panel.add(botao, BorderLayout.SOUTH);

        add(panel);
        setVisible(true);

        // Inicia o timer para atualizar a temperatura a cada 30 segundos
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                obterClima();
            }
        }, 0, 30 * 1000); // 30 segundos em milissegundos

        // Chama obterClima() inicialmente para exibir os dados iniciais
        obterClima();
    }

    private void obterClima() {
        // Rio de Janeiro como cidade fixa
        String cidade = "Rio de Janeiro";

        try {
            String apiKey = "08a9f1f7f02c24b51000b32e1d8199f8";
            String apiUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + cidade + "&appid=" + apiKey;

            URL url = new URL(apiUrl);
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject main = jsonObject.getJSONObject("main");
            double temperatura = main.getDouble("temp") - 273.15;
            int umidadeValue = main.getInt("humidity");

            temperaturaLabel.setText("Temperatura: " + String.format("%.2f", temperatura) + " °C");
            umidadeLabel.setText("Umidade: " + umidadeValue + "%");
            cidadeLabel.setText("Cidade: " + cidade);

        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao obter o clima.");
        }
    }
}

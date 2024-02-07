package org.example;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.atomic.AtomicInteger;
import static spark.Spark.*;

public class Main {
    static int cont = 0;
    public static void main(String[] args) {
        port(8080);
        JFrame frame = new JFrame("Servidor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,  400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));

        JTextField inputField1 = new JTextField();
        inputField1.setFont((new Font("Arial", Font.PLAIN, 30)));

        JTextField inputField2 = new JTextField();
        inputField2.setFont((new Font("Arial", Font.PLAIN, 30)));

        JLabel label1 = new JLabel("Id:");
        label1.setFont((new Font("Arial", Font.BOLD, 30)));

        JLabel label2 = new JLabel("Response:");
        label2.setFont((new Font("Arial", Font.BOLD, 30)));

        post("/verificarCartao", (request, response) -> {
            String idCartao = request.body();
            JsonElement jsonElement = JsonParser.parseString(idCartao);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            idCartao = (jsonObject.get("id").getAsString());

            System.out.println(idCartao);
            if((inputField1.getText()).equals(idCartao)){
                response.type("application/json");
                inputField2.setText("{\"status\":\"ACK\"}");
                return "{\"ACK\":\"0\"}";
            }
            response.type("application/json");
            inputField2.setText("{\"status\":\"NACK\"}");
            return "{\"ACK\":\"1\"}";
        });


        panel.add(label1);
        panel.add(inputField1);
        panel.add(label2);
        panel.add(inputField2);
        frame.add(panel);
        frame.setVisible(true);

    }
}
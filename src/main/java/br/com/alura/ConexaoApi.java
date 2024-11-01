package br.com.alura;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexaoApi {
    private String endereco = "https://v6.exchangerate-api.com/v6/SUA_API_AQUI/pair/";

    public Moeda converte(String origem, String destino) {
        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(endereco + origem + "/" + destino))
                .build();

        HttpResponse<String> resposta = null;
        try {
             resposta = cliente.send(requisicao,
                    HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Gson gson = new Gson();
        return gson.fromJson(resposta.body(), Moeda.class);
    }

}

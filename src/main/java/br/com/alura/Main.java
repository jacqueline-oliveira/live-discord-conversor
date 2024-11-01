package br.com.alura;

public class Main {
    public static void main(String[] args) {
        ConexaoApi conexao = new ConexaoApi();
        Moeda resposta = conexao.converte("USD", "BRL");
        System.out.println(resposta);
    }
}
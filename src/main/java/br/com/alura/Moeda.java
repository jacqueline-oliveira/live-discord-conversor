package br.com.alura;

public record Moeda(String base_code,
                    String target_code,
                    Double conversion_rate) {

    @Override
    public String toString() {
        return "O valor de 1 " + base_code + " em " + target_code +" é " +
                conversion_rate;
    }
}

package com.leosouza.sge.domain.enums;

public enum Jogo {
    ARMA2(1, "Arma 2"),
    ARMA3(2, "Arma 3");

    private int id;
    private String nome;

    private Jogo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static Jogo toEnum(Integer id){
        if (id == null) {
            return null;
        }

        for (Jogo jogo : Jogo.values()) {
            if (id.equals(jogo.getId())) {
                return jogo;
            }
        }

        throw new IllegalArgumentException("Id inválido " + id);
    }
}

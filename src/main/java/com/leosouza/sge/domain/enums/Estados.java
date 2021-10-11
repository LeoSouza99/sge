package com.leosouza.sge.domain.enums;

public enum Estados {
    AC(1, "Acre", "AC"),
    AL(2, "Alagoas", "AL"),
    AP(3, "Amapá", "AP"),
    AM(4, "Amazonas", "AM"),
    BA(5, "Bahia", "BA"),
    CE(6, "Ceará", "CE"),
    DF(7, "Distrito Federal", "DF"),
    ES(8, "Espirito Santo", "ES"),
    GO(9, "Goias", "GO"),
    MA(10, "Maranhão", "MA"),
    MT(11, "Mato Grosso","MT"),
    MS(12, "Mato Grosso do Sul", "MS"),
    MG(13, "Minas Gerais", "MG"),
    PA(14, "Pará", "PA"),
    PB(15, "Paraiba", "PB"),
    PR(16, "Paraná", "PR"),
    PE(17, "Pernambuco", "PE"),
    PI(18, "Piauí", "PI"),
    RJ(19, "Rio de Janeiro", "RJ"),
    RN(20, "Rio Grande do Norte", "RN"),
    RS(21, "Rio Grande do Sul", "RS"),
    RO(22, "Rondônia", "RO"),
    RR(23, "Roraima", "RR"),
    SC(24, "Santa Catarina", "SC"),
    SP(25, "São Paulo", "SP"),
    SE(25, "Sergipe", "SE"),
    TO(26, "Tocantins", "TO");

    private int cod;
    private String estado;
    private String uf;

    private Estados(int cod, String estado, String uf) {
        this.cod = cod;
        this.estado = estado;
        this.uf = uf;
    }

    public int getCod() {
        return cod;
    }

    public String getEstado() {
        return estado;
    }

    public String getUf() {
        return uf;
    }

    public static Estados toEnum(Integer cod){
        if(cod == null){
            return null;
        }

        for(Estados x : Estados.values()){
            if(cod.equals(x.getCod())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id é Inválido " + cod);
    }
}

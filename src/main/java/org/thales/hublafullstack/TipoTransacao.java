package org.thales.hublafullstack;

import java.util.List;

public enum TipoTransacao {
    VENDA_PRODUTOR(1, "Venda produtor", "Entrada", "+"),
    VENDA_AFILIADO(2, "Venda afiliado", "Entrada", "+"),
    COMISSAO_PAGA(3, "Comissão paga", "Saída", "-"),
    COMISSAO_RECEBIDA(4, "Comissão recebida", "Entrada", "+");

    private final int tipo;
    private final String descricao;
    private final String natureza;
    private final String sinal;

    TipoTransacao(int tipo, String descricao, String natureza, String sinal) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.natureza = natureza;
        this.sinal = sinal;
    }

    public static TipoTransacao getByTipo(int tipo) {
        return List.of(TipoTransacao.values()).stream().filter(tipoTransacao -> tipoTransacao.tipo == tipo).toList().get(0);
    }

    public int getTipo() {
        return tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getNatureza() {
        return natureza;
    }

    public String getSinal() {
        return sinal;
    }
}

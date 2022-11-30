package org.thales.hublafullstack;

public record Transacao(TipoTransacao tipo, String data, String produto, Integer valor, String vendedor) {

    public static Transacao of(String row) {
        String tipo = row.trim().substring(0, 1);
        String data = row.trim().substring(1, 26);
        String produto = row.trim().substring(26, 56).trim();
        String valor = row.trim().substring(56, 66);
        String vendedor = row.trim().substring(66, row.length());
        return new Transacao(TipoTransacao.getByTipo(Integer.parseInt(tipo)), data, produto, Integer.parseInt(valor), vendedor);
    }


}

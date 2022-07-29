package br.csi.farmaspring.model;

public class Cliente {
    private int codcli;
    private String nomcli;
    private String cpfcli;

    public int getCodcli() {
        return codcli;
    }

    public void setCodcli(int codcli) {
        this.codcli = codcli;
    }

    public String getNomcli() {
        return nomcli;
    }

    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }

    public String getCpfcli() {
        return cpfcli;
    }

    public void setCpfcli(String cpfcli) {
        this.cpfcli = cpfcli;
    }
}
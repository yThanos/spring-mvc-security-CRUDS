package br.csi.farmaspring.model;

public class Venda {
    private int codven;
    private Cliente cliven;
   private Produto proven;
   private int qtdven;

    public Cliente getCliven() {
        return cliven;
    }

    public void setCliven(Cliente cliven) {
        this.cliven = cliven;
    }

    public Produto getProven() {
        return proven;
    }

    public void setProven(Produto proven) {
        this.proven = proven;
    }

    public int getQtdven() {
        return qtdven;
    }

    public void setQtdven(int qtdven) {
        this.qtdven = qtdven;
    }

    public int getCodven() {
        return codven;
    }

    public void setCodven(int codven) {
        this.codven = codven;
    }

}
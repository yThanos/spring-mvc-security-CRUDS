package br.csi.farmaspring.model;

public class Carinho {
    private int codcar;
    private Cliente clicar;
    private Produto procar;

    public int getCodcar() {
        return codcar;
    }

    public void setCodcar(int codcar) {
        this.codcar = codcar;
    }

    public Cliente getClicar() {
        return clicar;
    }

    public void setClicar(Cliente clicar) {
        this.clicar = clicar;
    }

    public Produto getProcar() {
        return procar;
    }

    public void setProcar(Produto procar) {
        this.procar = procar;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    private int qnt;


}

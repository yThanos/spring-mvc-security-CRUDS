package br.csi.farmaspring.model;

public class Funcionario {
    private int codfun;
    private String nomfun;
    private String cpffun;
    private String senha;
    private Permissao permissao;

    public int getCodfun() {
        return codfun;
    }

    public void setCodfun(int codfun) {
        this.codfun = codfun;
    }

    public String getNomfun() {
        return nomfun;
    }

    public void setNomfun(String nomfun) {
        this.nomfun = nomfun;
    }

    public String getCpffun() {
        return cpffun;
    }

    public void setCpffun(String cpffun) {
        this.cpffun = cpffun;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }
}
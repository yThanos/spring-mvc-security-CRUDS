package br.csi.farmaspring.service;

import br.csi.farmaspring.dao.LoginDao;
import br.csi.farmaspring.model.Funcionario;

public class LoginService {
    public Funcionario autentica(String cpf, String senha){
        if (cpf != null && senha != null){
            Funcionario func = new LoginDao().getLogin(cpf);

            if(func != null){
                if (func.getCpffun().equals(cpf) && func.getSenha().equals(senha)){
                    return func;
                }
            }
        }
        return null;
    }
}
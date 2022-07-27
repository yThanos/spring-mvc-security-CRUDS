package br.csi.farmaspring.service;

import br.csi.farmaspring.dao.FunDao;
import br.csi.farmaspring.model.Funcionario;

public class FuncService {
    public String cadFun(Funcionario func, int perm){
        String teste = new FunDao().setFuncionario(func, perm);
        if(teste.equals("cpf")){
            return "existe";
        } else if(teste.equals("erro")){
            return "erro";
        } else{
            return "funcionarios";
        }
    }
}

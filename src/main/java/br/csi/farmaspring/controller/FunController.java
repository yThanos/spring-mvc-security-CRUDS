package br.csi.farmaspring.controller;

import br.csi.farmaspring.dao.FunDao;
import br.csi.farmaspring.dao.PermDao;
import br.csi.farmaspring.model.Funcionario;
import br.csi.farmaspring.service.FuncService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/func")
public class FunController {

    @GetMapping("/inicio")
    public String inicio(Model model){
        model.addAttribute("funcionarios", new FunDao().listFun());

        return "funcInicio";
    }

    @GetMapping("cadastrar")
    public String cadFun(Model model){
        model.addAttribute("perms", new PermDao().listPerm());
        model.addAttribute("func", new Funcionario());

        return "cadFun";
    }

    @PostMapping("cadastrar")
    public String cadastrar(@ModelAttribute("func") Funcionario func, Model model){
        int perm = func.getPermissao().getId();
        String resultado = new FuncService().cadFun(func, perm);

        System.out.println(resultado);

        if (resultado == "existe"){
            resultado = "cadFun";
            model.addAttribute("erro", "CPF já cadastrado");

        } else if(resultado == "erro"){
            resultado = "cadFun";
            model.addAttribute("erro", "Preencha todos os campos");
        }

        return resultado;
    }
}
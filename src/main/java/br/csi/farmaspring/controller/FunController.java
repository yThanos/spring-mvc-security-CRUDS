package br.csi.farmaspring.controller;

import br.csi.farmaspring.dao.FunDao;
import br.csi.farmaspring.dao.PermDao;
import br.csi.farmaspring.model.Funcionario;
import br.csi.farmaspring.service.FuncService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/func")
public class FunController {

    @GetMapping("/inicio")
    public String inicio(Model model){
        model.addAttribute("funcionarios", new FunDao().listFun());

        return "funcInicio";
    }

    @GetMapping("/cadastrar")
    public String cadFun(Model model){
        model.addAttribute("perms", new PermDao().listPerm());
        model.addAttribute("func", new Funcionario());

        return "cadFun";
    }

    @PostMapping("/cadastrar")
    public RedirectView cadastrar(@ModelAttribute("func") Funcionario func, Model model){

        int perm = func.getPermissao().getId();
        String resultado = new FuncService().cadFun(func, perm);

        System.out.println(resultado);
        RedirectView redirect = new RedirectView("/Farmacia/func/inicio");

        if (resultado == "existe"){
            model.addAttribute("erro", "CPF já cadastrado");

        } else if(resultado == "erro"){
            model.addAttribute("erro", "Preencha todos os campos");
        }

        return redirect;
    }

    @GetMapping("/editar")
    public String update(@RequestParam String cpf, Model model){
        Funcionario func = new FunDao().getFuncionario(cpf);

        model.addAttribute("func", func);

        model.addAttribute("funcionario", new Funcionario());

        model.addAttribute("perms", new PermDao().listPerm());

        return "updFun";
    }

    @PostMapping("/editar")
    public RedirectView editar(@ModelAttribute Funcionario func){
        RedirectView redirect = new RedirectView("/Farmacia/func/inicio");

        int perm = func.getPermissao().getId();

        new FunDao().updFun(func, perm);

        return redirect;
    }

    @GetMapping("/excluir")
    public RedirectView delete(@RequestParam String cpf){
        new FunDao().delfun(cpf);

        RedirectView redirect = new RedirectView("/Farmacia/func/inicio");

        return redirect;
    }
}
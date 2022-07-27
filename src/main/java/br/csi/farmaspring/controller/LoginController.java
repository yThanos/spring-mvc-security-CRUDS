package br.csi.farmaspring.controller;

import br.csi.farmaspring.model.Funcionario;
import br.csi.farmaspring.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class LoginController {
    @GetMapping("login")
    public String logRed(){
        
        return "login";
    }

    @PostMapping("login")
    public RedirectView login(@RequestParam String cpf, @RequestParam String senha){
        RedirectView redirect = new RedirectView("/Farmacia/login");
        Funcionario func = new LoginService().autentica(cpf, senha);
        if (func != null){


            if (func.getPermissao().getId() == 1){
                redirect = new RedirectView("/Farmacia/admin/inicio");

            } else if (func.getPermissao().getId() == 2) {
                redirect = new RedirectView("/Farmacia/funcionario/inicio");

            }
        }
        return redirect;
    }
}
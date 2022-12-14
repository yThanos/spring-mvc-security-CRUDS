package br.csi.farmaspring.controller;

import br.csi.farmaspring.model.Funcionario;
import br.csi.farmaspring.model.Login;
import br.csi.farmaspring.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("login")
    public String logRed(Model model){
        model.addAttribute("login", new Login());

        return "login";
    }

    @PostMapping("login")
    public RedirectView login(@RequestParam String cpf, @RequestParam String senha, HttpServletRequest req){

        RedirectView redirect = new RedirectView("/Farmacia/login");
        Funcionario func = new LoginService().autentica(cpf, senha);
        if (func != null){

            HttpSession sessao = req.getSession();
            sessao.setAttribute("usuario_logado", func);

            if (func.getPermissao().getId() == 1){
                redirect = new RedirectView("/Farmacia/admin/inicio");

            } else if (func.getPermissao().getId() == 2) {
                redirect = new RedirectView("/Farmacia/vendas/inicio");

            } else if (func.getPermissao().getId() == 3) {
                redirect = new RedirectView("/Farmacia/estoque/inicio");
            }
        }
        return redirect;
    }
}
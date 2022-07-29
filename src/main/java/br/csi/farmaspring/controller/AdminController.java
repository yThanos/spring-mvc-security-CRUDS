package br.csi.farmaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/inicio")
    public String inicio () {

        return "admin";
    }

    @GetMapping("/funcionarios")
    public RedirectView funcionarios(){
        RedirectView redirect = new RedirectView("/Farmacia/func/inicio");

        return redirect;
    }

    @GetMapping("/produtos")
    public RedirectView produtos(){
        RedirectView redirect = new RedirectView("/Farmacia/prod/inicio");

        return redirect;
    }

    @GetMapping("/clientes")
    public RedirectView clientes(){
        RedirectView redirect = new RedirectView("/Farmacia/cli/inicio");

        return redirect;
    }

    @GetMapping("/vendas")
    public RedirectView vendas(){
        RedirectView redirect = new RedirectView("/Farmacia/vend/inicio");

        return redirect;
    }

    @GetMapping("/sair")
    public RedirectView sair(HttpServletRequest req){
        RedirectView redirect = new RedirectView("/Farmacia/login");
        req.getSession().invalidate();

        return redirect;
    }
}
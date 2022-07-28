package br.csi.farmaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

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
    public String clientes(){


        return "clientes";
    }

    @GetMapping("/vendas")
    public String vendas(){


        return "vendas";
    }

    @GetMapping("/sair")
    public RedirectView sair(){
        RedirectView redirect = new RedirectView("/Farmacia/login");

        return redirect;
    }
}
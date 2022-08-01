package br.csi.farmaspring.controller;

import br.csi.farmaspring.dao.ProDao;
import br.csi.farmaspring.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/estoque")
public class EstoqueController {

    @GetMapping("/inicio")
    public String inicio(Model model){

        model.addAttribute("produtos", new ProDao().listProd());

        return "estoque";
    }

    @GetMapping("/cadastrar")
    public String cadEst(Model model){

        model.addAttribute("prod", new Produto());

        return "cadEst";
    }

    @PostMapping("/cadastrar")
    public RedirectView cad(@ModelAttribute Produto prod){
        RedirectView redirect = new RedirectView("/Farmacia/estoque/inicio");

        new ProDao().setProd(prod);

        return redirect;
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int codpro, Model model){
        Produto prod = new ProDao().getProd(codpro);

        model.addAttribute("produto", prod);

        model.addAttribute("prod", new Produto());

        return "updEst";
    }

    @PostMapping("/editar")
    public RedirectView update(@ModelAttribute Produto prod){
        RedirectView redirect = new RedirectView("/Farmacia/estoque/inicio");

        new ProDao().updPro(prod);

        return redirect;
    }

    @GetMapping("/excluir")
    public RedirectView delete(@RequestParam int codpro){
        RedirectView redirect = new RedirectView("/Farmacia/estoque/inicio");

        new ProDao().delProd(codpro);

        return redirect;
    }

    @GetMapping("/sair")
    public RedirectView sair(HttpServletRequest req){
        RedirectView redirect = new RedirectView("/Farmacia/login");
        req.getSession().invalidate();

        return redirect;
    }
}
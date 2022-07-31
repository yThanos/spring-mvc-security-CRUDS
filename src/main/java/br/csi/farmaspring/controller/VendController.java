package br.csi.farmaspring.controller;

import br.csi.farmaspring.dao.CliDao;
import br.csi.farmaspring.dao.ProDao;
import br.csi.farmaspring.dao.VenDao;
import br.csi.farmaspring.model.Venda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/vend")
public class VendController {

    @GetMapping("/inicio")
    public String inicio(Model model){

        model.addAttribute("vendas", new VenDao().listVen());

        return "vendInicio";
    }

    @GetMapping("/cadastrar")
    public String cadVen(Model model){

        model.addAttribute("vend", new Venda());

        model.addAttribute("prods", new ProDao().listProd());

        model.addAttribute("clis", new CliDao().listCli());

        return "cadVen";
    }

    @PostMapping("/cadastrar")
    public RedirectView cadVen(@ModelAttribute Venda vend){
        RedirectView redirect = new RedirectView("/Farmacia/vend/inicio");

        new VenDao().setVen(vend);


        return redirect;
    }
}
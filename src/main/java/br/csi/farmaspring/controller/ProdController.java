package br.csi.farmaspring.controller;


import br.csi.farmaspring.dao.ProDao;
import br.csi.farmaspring.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/prod")
public class ProdController {

    @GetMapping("/inicio")
    public String inicio(Model model){

        model.addAttribute("produtos", new ProDao().listProd());

        return "prodInicio";
    }

    @GetMapping("/cadastrar")
    public String cadastro(Model model){
        model.addAttribute("prod", new Produto());

        return "cadPro";
    }

    @PostMapping("/cadastrar")
    public RedirectView cadProd(@ModelAttribute Produto prod){
        RedirectView redirect = new RedirectView("/Farmacia/prod/inicio");

        new ProDao().setProd(prod);

        return redirect;
    }

    @GetMapping("/editar")
    public String editar(@RequestParam int codpro, Model model){
        Produto prod = new ProDao().getProd(codpro);

        model.addAttribute("produto", prod);

        model.addAttribute("prod", new Produto());

        return "updPro";
    }

    @PostMapping("/editar")
    public RedirectView ediPro(@ModelAttribute Produto prod){
        RedirectView redirect = new RedirectView("/Farmacia/prod/inicio");

        new ProDao().updPro(prod);

        return redirect;
    }

    @GetMapping("/excluir")
    public RedirectView delete(@RequestParam int codpro){
        RedirectView redirect = new RedirectView("/Farmacia/prod/inicio");

        new ProDao().delProd(codpro);

        return redirect;
    }
}

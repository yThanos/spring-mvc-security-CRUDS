package br.csi.farmaspring.controller;

import br.csi.farmaspring.dao.CarDao;
import br.csi.farmaspring.dao.CliDao;
import br.csi.farmaspring.dao.ProDao;
import br.csi.farmaspring.dao.VenDao;
import br.csi.farmaspring.model.Carinho;
import br.csi.farmaspring.model.Cliente;
import br.csi.farmaspring.model.Login;
import br.csi.farmaspring.model.Venda;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/vendas")
public class VendasController {

    @GetMapping("/inicio")
    public String inicio(Model model){
        model.addAttribute("login", new Login());

        return "vendasInicio";
    }

    @PostMapping("/seleciona")
    public RedirectView seleciona(@RequestParam String cpf, HttpServletRequest req){
        RedirectView redirect = new RedirectView("/Farmacia/vendas/main");

        HttpSession session = req.getSession();
        session.setAttribute("cliente_selecionado", new CliDao().getCli2(cpf));

        return redirect;
    }

    @GetMapping("main")
    public String main(Model model){

        model.addAttribute("car", new Carinho());
        model.addAttribute("prods", new ProDao().listProd());
        model.addAttribute("vendas", new CarDao().listCar());


        return "vender";
    }

    @GetMapping("/cadcli")
    public String cadcli(Model model){

        model.addAttribute("cli", new Cliente());

        return "cadCliven";
    }

    @PostMapping("/cadcli")
    public RedirectView cadcli(@ModelAttribute Cliente cli){
        RedirectView redirect = new RedirectView("/Farmacia/vendas/inicio");

        new CliDao().setCliente(cli);

        return redirect;
    }

    @PostMapping("/cadven")
    public RedirectView cadven(@ModelAttribute Carinho vend){
        RedirectView redirect = new RedirectView("/Farmacia/vendas/main");

        new CarDao().setVen(vend);

        return redirect;
    }

    @GetMapping("/delven")
    public RedirectView delven(@RequestParam int codcar){
        RedirectView redirect = new RedirectView("/Farmacia/vendas/main");

        new CarDao().delcar(codcar);

        return redirect;
    }

    @GetMapping("/sair")
    public RedirectView sair(HttpServletRequest req){
        RedirectView redirect = new RedirectView("/Farmacia/login");
        req.getSession().invalidate();

        return redirect;
    }

    @GetMapping("/fim")
    public RedirectView fim(){
        RedirectView redirect = new RedirectView("/Farmacia/vendas/inicio");

        new CarDao().fim();

        new CarDao().limpa();

        return redirect;
    }

    @GetMapping("/cancelar")
    public RedirectView cancelar(){
        RedirectView redirect = new RedirectView("/Farmacia/vendas/inicio");

        new CarDao().limpa();

        return redirect;
    }
}
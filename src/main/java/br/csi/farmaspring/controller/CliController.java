package br.csi.farmaspring.controller;

import br.csi.farmaspring.dao.CliDao;
import br.csi.farmaspring.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.lang.ref.Cleaner;

@Controller
@RequestMapping("/cli")
public class CliController {

    @GetMapping("/inicio")
    public String inicio(Model model){
        model.addAttribute("clientes", new CliDao().listCli());

        return "cliInicio";
    }

    @GetMapping("/cadastrar")
    public String cadastro(Model model){

        model.addAttribute("cli", new Cliente());

        return "cadCli";
    }

    @PostMapping("/cadastrar")
    public RedirectView cadCli(@ModelAttribute Cliente cli){
        RedirectView redirect = new RedirectView("/Farmacia/cli/inicio");

        new CliDao().setCliente(cli);

        return redirect;
    }

    @GetMapping("/editar")
    public String editar(@RequestParam String cpfcli, Model model){

        Cliente cli = new CliDao().getCli(cpfcli);

        model.addAttribute("cliente", cli);

        model.addAttribute("cli", new Cliente());

        return "updCli";
    }

    @PostMapping("/editar")
    public RedirectView updCli(@ModelAttribute Cliente cli){
        RedirectView redirect = new RedirectView("/Farmacia/cli/inicio");

        new CliDao().updCli(cli);

        return redirect;
    }

    @GetMapping("/excluir")
    public RedirectView delete(@RequestParam int codcli){
        RedirectView redirect = new RedirectView("/Farmacia/cli/inicio");

        new CliDao().delCli(codcli);

        return redirect;
    }
}

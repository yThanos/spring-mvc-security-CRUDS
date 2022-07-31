package br.csi.farmaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendas")
public class VendasController {

    @GetMapping("/inicio")
    public String inicio(){

        return "vendasInicio";
    }
}
package br.com.escuderodev.precificador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insumos")
public class InsumoMVCController {

    @GetMapping("/cadastro")
    public String carregarFormularioDeCadastro() {
        return "formCadastroInsumo";
    }
}

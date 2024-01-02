package br.com.escuderodev.precificador.controller;

import br.com.escuderodev.precificador.models.insumo.DadosCadastroInsumo;
import br.com.escuderodev.precificador.models.insumo.InsumoRepository;
import br.com.escuderodev.precificador.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/insumos")
public class InsumoMVCController {
    private InsumoService insumoService;

    public InsumoMVCController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping("/cadastro")
    public String carregarFormularioDeCadastro() {
        return "formCadastroInsumo";
    }

    @PostMapping("/cadastro")
    public String cadastrarInsumo(DadosCadastroInsumo dados) {
        insumoService.create(dados);
        return "insumocadastrado";
    }

}

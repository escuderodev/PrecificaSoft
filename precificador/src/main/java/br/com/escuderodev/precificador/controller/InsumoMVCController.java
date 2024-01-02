package br.com.escuderodev.precificador.controller;

import br.com.escuderodev.precificador.models.insumo.DadosCadastroInsumo;
import br.com.escuderodev.precificador.models.insumo.Insumo;
import br.com.escuderodev.precificador.service.InsumoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/insumos")
public class InsumoMVCController {
    private InsumoService insumoService;

    public InsumoMVCController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping("/lista")
    public String carregarListaDeInsumos(Model model) {
        List<Insumo> insumos = insumoService.findAllInsumos();
        model.addAttribute("insumos", insumos);
        return "insumoLista";
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

package br.com.escuderodev.precifica.controller;

import br.com.escuderodev.precifica.models.insumo.DadosAtualizaInsumo;
import br.com.escuderodev.precifica.models.insumo.DadosCadastroInsumo;
import br.com.escuderodev.precifica.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/insumos")
public class InsumoController {

    @Autowired
    private InsumoService service;

    @GetMapping("formulario")
    public String carregarFormularioCadastro(Long id, Model model) {
        if (id != null) {
            var insumo = service.findById(id);
            model.addAttribute("insumo", insumo);
        }
        return "insumo/formulario";
    }

    @GetMapping("lista")
    public String CarregarListaDeInsumos(Model model) {
        model.addAttribute("insumos", service.findAllInsumos());
        return "insumo/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastraInsumo(DadosCadastroInsumo dados) {
        service.create(dados);
        return "redirect:/insumos/lista";
    }

    @PutMapping
    @Transactional
    public String atualizaDadosInsumo(DadosAtualizaInsumo dados) {
        service.update(dados);
        return "redirect:/insumos/lista";
    }

    @DeleteMapping
    @Transactional
    public String deletaCliente(Long id) {
        service.delete(id);
        return"redirect:/insumos/lista";
    }
}

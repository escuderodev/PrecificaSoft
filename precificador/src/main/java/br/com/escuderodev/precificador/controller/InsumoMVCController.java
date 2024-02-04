package br.com.escuderodev.precificador.controller;

import br.com.escuderodev.precificador.models.insumo.DadosAtualizaInsumo;
import br.com.escuderodev.precificador.models.insumo.DadosCadastroInsumo;
import br.com.escuderodev.precificador.models.insumo.Insumo;
import br.com.escuderodev.precificador.service.InsumoService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/insumos")
public class InsumoMVCController {
    private InsumoService insumoService;

    public InsumoMVCController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @GetMapping("cadastro")
    public String loadFormPage(Long id, Model model) {
        if (id != null) {
            var insumo = insumoService.findById(id);
            model.addAttribute("insumo", insumo);
        }
        return "formCadastroInsumo";
    }

    @GetMapping("lista")
    public String loadListPage(Model model) {
        List<Insumo> insumos = insumoService.findAllInsumos();
        model.addAttribute("insumos", insumos);
        return "insumoLista";
    }

    @PostMapping("cadastro")
    @Transactional
    public String createInsumo(DadosCadastroInsumo dados) {
        insumoService.create(dados);
        return "redirect:/insumos/lista";
    }

    @PutMapping("cadastro")
    @Transactional
    public String updateInsumo(DadosAtualizaInsumo dados) {
        insumoService.update(dados);
        return "redirect:/insumos/lista";
    }

    @DeleteMapping
    @Transactional
    public String deleteInsumo(Long id) {
        insumoService.delete(id);
        return"redirect:/insumos/lista";
    }
}

package br.com.escuderodev.precificador.controller;

import br.com.escuderodev.precificador.models.insumo.DadosAtualizaInsumo;
import br.com.escuderodev.precificador.models.insumo.DadosCadastroInsumo;
import br.com.escuderodev.precificador.models.insumo.DadosListagemInsumo;
import br.com.escuderodev.precificador.models.insumo.Insumo;
import br.com.escuderodev.precificador.service.InsumoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/insumos")
public class InsumoAPIController {

    @Autowired
    private InsumoService insumoService;

    @GetMapping
    public ResponseEntity<Page<DadosListagemInsumo>> consultarInsumos(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        var page = insumoService.findAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Insumo> consultarInsumoPorId(@PathVariable Long id) {
        var insumo = insumoService.findById(id);
        return ResponseEntity.ok(insumo);
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarInusmo(@RequestBody @Valid DadosCadastroInsumo dados, UriComponentsBuilder uriBuilder) {
        var insumo = insumoService.create(dados);
        var uri = uriBuilder.path("condutores/{id}").buildAndExpand(insumo.getId()).toUri();
        return ResponseEntity.created(uri).body(insumo);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarInsumo(@RequestBody @Valid DadosAtualizaInsumo dados) {
        insumoService.update(dados);
        var insumoAtualizado = insumoService.findById(dados.id());
        return ResponseEntity.ok(insumoAtualizado);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarInsumo(@PathVariable Long id) {
        insumoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

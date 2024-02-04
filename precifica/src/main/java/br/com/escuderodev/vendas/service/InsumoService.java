package br.com.escuderodev.vendas.service;

import br.com.escuderodev.vendas.controller.exception.NotFoundExceptionController;
import br.com.escuderodev.vendas.models.insumo.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsumoService {

    private InsumoRepository insumoRepository;

    public InsumoService(InsumoRepository insumoRepository) {
        this.insumoRepository = insumoRepository;
    }

    public Page<DadosListagemInsumo> findAll(@PageableDefault(size = 10, page = 0, sort = {"id"}) Pageable paginacao) {
        return insumoRepository.findAll(paginacao).map(DadosListagemInsumo::new);
    }

    public List<Insumo> findAllInsumos() {
        return insumoRepository.findAll();
    }

    public Insumo findById(Long id) {
        return insumoRepository.findById(id).orElseThrow(() -> new NotFoundExceptionController("Insumo não encontrado!"));
    }

    public Insumo create(DadosCadastroInsumo dados) {
        var insumo = new Insumo(dados);
        return insumoRepository.save(insumo);
    }

    public Insumo update(DadosAtualizaInsumo dados) {
        var insumo = insumoRepository.getReferenceById(dados.id());
        insumo.atualizaDados(dados);
        return insumo;
    }

    public void delete(Long id) {
        insumoRepository.deleteById(id);
    }
}

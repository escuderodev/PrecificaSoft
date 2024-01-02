package br.com.escuderodev.precificador.models.insumo;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record DadosListagemInsumo(
        Long id,
        String descricao,
        Integer tamanhoEmbalagem,
        UnidadeMedida unidadeMedida,
        BigDecimal valorEmbalagem,
        BigDecimal valorUnitario,
        String fornecedor
) {
    public DadosListagemInsumo(Insumo insumo) {
        this(insumo.getId(), insumo.getDescricao(), insumo.getTamanhoEmbalagem(), insumo.getUnidadeMedida(), insumo.getValorEmbalagem(), insumo.getValorUnitario(), insumo.getFornecedor());
    }
}

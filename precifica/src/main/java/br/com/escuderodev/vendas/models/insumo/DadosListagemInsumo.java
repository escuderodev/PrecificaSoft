package br.com.escuderodev.vendas.models.insumo;

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


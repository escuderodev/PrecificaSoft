package br.com.escuderodev.precificador.models.insumo;

import java.math.BigDecimal;

public record DadosListagemInsumo(
        Long id,
        String descricao,
        Integer tamanhoEmbalagem,
        BigDecimal valorEmbalagem,
        BigDecimal valorUnitario,
        String fornecedor
) {
    public DadosListagemInsumo(Insumo insumo) {
        this(insumo.getId(), insumo.getDescricao(), insumo.getTamanhoEmbalagem(), insumo.getValorEmbalagem(), insumo.getValorUnitario(), insumo.getFornecedor());
    }
}

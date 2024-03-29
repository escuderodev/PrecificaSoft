package br.com.escuderodev.precifica.models.insumo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record DadosCadastroInsumo(
        @NotBlank
        String descricao,
        @NotNull
        Integer tamanhoEmbalagem,
        @NotNull
        BigDecimal valorEmbalagem,
        @NotNull
        UnidadeMedida unidadeMedida,
        @NotBlank
        String fornecedor
) {
}

package br.com.escuderodev.precifica.models.insumo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity(name = "Insumo")
@Table(name = "insumos")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Insumo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Integer tamanhoEmbalagem;
    @Enumerated(EnumType.STRING)
    private UnidadeMedida unidadeMedida;
    private BigDecimal valorEmbalagem;
    private BigDecimal valorUnitario;
    private String fornecedor;

    public Insumo(DadosCadastroInsumo dados) {
        this.descricao = dados.descricao();
        this.tamanhoEmbalagem = dados.tamanhoEmbalagem();
        this.unidadeMedida = dados.unidadeMedida();
        this.valorEmbalagem = dados.valorEmbalagem();
        this.valorUnitario = valorEmbalagem.divide(BigDecimal.valueOf(tamanhoEmbalagem));
        this.fornecedor = dados.fornecedor();
    }

    public Insumo() {
    }

    public void atualizaDados(DadosAtualizaInsumo dados) {
        this.descricao = dados.descricao();
        this.tamanhoEmbalagem = dados.tamanhoEmbalagem();
        this.unidadeMedida = dados.unidadeMedida();
        this.valorEmbalagem = dados.valorEmbalagem();
        this.valorUnitario = valorEmbalagem.divide(BigDecimal.valueOf(tamanhoEmbalagem));
        this.fornecedor = dados.fornecedor();
    }
}

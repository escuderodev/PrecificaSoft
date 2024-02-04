package br.com.escuderodev.teste.model;

import java.math.BigDecimal;

public class Insumo {
    private String descricao;
    private Integer tamanhoEmbalagem;
    private BigDecimal valorEmbalagem;
    private BigDecimal valorUnitario;

    public Insumo() {
    }

    public Insumo(String descricao, Integer tamanhoEmbalagem, BigDecimal valorEmbalagem) {
        this.descricao = descricao;
        this.tamanhoEmbalagem = tamanhoEmbalagem;
        this.valorEmbalagem = valorEmbalagem;
        this.valorUnitario = valorEmbalagem.divide(BigDecimal.valueOf(tamanhoEmbalagem));
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getTamanhoEmbalagem() {
        return tamanhoEmbalagem;
    }

    public void setTamanhoEmbalagem(Integer tamanhoEmbalagem) {
        this.tamanhoEmbalagem = tamanhoEmbalagem;
    }

    public BigDecimal getValorEmbalagem() {
        return valorEmbalagem;
    }

    public void setValorEmbalagem(BigDecimal valorEmbalagem) {
        this.valorEmbalagem = valorEmbalagem;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "Insumo{" +
                "descricao='" + descricao + '\'' +
                ", tamanhoEmbalagem=" + tamanhoEmbalagem +
                ", valorEmbalagem=" + valorEmbalagem +
                ", valorUnitário=" + valorUnitario +
                '}';
    }
}

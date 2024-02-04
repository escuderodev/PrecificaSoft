package br.com.escuderodev.teste.model;

import java.math.BigDecimal;

public class InsumoComQuantidade {
    private Insumo insumo;
    private Integer quantidade;
    private BigDecimal valorInsumo;

    public InsumoComQuantidade() {
    }

    public InsumoComQuantidade(Insumo insumo, Integer quantidade) {
        this.insumo = insumo;
        this.quantidade = quantidade;
        this.valorInsumo = insumo.getValorUnitario().multiply(BigDecimal.valueOf(quantidade));
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValorInsumo() {
        return valorInsumo;
    }

    public void setValorInsumo(BigDecimal valorInsumo) {
        this.valorInsumo = valorInsumo;
    }

    @Override
    public String toString() {
        return "InsumoComQuantidade{" +
                "insumo=" + insumo +
                ", quantidade=" + quantidade +
                ", valorInsumo=" + valorInsumo +
                '}';
    }
}

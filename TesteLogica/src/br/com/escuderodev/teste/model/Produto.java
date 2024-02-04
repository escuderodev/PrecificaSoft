package br.com.escuderodev.teste.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Produto {
    private String nome;
    private List<InsumoComQuantidade> insumos = new ArrayList<>();
    private BigDecimal custoDeProducao = new BigDecimal(0.0);
    private BigDecimal precoSugerido = new BigDecimal(0.0);

    public Produto() {
    }

    public Produto(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void getInsumos() {
        for (int i = 0; i < this.insumos.size(); i++) {
            System.out.println(this.insumos.get(i).getInsumo() + " " + this.insumos.get(i).getQuantidade());
        };
    }

    public BigDecimal getCustoDeProducao() {
        return custoDeProducao;
    }

    public void addInsumo(InsumoComQuantidade insumo) {
        this.insumos.add(insumo);
        this.custoDeProducao = this.custoDeProducao.add(insumo.getValorInsumo());
        this.precoSugerido = this.custoDeProducao.add(this.custoDeProducao.multiply(BigDecimal.valueOf(0.70)));
    }

    @Override
    public String toString() {
        return String.format("""
                Produto: %s
                Insumos: %s
                Custo de Produção R$: %.2f
                Preço Sugerido R$: %.2f
                """, this.nome, this.insumos, this.custoDeProducao, this.precoSugerido);
    }
}

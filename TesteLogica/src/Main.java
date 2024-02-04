import br.com.escuderodev.teste.model.Insumo;
import br.com.escuderodev.teste.model.InsumoComQuantidade;
import br.com.escuderodev.teste.model.Produto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Produto produto = new Produto("Brigadeiro de Chocolate 100% Cacau");

        Insumo xilitol = new Insumo("Xilitol",1000,new BigDecimal(70.00));
        Insumo chocolate100 = new Insumo("Chocolate 100%", 1000, new BigDecimal(80.00));
        Insumo leiteSemLactose = new Insumo("Leite sem Lactose",1000,new BigDecimal(5.70));

        InsumoComQuantidade xilitolQtd = new InsumoComQuantidade(xilitol, 20);
        InsumoComQuantidade chocolateQtd = new InsumoComQuantidade(chocolate100, 100);
        InsumoComQuantidade leiteSemLactoseQtd = new InsumoComQuantidade(leiteSemLactose, 500);

        produto.addInsumo(xilitolQtd);
        produto.addInsumo(chocolateQtd);
        produto.addInsumo(leiteSemLactoseQtd);

        System.out.println(produto);
    }
}
package br.ufsm.csi.pp.exercicio3_2;

public class Teste {

    public static void main(String[] args) {
        Caixa c1 = new Caixa();
        c1.setValorCaixa(10.0);
        Caixa c2 = new Caixa();
        c2.setValorCaixa(20.0);

        Produto p1 = new Produto();
        p1.setPrecoProduto(1000.0);
        Produto p2 = new Produto();
        p2.setPrecoProduto(2000.0);
        c1.getConteudo().add(p1);
        c1.getConteudo().add(c2);
        c2.getConteudo().add(p2);
        System.out.println("Preco c1: " + c1.getValorTotal());
    }

}

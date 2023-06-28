package br.ufsm.csi.pp.exercicio3_2;

public class Produto implements Encaixotavel {

    private Double precoProduto;

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    @Override
    public Double getValorTotal() {
        return precoProduto;
    }
}

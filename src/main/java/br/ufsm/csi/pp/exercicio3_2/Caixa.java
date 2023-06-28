package br.ufsm.csi.pp.exercicio3_2;

import java.util.ArrayList;
import java.util.List;

public class Caixa implements Encaixotavel {

    private List<Encaixotavel> conteudo = new ArrayList<>();
    private Double valorCaixa;

    public List<Encaixotavel> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<Encaixotavel> conteudo) {
        this.conteudo = conteudo;
    }

    public Double getValorCaixa() {
        return valorCaixa;
    }

    public void setValorCaixa(Double valorCaixa) {
        this.valorCaixa = valorCaixa;
    }

    @Override
    public Double getValorTotal() {
        Double valorTotal = valorCaixa;
        for (Encaixotavel enc : conteudo) {
            valorTotal += enc.getValorTotal();
        }
        return valorTotal;
    }
}

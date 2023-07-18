package br.ufsm.csi.pp.trabalho2.cor;

import br.ufsm.csi.pp.trabalho2.cor.chains.StandardOrderHandler;
import br.ufsm.csi.pp.trabalho2.cor.chains.SuperVipOrderHandler;
import br.ufsm.csi.pp.trabalho2.cor.chains.VipOrderHandler;
import br.ufsm.csi.pp.trabalho2.cor.model.Order;
import br.ufsm.csi.pp.trabalho2.cor.model.OrderHandler;

public class OrderProcessingExample {
    private static OrderHandler orderHandler;
    public static void init() {//monta a corrente
        orderHandler = OrderHandler.link(
                new StandardOrderHandler(),
                new VipOrderHandler(),
                new SuperVipOrderHandler()
        );
    }
    public static void main(String[] args) {//test case
        init();
        orderHandler.handleOrder(new Order(90.0));
        orderHandler.handleOrder(new Order(190.0));
        orderHandler.handleOrder(new Order(890.0));
    }
}
package br.ufsm.csi.pp.trabalho2.cor.chains;

import br.ufsm.csi.pp.trabalho2.cor.model.Order;
import br.ufsm.csi.pp.trabalho2.cor.model.OrderHandler;

import java.text.DecimalFormat;

public class SuperVipOrderHandler extends OrderHandler {
    @Override
    public boolean handleOrder(Order order) {
        if (order.getTotalPrice() > 500.0){
            order.setDiscoutn(0.15);
            System.out.println("Valor com desconto super VIP: R$ "+new DecimalFormat("0.00").format(order.getTotalPrice() - order.getTotalPrice()*order.getDiscoutn()));
            return true;
        } else {
            return proximo(order);
        }
    }
}

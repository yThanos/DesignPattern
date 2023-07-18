package br.ufsm.csi.pp.trabalho2.cor.model;

public abstract class OrderHandler {
    private OrderHandler sucessor;
    public abstract boolean handleOrder(Order order);//cada um vai ver se consegue a partir da sua logica se não chama o proximo()

    public static OrderHandler link(OrderHandler primeiro, OrderHandler... corrente){
        OrderHandler ponteiro = primeiro;
        for(OrderHandler handler: corrente){
            ponteiro.sucessor = handler;//define o sucesor
            ponteiro = handler;//mudar o ponteiro para na proxima repetição definir o sucessor do sucessor
        }
        return primeiro;//retorna o primero para dar inicio
    }

    protected boolean proximo(Order order){
        if (sucessor == null){//se não tiver succesor fim
            System.out.println("Valor sem descontos: R$ "+order.getTotalPrice());
        }
        return sucessor.handleOrder(order);//passa para o proximo
    }
}

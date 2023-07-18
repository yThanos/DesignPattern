package br.ufsm.csi.pp.trabalho2.cor.model;

public class Order {
    private double totalPrice;
    private double discoutn;

    public Order(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Order() {
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscoutn() {
        return discoutn;
    }

    public void setDiscoutn(double discoutn) {
        this.discoutn = discoutn;
    }
}

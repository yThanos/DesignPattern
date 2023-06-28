package br.ufsm.csi.pp.exercicio3_1;

public class Cliente {

    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro();
        CachorroPulaDecorator dec = new CachorroPulaDecorator(cachorro);
        dec.come();
        dec.corre();
    }

}

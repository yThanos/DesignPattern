package br.ufsm.csi.pp.exercicio3_1;

public class ProxyTeste {
    public static void main(String[] args) {
        System.out.println("teste1");
        Cachorro cachorro = new Cachorro().getCachorroProxy();
        System.out.println("teste2");
        cachorro.come();
        cachorro.corre();
    }
}

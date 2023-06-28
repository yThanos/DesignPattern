package br.ufsm.csi.pp.exercicio3_1;

public class CachorroPulaDecorator implements CachorroInterface {

    private CachorroInterface cachorroDecorado;

    public CachorroPulaDecorator(CachorroInterface cachorroDecorado) {
        this.cachorroDecorado = cachorroDecorado;
    }

    @Override
    public void corre() {
        System.out.print("pula e ");
        cachorroDecorado.corre();
    }

    @Override
    public void come() {
        System.out.print("pula e ");
        cachorroDecorado.come();
    }
}

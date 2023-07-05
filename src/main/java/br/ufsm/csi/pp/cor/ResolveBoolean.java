package br.ufsm.csi.pp.cor;

public class ResolveBoolean implements Responsavel{
    @Override
    public boolean resolver(Object obj) {
        if (obj instanceof Boolean){
            if ((Boolean) obj){
                System.out.println("VERDADEIRO");
            }else{
                System.out.println("Falso");
            }
            return true;
        }
        return false;
    }
}

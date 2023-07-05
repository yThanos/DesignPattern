package br.ufsm.csi.pp.cor;

public class ResolveString implements Responsavel{
    @Override
    public boolean resolver(Object obj) {
        if (obj instanceof String){
            System.out.println("\""+obj+"\"");
            return true;
        }else {
            return false;
        }
    }
}

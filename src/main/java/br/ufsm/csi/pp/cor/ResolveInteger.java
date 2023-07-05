package br.ufsm.csi.pp.cor;

public class ResolveInteger implements Responsavel{
    @Override
    public boolean resolver(Object obj) {
        if (obj instanceof Number){
            System.out.println(obj);
            return true;
        }
        return false;
    }
}

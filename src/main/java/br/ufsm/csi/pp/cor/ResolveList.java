package br.ufsm.csi.pp.cor;

import java.util.Collection;
import java.util.List;

public class ResolveList implements Responsavel{
    @Override
    public boolean resolver(Object obj) {
        if (obj instanceof Collection){
            List<Object> objs = (List<Object>) obj;
            for (Object ob: objs){
                new ChainOfResponsability().resolver(ob);
            }
            return true;
        }
        return false;
    }
}

package br.ufsm.csi.pp.cor;

import java.util.ArrayList;
import java.util.List;

public class ChainOfResponsability implements Responsavel{
    List<Responsavel> responsaveis =  new ArrayList<>();

    ChainOfResponsability(){
        responsaveis.add(new ResolveBoolean());
        responsaveis.add(new ResolveInteger());
        responsaveis.add(new ResolveString());
        responsaveis.add(new ResolveList());
    }
    @Override
    public boolean resolver(Object obj) {
        for (int i = 0; i < responsaveis.toArray().length; i++){
            Responsavel responsavel = responsaveis.get(i);
            if(responsavel.resolver(obj)){
                return true;
            }
        }
        return false;
    }
}

package br.ufsm.csi.pp.cor;

import java.util.ArrayList;
import java.util.List;

public class CorBuilder {



    public static void main(String[] args) {
        ChainOfResponsability cor = new ChainOfResponsability();
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(12);
        objects.add("teste");
        objects.add(true);
        Object obj = objects;
        cor.resolver(obj);
    }
    public CorBuilder(){

    }
}

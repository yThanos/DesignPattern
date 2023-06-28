package br.ufsm.csi.pp.exercicio7;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JSONTeste {

    public static void main(String[] args) {
        List<List<String>> ll = new ArrayList<>();
        List<String> l = new ArrayList<>();
        l.add("str1");
        l.add("str2");
        ll.add(l);
        ll.add(l);
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        ClasseExemplo.InnerObject p = ClasseExemplo.InnerObject.builder()
                .id(1111L).nome("fulano").build();
        ClasseExemplo exemplo = ClasseExemplo.builder().ativo(true)
                .id(10L).data(new Date()).pessoa(p)
                .str("exemplo").numeros(numeros).lista(ll).build();
        GeradorJSON geradorJSON = new GeradorJSON();
        System.out.println(geradorJSON.geraJSON(exemplo));
    }

}

package br.ufsm.csi.pp.comand;

import java.util.ArrayList;
import java.util.Map;

public class Insert implements Executable{
    String tabela;
    String[] chaves;
    String[] valores;

    public Insert(String tabela, String[] chaves, String[] valores) {
        this.tabela = tabela;
        this.chaves = chaves;
        this.valores = valores;
    }

    @Override
    public void execute() {
        if(chaves.length == valores.length){
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO ").append(tabela).append(" (");
            for(int i = 0; i<chaves.length; i++){
                sb.append(chaves[i]);
                if(i != chaves.length-1){
                    sb.append(" ,");
                }
            }
            sb.append(") VALUES (");
            for(int i = 0; i<valores.length; i++){
                sb.append(valores[i]);
                if(i != valores.length-1){
                    sb.append(" ,");
                }
            }
            sb.append(")");
            System.out.println(sb);
        }else {
            System.out.println("Quatidade de argumentos invalido!");
        }
    }
}

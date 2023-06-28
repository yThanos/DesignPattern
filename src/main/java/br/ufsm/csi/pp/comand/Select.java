package br.ufsm.csi.pp.comand;

import java.util.ArrayList;

public class Select implements Executable{
    String table;
    String where;
    String[] whereArgs;

    public Select(String table, String where, String[] whereArgs) {
        this.table = table;
        this.where = where;
        this.whereArgs = whereArgs;
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM").append(table).append(" WHERE ");
        String[] wheres = where.split(",");
        for (int i = 0; i<wheres.length; i++){
            wheres[i].replace("?", whereArgs[i]);
            if(i+1 != wheres.length){
                sb.append(" AND ");
            }
        }
        System.out.println(sb);
    }
}

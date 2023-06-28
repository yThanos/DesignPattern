package br.ufsm.csi.pp.comand;

public class Delete implements Executable{
    String table;
    String id;

    public Delete(String table, String id) {
        this.table = table;
        this.id = id;
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ").append(table).append(" WHERE CODIGO = ").append(id);
        System.out.println(sb);
    }
}

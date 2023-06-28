package br.ufsm.csi.pp.exercicio4_2;

import java.sql.Connection;

public interface Pool {

    Connection acquire();
    void release(Connection c);

}

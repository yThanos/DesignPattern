package br.ufsm.csi.pp.singleton;

public final class Singleton extends Thread {

    @Override
    public void run() {
        //codigo pra rodar
    }

    private static Singleton INSTANCIA = new Singleton();

    private Singleton() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //código para rodar na thread
            }
        });

        t.start();
    }

    public static synchronized Singleton getInstance() {
            if (INSTANCIA == null) {
                INSTANCIA = new Singleton();
            }
        return INSTANCIA;
    }
}

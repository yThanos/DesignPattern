package br.ufsm.csi.pp.exercicio2_2;

public class PoolTestCase {

    public static void main(String[] args) {
        new PoolTestCase();
    }

    public PoolTestCase() {
        PoolGenerico<Conexao> pool = new PoolGenerico<>(Conexao.class);
        for (int i = 0; i < 30; i++) {
            new Thread(new ThreadUsaPool(pool)).start();
        }
    }

    public static class ThreadUsaPool implements Runnable {

        private PoolGenerico<Conexao> pool = null;

        public ThreadUsaPool(PoolGenerico<Conexao> pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            while (true) {
                Conexao c = pool.acquire();
                c.select();
                c.update();
                c.delete();
                pool.release(c);
            }
        }
    }

}

package br.ufsm.csi.pp.exercicio4_2;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import lombok.SneakyThrows;

import javax.sql.DataSource;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class PoolConexoes {

    private List<Connection> objetosCriados = new ArrayList<>(20);
    private DataSource dataSource;
    private final List<Connection> objetosDisponiveis = new ArrayList<>(20);
    @SneakyThrows
    public PoolConexoes(DataSource dataSource) {
        this.dataSource = dataSource;
        for (int i = 0; i < 3; i++) {
            Connection con = dataSource.getConnection();
            objetosCriados.add(con);
            objetosDisponiveis.add(con);
        }
    }
    @SneakyThrows
    public Connection acquire() {
        synchronized (objetosDisponiveis) {
            if (!objetosDisponiveis.isEmpty()) {
                return objetosDisponiveis.remove(0);
            } else if (objetosCriados.size() < 20) {
                Connection con = dataSource.getConnection();
                objetosCriados.add(con);
                return con;
            } else {
                System.out.println("[" + Thread.currentThread().getName() + "] Vai dormir...");
                while (objetosDisponiveis.isEmpty()) {
                    objetosDisponiveis.wait();
                }
                System.out.println("[" + Thread.currentThread().getName() + "] Acordou...");
                return objetosDisponiveis.remove(0);
            }
        }
    }

    public void release(Connection con) {
        if (!objetosCriados.contains(con)) {
            throw new IllegalArgumentException("objeto nao pertencente ao pool.");
        }
        synchronized (objetosDisponiveis) {
            objetosDisponiveis.add(con);
            if (objetosDisponiveis.size() == 1) {
                System.out.println("[" + Thread.currentThread().getName() + "] Acordaaaaaaa!!!");
                objetosDisponiveis.notify();
            }
        }
    }

    @SneakyThrows
    private Connection createConnectionProxy(){
        Connection connection = dataSource.getConnection();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setSuperclass(connection.getClass());
        Class proxyClass = proxyFactory.createClass();
        Object proxyInstance = proxyClass.newInstance();
        ((ProxyObject) proxyInstance).setHandler(new ConnectionMethodHandler(connection, this));
        return (Connection) proxyInstance;
    }

    private class ConnectionMethodHandler implements MethodHandler{
        private Connection conOriginal;
        private PoolConexoes poolConexoes;

        public ConnectionMethodHandler(Connection conOriginal, PoolConexoes poolConexoes) {
            this.conOriginal = conOriginal;
            this.poolConexoes = poolConexoes;
        }

        @Override
        public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {
            return  null;
        }
    }
}

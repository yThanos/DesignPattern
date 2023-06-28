package br.ufsm.csi.pp.exercicio2_2;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class PoolGenerico<T> {

    private Class<T> poolClass;
    private List<T> objetosCriados = new ArrayList<>(20);
    private final List<T> objetosDisponiveis = new ArrayList<>(20);
    @SneakyThrows
    public PoolGenerico(Class<T> classe) {
        this.poolClass = classe;
        for (int i = 0; i < 3; i++) {
            T ob = this.poolClass.newInstance();
            objetosCriados.add(ob);
            objetosDisponiveis.add(ob);
        }
    }
    @SneakyThrows
    public T acquire() {
        synchronized (objetosDisponiveis) {
            if (!objetosDisponiveis.isEmpty()) {
                return objetosDisponiveis.remove(0);
            } else if (objetosCriados.size() < 20) {
                T obj = this.poolClass.newInstance();
                objetosCriados.add(obj);
                return obj;
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

    public void release(T t) {
        if (!objetosCriados.contains(t)) {
            throw new IllegalArgumentException("objeto nao pertencente ao pool.");
        }
        synchronized (objetosDisponiveis) {
            objetosDisponiveis.add(t);
            if (objetosDisponiveis.size() == 1) {
                System.out.println("[" + Thread.currentThread().getName() + "] Acordaaaaaaa!!!");
                objetosDisponiveis.notify();
            }
        }
    }
}

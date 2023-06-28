package br.ufsm.csi.pp.exercicio4_2;

import lombok.SneakyThrows;

import java.security.SecureRandom;
import java.util.Random;

public class Conexao {

    private Random rnd = new SecureRandom();

    @SneakyThrows
    public void select() {
        System.out.println("[" + Thread.currentThread().getName() + "] Executando select...");
        Thread.sleep(rnd.nextInt(1000));
        System.out.println("[" + Thread.currentThread().getName() + "] Select executado.");
    }

    @SneakyThrows
    public void update() {
        System.out.println("[" + Thread.currentThread().getName() + "] Executando update...");
        Thread.sleep(rnd.nextInt(1000));
        System.out.println("[" + Thread.currentThread().getName() + "] Update executado.");
    }

    @SneakyThrows
    public void delete() {
        System.out.println("[" + Thread.currentThread().getName() + "] Executando delete...");
        Thread.sleep(rnd.nextInt(1000));
        System.out.println("[" + Thread.currentThread().getName() + "] Delete executado.");
    }

}

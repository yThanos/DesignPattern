package br.ufsm.csi.pp.exercicio3_1;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import lombok.SneakyThrows;

import java.lang.reflect.Method;

public class Cachorro implements CachorroInterface {
    public String acao;
    public Cachorro(){}
    @SneakyThrows
    @Override
    public void corre() {
        acao = acao+"corre";
        System.out.println("corre");
        Thread.sleep(5000);
    }

    @SneakyThrows
    @Override
    public void come() {
        System.out.println("come");
        Thread.sleep(3958);
    }

    @SneakyThrows
    public Cachorro getCachorroProxy(){
        Cachorro cachorroProx = new Cachorro();
        ProxyFactory factory = new ProxyFactory();
        System.out.println("aqui?");
        factory.setSuperclass(cachorroProx.getClass());
        System.out.println("não");
        Class proxyClass = factory.createClass();
        System.out.println("Aqui?");
        Object proxyInstance = proxyClass.newInstance();
        System.out.println("Não");
        ((ProxyObject) proxyInstance).setHandler(new CachorroHnadler(cachorroProx));
        System.out.println("Isso?");
        return (Cachorro) proxyInstance;
    }

    public class CachorroHnadler implements MethodHandler{
        private Cachorro cachorro;

        public CachorroHnadler(Cachorro cachorro){
            this.cachorro = cachorro;
        }

        @Override
        public Object invoke(Object o, Method method, Method method1, Object[] objects) throws Throwable {

                double inicio = System.currentTimeMillis();
                Object x = method1.invoke(o, objects);
                double fim = System.currentTimeMillis() - inicio;
                System.out.println("Tempo decorrido: " + fim);
                return x;
        }
    }
}

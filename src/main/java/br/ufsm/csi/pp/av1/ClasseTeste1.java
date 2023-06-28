package br.ufsm.csi.pp.av1;

public class ClasseTeste1 {

    public String nome;

    @NoCopy
    public Integer idade;

    public static ClasseTeste1 getInstance() {
        ClasseTeste1 classeTeste1 = new ClasseTeste1();
        classeTeste1.idade = 19;
        classeTeste1.nome = "Fulano";
        return classeTeste1;
    }

}

package br.ufsm.csi.pp.trabalho2.command.commands;

import br.ufsm.csi.pp.trabalho2.command.model.Command;

public class CloseDoorCommand implements Command {
    @Override
    public void executa() {
        System.out.println("Fechando a porta");
    }
}

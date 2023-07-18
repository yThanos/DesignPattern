package br.ufsm.csi.pp.trabalho2.command.commands;

import br.ufsm.csi.pp.trabalho2.command.model.Command;

public class PlayMusicCommand implements Command {
    @Override
    public void executa() {
        System.out.println("Tocando musica...");
    }
}

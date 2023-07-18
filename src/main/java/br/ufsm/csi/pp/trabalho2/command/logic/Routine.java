package br.ufsm.csi.pp.trabalho2.command.logic;

import br.ufsm.csi.pp.trabalho2.command.model.Command;
import br.ufsm.csi.pp.trabalho2.command.devices.Luzes;
import br.ufsm.csi.pp.trabalho2.command.devices.Porta;
import br.ufsm.csi.pp.trabalho2.command.devices.SistemaDeSeguranca;
import br.ufsm.csi.pp.trabalho2.command.devices.Som;

import java.util.ArrayList;
import java.util.List;

public class Routine implements Command{
    List<Command> rotina = new ArrayList<>();
    public void PrepareForWar(){//rotina da guerra
        rotina.add(new Porta().desligar());
        rotina.add(new SistemaDeSeguranca().ligar());
        rotina.add(new Luzes().ligar());
        rotina.add(new Som().desligar());
        executa();
    }

    public void prepareForSummer(){//rotina da moleza
        rotina.add(new Porta().desligar());
        rotina.add(new Luzes().desligar());
        rotina.add(new Som().ligar());
        rotina.add(new SistemaDeSeguranca().desligar());
        executa();
    }


    @Override
    public void executa() {//executa os comandos
        for (Command command: rotina){
            command.executa();
        }
    }
}

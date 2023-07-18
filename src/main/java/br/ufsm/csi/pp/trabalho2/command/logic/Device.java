package br.ufsm.csi.pp.trabalho2.command.logic;

import br.ufsm.csi.pp.trabalho2.command.model.Command;

public interface Device {//interface dos dispositivos
    Command ligar();//cada um vai chamar seu respectivo command
    Command desligar();//cada um vai chamar seu respectivo command
}

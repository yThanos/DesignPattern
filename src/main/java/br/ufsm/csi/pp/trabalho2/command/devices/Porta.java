package br.ufsm.csi.pp.trabalho2.command.devices;

import br.ufsm.csi.pp.trabalho2.command.commands.CloseDoorCommand;
import br.ufsm.csi.pp.trabalho2.command.commands.OpenDoorCommand;
import br.ufsm.csi.pp.trabalho2.command.logic.Device;
import br.ufsm.csi.pp.trabalho2.command.model.Command;

public class Porta implements Device {
    @Override
    public Command ligar() {
        return new OpenDoorCommand();
    }

    @Override
    public Command desligar() {
        return new CloseDoorCommand();
    }
}

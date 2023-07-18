package br.ufsm.csi.pp.trabalho2.command.devices;

import br.ufsm.csi.pp.trabalho2.command.commands.TurnOffLightCommand;
import br.ufsm.csi.pp.trabalho2.command.commands.TurnOnLightCommand;
import br.ufsm.csi.pp.trabalho2.command.logic.Device;
import br.ufsm.csi.pp.trabalho2.command.model.Command;

public class Luzes implements Device {
    @Override
    public Command ligar() {
        return new TurnOnLightCommand();
    }

    @Override
    public Command desligar() {
        return new TurnOffLightCommand();
    }
}

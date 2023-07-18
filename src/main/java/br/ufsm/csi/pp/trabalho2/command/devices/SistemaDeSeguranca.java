package br.ufsm.csi.pp.trabalho2.command.devices;

import br.ufsm.csi.pp.trabalho2.command.commands.DisableSucuritySystemCommand;
import br.ufsm.csi.pp.trabalho2.command.commands.StartSecuritySystemCommand;
import br.ufsm.csi.pp.trabalho2.command.logic.Device;
import br.ufsm.csi.pp.trabalho2.command.model.Command;

public class SistemaDeSeguranca implements Device {
    @Override
    public Command ligar() {
        return new StartSecuritySystemCommand();
    }

    @Override
    public Command desligar() {
        return new DisableSucuritySystemCommand();
    }
}

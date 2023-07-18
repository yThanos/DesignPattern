package br.ufsm.csi.pp.trabalho2.command.devices;

import br.ufsm.csi.pp.trabalho2.command.commands.PlayMusicCommand;
import br.ufsm.csi.pp.trabalho2.command.commands.StopMusicCommand;
import br.ufsm.csi.pp.trabalho2.command.logic.Device;
import br.ufsm.csi.pp.trabalho2.command.model.Command;

public class Som implements Device {
    @Override
    public Command ligar() {
        return new PlayMusicCommand();
    }

    @Override
    public Command desligar() {
        return new StopMusicCommand();
    }
}

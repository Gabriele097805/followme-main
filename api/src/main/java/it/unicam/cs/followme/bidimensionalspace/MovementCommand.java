package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.ICommand;
import it.unicam.cs.followme.utilities.RobotCommand;

import java.util.Optional;

public class MovementCommand implements ICommand {

    private final RobotCommand type;
    private String label;
    private final double[] args;

    public MovementCommand(RobotCommand type, double[] args) {
        this.type = type;
        this.args = args;
    }

    public MovementCommand(RobotCommand type, String label, double[] args) {
        this.type = type;
        this.label = label;
        this.args = args;
    }


    @Override
    public RobotCommand getCommandType() {
        return this.type;
    }

    @Override
    public Optional<String> getLabel() {
        return Optional.of(this.label);
    }

    @Override
    public double[] getElements() {
        return this.args;
    }
}

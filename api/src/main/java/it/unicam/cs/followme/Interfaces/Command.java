package it.unicam.cs.followme.Interfaces;

import it.unicam.cs.followme.utilities.RobotCommand;

import java.util.Optional;

/**
 * This interface represent an instruction given to a robot.
 */
public interface Command {

    /**
     * Method to ask the type of command.
     *
     * @return Enum RobotCommand.
     */
    RobotCommand askCommandType();

    /**
     * Method to ask the label if is present.
     *
     * @return an Optional of the value.
     */
    Optional<String> askLabel();

    /**
     * Method to get the Elements.
     *
     * @return a double array with the elements.
     */
    double[] getElements();
}

package it.unicam.cs.followme.Interfaces;

import java.util.Optional;

/**
 * This interface represent a movement instruction given to a robot.
 */
public interface MovementCommand {

    /**
     * Method to ask the label if is present.
     *
     * @return an Optional of the value.
     */
    Optional<String> askLabelIfPresent();

    /**
     * Method to get the Elements.
     *
     * @return a double array with the elements.
     */
    double[] getElements();
}

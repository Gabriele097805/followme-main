package it.unicam.cs.followme.Interfaces;

/**
 * This interface represent a robot in the space.
 */
public interface Robot<P extends Position, C extends Command> {

    /**
     * Return the robot id.
     *
     * @return the id.
     */
    int askId();

    /**
     * @return
     */
    P askPosition();

    /**
     * Return the direction which the robot is moving.
     *
     * @return robot direction.
     */
    P askDirection();

    /**
     * Return the current speed which the robot is moving.
     *
     * @return speed value.
     */
    double askSpeed();

    /**
     * @return
     */
    String askLabel();

    /**
     * This method compute the current state in the robot with the command
     * saved in it to get the next state.
     */
    void executeCommand(C command);
}

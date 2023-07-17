package it.unicam.cs.followme.Interfaces;

/**
 * This interface represent a robot in the space.
 */
public interface Robot<P extends Position, C extends Command> {

    /**
     * @return
     */
    P askPosition();

    Direction askDirection();

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

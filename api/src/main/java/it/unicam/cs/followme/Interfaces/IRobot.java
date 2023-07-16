package it.unicam.cs.followme.Interfaces;

/**
 * This interface represent a robot in the space.
 */
public interface IRobot<P extends IPosition, C extends ICommand> {

    /**
     * @return
     */
    P askPosition();

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

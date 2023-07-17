package it.unicam.cs.followme.Interfaces;

/**
 * This interface represent a robot in the space.
 */
public interface Robot<P extends Position, C extends Command> {

    /**
     * Return the Robot Position.
     *
     * @return a Position.
     */
    P askPosition();

    /**
     * Return the Robot Direction.
     *
     * @return a Direction.
     */
    Direction askDirection();

    /**
     * Return the label reported by the Robot.
     *
     * @return a string that represent a label.
     */
    String askLabel();


    /**
     * This method compute the current state in the robot with the command
     * given as parameter to get the next state.
     *
     * @param command is a record with the information to execute it.
     */
    void executeCommand(C command);
}

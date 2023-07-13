package it.unicam.cs.followme.Interfaces;

/**
 * This interface represent a robot in the space.
 */
public interface Robot<P extends Position> {

    /**
     * Return the robot id.
     *
     * @return the id.
     */
    int getId();

    /**
     * Return the current position.
     *
     * @return the current position.
     */
    P getPosition();

    /**
     * Set a new position for the robot.
     *
     * @param position
     */
    void setPosition(P position);

    /**
     * Return the direction which the robot is moving.
     *
     * @return robot direction.
     */
    P getDirection();

    /**
     * Set a new direction for the robot.
     *
     * @param direction
     */
    void setDirection(P direction);

    /**
     * Return the current speed which the robot is moving.
     *
     * @return speed value.
     */
    double getSpeed();

    /**
     * Set a new speed of the robot.
     *
     * @param speed
     */
    void setSpeed(double speed);

    /**
     *
     *
     * @return
     */
    String getLabel();
}

package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Robot;

import java.util.Objects;

public class SimpleRobot implements Robot {

    private final int id;
    private Position position;
    private Position direction;
    private double speed;

    public SimpleRobot(int id, BidimensionalPosition position, BidimensionalPosition direction, double speed) {
        this.id = id;
        this.position = position;
        this.direction = direction;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(Position direction) {
        this.direction = direction;
    }

    @Override
    public double getSpeed() {
        return speed;
    }

    @Override
    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String getLabel() {
        return null;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleRobot that = (SimpleRobot) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SimpleRobot{" +
                "id=" + id +
                ", position=" + position +
                ", direction=" + direction +
                ", speed=" + speed +
                '}';
    }
}

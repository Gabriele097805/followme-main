package it.unicam.cs.followme.bidimensionalspace.robot;

import it.unicam.cs.followme.Interfaces.Command;
import it.unicam.cs.followme.Interfaces.EnvironmentEntity;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;

import java.util.Objects;

public class SimpleRobot implements Robot<BidimensionalPosition>, EnvironmentEntity {

    private final int id;
    private RobotInfo info;
    private Command command;

    public SimpleRobot(int id, RobotInfo info) {
        this.id = id;
        this.info = info;
        //this.command = new Stop();
    }

    public int askId() {
        return id;
    }

    @Override
    public BidimensionalPosition getPosition() {
        return info.position();
    }

    @Override
    public BidimensionalPosition askDirection() {
        return info.direction();
    }

    @Override
    public double askSpeed() {
        return info.speed();
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public void nextState() {

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
                ", command=" + command +
                '}';
    }
}

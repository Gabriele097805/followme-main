package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SimpleRobot implements Robot<Position, Command> {

    private final int id;
    private final Environment env;
    Position position;
    Position direction;
    double speed;
    private Command command;

    public SimpleRobot(int id, Environment env) throws IOException {
        this.id = id;
        this.env = env;
        Random r = new Random();
        double x = r.nextDouble() * 100;
        double y = r.nextDouble() * 100;
        this.position = new BidimensionalPosition(List.of(x, y));
        this.direction = new BidimensionalPosition(List.of(0.0, 0.0));
        this.speed = 0.0;
        //this.command = new Stop();
    }

    public int askId() {
        return id;
    }

    @Override
    public Position askPosition() {
        return position;
    }

    @Override
    public Position askDirection() {
        return direction;
    }

    @Override
    public double askSpeed() {
        return speed;
    }

    @Override
    public String askLabel() {
        return null;
    }

    @Override
    public void executeCommand(Command command) {

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

package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SimpleRobot implements IRobot<IPosition, ICommand> {

    private final int id;
    private final IEnvironment env;
    private IPosition position;
    private IPosition direction;
    private double speed;
    private ICommand command;

    public SimpleRobot(int id, IEnvironment env) throws IOException {
        this.id = id;
        this.env = env;
        Random r = new Random();
        double x = r.nextDouble() * 100;
        double y = r.nextDouble() * 100;
        this.position = new BidimensionalPosition(List.of(x, y));
        this.direction = new BidimensionalPosition(List.of(0.0, 0.0));
        this.speed = 0.0;
    }

    public int askId() {
        return id;
    }

    @Override
    public IPosition askPosition() {
        return position;
    }

    @Override
    public String askLabel() {
        return null;
    }

    @Override
    public void executeCommand(ICommand command) {
        
    }

    private void move() {
        double[] elements = command.getElements();
        this.direction = new BidimensionalPosition(List.of(elements[0], elements[1]));
        this.speed = elements[2];
        double x = elements[0] * this.speed;
        double y = elements[1] * this.speed;
        this.position = new BidimensionalPosition(List.of(x, y));
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

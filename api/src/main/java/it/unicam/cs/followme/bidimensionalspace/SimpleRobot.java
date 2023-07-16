package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.Interfaces.Command;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class SimpleRobot implements Robot<Position, Command> {

    private final int id;
    private final Environment env;
    private Position position;
    private Position direction;
    private double speed;
    private String label;
    private boolean activeLabel;

    public SimpleRobot(int id, Environment env) throws IOException {
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
    public Position askPosition() {
        return position;
    }

    @Override
    public String askLabel() { return this.label; }

    @Override
    public void executeCommand(Command command) {
        switch (command) {
            case Move(double[] args) -> move(args);
            case Continue() -> nextPosition();
            case Follow(String label, double[] args) -> follow(label, args);
            case Signal(String label) -> signal(label);
            case Unsignal(String label) -> unsignal(label);
            default -> throw new IllegalArgumentException();
        }
    }

    private void nextPosition() {
        List<Double> elements = this.direction.getCoordinates();
        double x = elements.get(0) * this.speed;
        double y = elements.get(1) * this.speed;
        List<Double> coordinates = this.position.getCoordinates();
        x += coordinates.get(0);
        y += coordinates.get(1);
        this.position = new BidimensionalPosition(List.of(x, y));
    }

    private void move(double[] elements) {
        this.direction = new BidimensionalPosition(List.of(elements[0], elements[1]));
        this.speed = elements[2];
        this.nextPosition();
    }

    private void follow(String label, double[] args) {

    }

    private void signal(String label) {
        this.label = label;
        this.activeLabel = true;
    }

    private void unsignal(String label) {
        if (this.activeLabel) {
            if (this.label.equals(label)) {
                this.activeLabel = false;
            }
        }
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
                "id=" + id;
    }
}

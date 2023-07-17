package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.Interfaces.Command;
import it.unicam.cs.followme.bidimensionalspace.commands.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.lang.Math.sqrt;

public class SimpleRobot implements Robot<Position, Command> {

    private final int id;
    private final Environment environment;
    private Position position;
    private Direction direction;
    private double speed;
    private String label;
    private boolean activeLabel;

    public SimpleRobot(int id, Environment environment) {
        this.id = id;
        this.environment = environment;
        Random r = new Random();
        double x = r.nextDouble() * 100;
        double y = r.nextDouble() * 100;
        this.position = new BiDimensionalPosition(List.of(x, y));
        this.direction = new BiDimensionalDirection(List.of(0.0, 0.0));
        this.speed = 0.0;
        this.label = "";
    }

    public SimpleRobot(int id, Environment environment, double x, double y) {
        this.id = id;
        this.environment = environment;
        this.position = new BiDimensionalPosition(List.of(x, y));
        this.direction = new BiDimensionalDirection(List.of(0.0, 0.0));
        this.speed = 0.0;
        this.label = "";
    }

    public int askId() {
        return id;
    }

    @Override
    public Position askPosition() {
        return this.position;
    }

    public Direction askDirection() { return this.direction; }

    @Override
    public String askLabel() { return this.label; }

    @Override
    public void executeCommand(Command command) {
        switch (command) {
            case Move(double[] args) -> move(args);
            case Continue() -> nextPosition();
            case Follow(String label, double[] args) -> follow(label, args);
            case Signal(String label) -> signal(label);
            case UnSignal(String label) -> unSignal(label);
            case Stop() -> stop();
            default -> throw new IllegalArgumentException();
        }
    }

    private void nextPosition() {
        List<Double> elements = this.direction.getDirectionValues();
        double[] dis = normalizedValue(elements.get(0), elements.get(1));
        List<Double> coordinates = this.position.getCoordinates();
        dis[0] = (dis[0] * this.speed) + coordinates.get(0);
        dis[1] = (dis[1] * this.speed) + coordinates.get(1);
        this.position = new BiDimensionalPosition(List.of(dis[0], dis[1]));
    }

    private void move(double[] elements) {
        this.direction = new BiDimensionalDirection(List.of(elements[0], elements[1]));
        this.speed = elements[2];
        this.nextPosition();
    }

    private void follow(String label, double[] args) {
        List<Double> position = this.position.getCoordinates();
        double x = args[0] - position.get(0);
        double y = args[1] - position.get(1);
        double[] direction = normalizedValue(x, y);
        this.direction = new BiDimensionalDirection(List.of(direction[0], direction[1]));
        this.speed = args[2];
        this.nextPosition();
    }

    private Position getAveragePositionFromEnvironment(String label, double distance) {
        List<Position> positionsWithLabel = this.environment.filterPosition(label);
        for (Robot robot : robotsWithLabel) {
            List<Position> closePositions = environment.whoIsClose(robot.askPosition(), distance);
            Position p = environment.averegePosition();
            List<Double> coordinates = p.getCoordinates();
            robot.executeCommand(new Follow(new double[] {coordinates.get(0), coordinates.get(1), args[2]}));
        }
    }

    private void signal(String label) {
        this.label = label;
        this.activeLabel = true;
    }

    private void unSignal(String label) {
        if (this.activeLabel) {
            if (this.label.equals(label)) {
                this.activeLabel = false;
            }
        }
    }

    private void stop() {
        this.direction = new BiDimensionalDirection(List.of(0.0, 0.0));
        this.speed = 0.0;
    }

    /**
     * @param d1
     * @param d2
     * @return
     */
    private double[] normalizedValue(double d1, double d2) {
        double length = sqrt((d1*d1)+(d2*d2));
        double norm1 = d1/length;
        double norm2 = d2/length;
        return new double[] {norm1, norm2};
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
                ", label='" + label + '\'' +
                '}';
    }
}

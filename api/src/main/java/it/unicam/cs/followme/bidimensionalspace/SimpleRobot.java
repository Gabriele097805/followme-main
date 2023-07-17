package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.Interfaces.Command;
import it.unicam.cs.followme.bidimensionalspace.commands.*;

import java.util.*;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;
import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeRandomBetweenTwoDouble;
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
            case MoveCommand(double[] args) -> move(args);
            case RandomCommand(double[] args) -> random(args);
            case ContinueCommand() -> nextPosition();
            case FollowCommand(String label, double[] args) -> follow(label, args);
            case SignalCommand(String label) -> signal(label);
            case UnSignalCommand(String label) -> unSignal(label);
            case StopCommand() -> stop();
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

    private void random(double[] args) {
        double x = computeRandomBetweenTwoDouble(args[0], args[1]);
        double y = computeRandomBetweenTwoDouble(args[2], args[3]);
        this.direction = new BiDimensionalDirection(List.of(x, y));
        this.speed = args[4];
        this.nextPosition();
    }

    private void follow(String label, double[] args) {
        Optional<Position> destination = getAveragePositionFromEnvironment(label, args[0]);
        if (destination.isEmpty()) {
            this.random(new double[] {-1, 1, -1, 1, this.speed});
        }
        List<Double> position = this.position.getCoordinates();
        double x = args[0] - position.get(0);
        double y = args[1] - position.get(1);
        double[] direction = normalizedValue(x, y);
        this.direction = new BiDimensionalDirection(List.of(direction[0], direction[1]));
        this.speed = args[2];
        this.nextPosition();
    }

    private Optional<Position> getAveragePositionFromEnvironment(String label, double distance) {
        List<Position> positionsWithLabel = this.environment.filterPositions(label);
        List<Position> closePositions = whoIsClose(positionsWithLabel, distance);
        Optional<Position> average = getAveragePosition(closePositions);
        return average;
    }

    public List<Position> whoIsClose(List<Position> positions, double distance) {
        List<Position> result = new ArrayList<>();
        for (Position p : positions) {
            if (computeDistanceBetweenTwoPosition(this.position, position) <= distance) {
                result.add(p);
            }
        }
        return result;
    }

    public Optional<Position> getAveragePosition(List<Position> positions) {
        double sumX = 0.0;
        double sumY = 0.0;
        for (Position p : positions) {
            List<Double> coordinates = p.getCoordinates();
            sumX += coordinates.get(0);
            sumY += coordinates.get(1);
        }
        return Optional.of(new BiDimensionalPosition(List.of(sumX/positions.size(), sumY/positions.size())));
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

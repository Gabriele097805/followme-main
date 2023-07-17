package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.Interfaces.Command;
import it.unicam.cs.followme.bidimensionalspace.commands.*;

import java.util.*;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;
import static java.lang.Math.sqrt;

public class SimpleRobot implements Robot<Double, Double> {

    private final int id;
    private final Environment<Double, Double> environment;
    private Position<Double> position;
    private Direction<Double> direction;
    private double speed;
    private String label;
    private boolean activeLabel;

    public SimpleRobot(int id, Environment<Double, Double> environment) {
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

    public SimpleRobot(int id, Environment<Double, Double> environment, double x, double y) {
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
    public Position<Double> askPosition() {
        return this.position;
    }

    public Direction<Double> askDirection() { return this.direction; }

    @Override
    public String askLabel() { return this.label; }

    @Override
    public void executeCommand(Command command) {
        switch (command) {
            case MoveCommand(double[] args) -> move(args);
            case RandomCommand(double[] args) -> random(args);
            case ContinueCommand() -> nextPosition();
            case FollowCommand(String labelToFollow, double[] args) -> follow(labelToFollow, args);
            case SignalCommand(String labelToSignal) -> signal(labelToSignal);
            case UnSignalCommand(String labelToUnSignal) -> unSignal(labelToUnSignal);
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
        System.out.println("Robot number" + this.id + "has moved in " + this.position.toString());
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

    private double computeRandomBetweenTwoDouble(double first, double second) {
        double max = Double.max(first, second);
        double min = Double.min(first, second);
        Random random = new Random();
        return random.nextDouble() * (max - min) + min;
    }

    private void follow(String label, double[] args) {
        Optional<Position<Double>> destination = getAveragePositionFromEnvironment(label, args[0]);
        if (destination.isEmpty()) {
            this.random(new double[] {-1, 1, -1, 1, this.speed});
        }
        var position = this.position.getCoordinates();
        double x = args[0] - position.get(0);
        double y = args[1] - position.get(1);
        double[] direction = normalizedValue(x, y);
        this.direction = new BiDimensionalDirection(List.of(direction[0], direction[1]));
        this.speed = args[1];
        this.nextPosition();
    }

    private Optional<Position<Double>> getAveragePositionFromEnvironment(String label, double distance) {
        List<Position<Double>> positionsWithLabel = this.environment.filterPositions(label);
        List<Position<Double>> closePositions = whoIsClose(positionsWithLabel, distance);
        return getAveragePosition(closePositions);
    }

    private List<Position<Double>> whoIsClose(List<Position<Double>> positions, double distance) {
        List<Position<Double>> result = new ArrayList<>();
        for (Position<Double> p : positions) {
            if (computeDistanceBetweenTwoPosition(this.position, position) <= distance) {
                result.add(p);
            }
        }
        return result;
    }

    private Optional<Position<Double>> getAveragePosition(List<Position<Double>> positions) {
        double sumX = 0.0;
        double sumY = 0.0;
        for (Position<Double> p : positions) {
            List<Double> coordinates = p.getCoordinates();
            sumX += coordinates.get(0);
            sumY += coordinates.get(1);
        }
        return Optional.of(new BiDimensionalPosition(List.of(sumX/positions.size(), sumY/positions.size())));
    }

    private void signal(String label) {
        this.label = label;
        this.activeLabel = true;
        System.out.println("Robot number " + this.id + " has condition: " + this.label);
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
        System.out.println("Robot number " + this.id + " has stopped.");
    }


    /**
     * This utility method normalize two double values necessary to calculate
     * the Direction of a Robot move.
     *
     * @param d1 is the first double.
     * @param d2 is the second double.
     * @return a double array with the normalized value.
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

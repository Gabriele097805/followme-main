package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

public class SimpleRobot implements IRobot<IPosition, ICommand> {

    private final int id;
    private final IEnvironment env;
    private IPosition position;
    private IPosition direction;
    private double speed;
    private String label;
    private boolean activeLabel;

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
    public String askLabel() { return this.label; }

    @Override
    public void executeCommand(ICommand command) {
        switch (command.getCommandType()) {
            case MOVE -> move(command.getElements());
            case CONTINUE -> continueMove();
            case FOLLOW -> follow();
            case SIGNAL -> signal(command.getLabel());
            case UNSIGNAL -> unsignal(command.getLabel());
        }
    }

    private void move(double[] elements) {
        this.direction = new BidimensionalPosition(List.of(elements[0], elements[1]));
        this.speed = elements[2];
        double x = elements[0] * this.speed;
        double y = elements[1] * this.speed;
        List<Double> coordinates = this.position.getCoordinates();
        x += coordinates.get(0);
        y += coordinates.get(1);
        this.position = new BidimensionalPosition(List.of(x, y));
    }

    private void continueMove() {
        List<Double> elements = this.direction.getCoordinates();
        double x = elements.get(0) * this.speed;
        double y = elements.get(1) * this.speed;
        List<Double> coordinates = this.position.getCoordinates();
        x += coordinates.get(0);
        y += coordinates.get(1);
        this.position = new BidimensionalPosition(List.of(x, y));
    }

    private void follow() {

    }

    private void signal(Optional<String> label) {
        this.label = label.get();
        this.activeLabel = true;
    }

    private void unsignal(Optional<String> label) {
        if (this.activeLabel) {
            if (this.label == label.get()) {
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

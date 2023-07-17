package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.Position;

import java.util.Objects;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;

/**
 * This Class represent a Circle Area in a bi-dimensional system.
 */
public class CircleArea implements Area<Double> {
    private final String label;
    private final Position<Double> centre;
    private final double radius;

    public CircleArea(String label, Position<Double> centre, double radius) {
        this.label = label;
        this.centre = centre;
        this.radius = radius;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public boolean isInArea(Position<Double> position) {
        return computeDistanceBetweenTwoPosition(this.centre, position) <= radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CircleArea that = (CircleArea) o;
        return Double.compare(that.radius, radius) == 0 && Objects.equals(label, that.label) && Objects.equals(centre, that.centre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, centre, radius);
    }

    @Override
    public String toString() {
        return "CircleArea{" +
                "label='" + label + '\'' +
                ", centre=" + centre +
                ", radius=" + radius +
                '}';
    }
}

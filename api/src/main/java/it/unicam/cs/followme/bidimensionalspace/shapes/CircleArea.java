package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.bidimensionalspace.BiDimensionalPosition;
import it.unicam.cs.followme.utilities.ShapeData;

import java.util.Objects;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;

public class CircleArea implements Area<BiDimensionalPosition> {

    private String label;
    private BiDimensionalPosition centre;
    private double radius;

    public CircleArea(String label, BiDimensionalPosition centre, double radius) {
        this.label = label;
        this.centre = centre;
        this.radius = radius;
    }

    public CircleArea(ShapeData data) {
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public BiDimensionalPosition askPosition() {
        return this.centre;
    }

    @Override
    public boolean isInArea(BiDimensionalPosition position) {
        return (computeDistanceBetweenTwoPosition(this.centre, position) <= radius) ? true : false;
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

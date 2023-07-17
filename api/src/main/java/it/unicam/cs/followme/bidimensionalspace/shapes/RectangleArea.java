package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.bidimensionalspace.BiDimensionalPosition;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public class RectangleArea implements Area<Double> {

    private final String label;
    private final Position<Double> centre;
    private final double height;
    private final double width;

    public RectangleArea(String label, BiDimensionalPosition centre, double height, double width) {
        this.label = label;
        this.centre = centre;
        this.height = height;
        this.width = width;
    }

    @Override
    public String getLabel() {
        return this.label;
    }

    @Override
    public boolean isInArea(Position<Double> position) {
        List<Double> pCoordinates = position.getCoordinates();
        List<Double> cCoordinates = this.centre.getCoordinates();
        return ((computeDistanceOnAxis(cCoordinates.get(0), pCoordinates.get(0)) < this.width/2) &&
                (computeDistanceOnAxis(cCoordinates.get(1), pCoordinates.get(1)) < this.height/2));
    }

    /**
     * Method used to get the distance between two coordinates on an axis.
     *
     * @param first
     * @param second
     * @return
     */
    private double computeDistanceOnAxis(double first, double second) {
        return abs(first - second);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectangleArea that = (RectangleArea) o;
        return Double.compare(that.height, height) == 0 && Double.compare(that.width, width) == 0 && Objects.equals(label, that.label) && Objects.equals(centre, that.centre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, centre, height, width);
    }

    @Override
    public String toString() {
        return "RectangleArea{" +
                "label='" + label + '\'' +
                ", centre=" + centre +
                ", height=" + height +
                ", width=" + width +
                '}';
    }
}

package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.bidimensionalspace.BiDimensionalPosition;

import java.util.List;
import java.util.Objects;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceOnAxis;

public class RectangleArea implements Area<BiDimensionalPosition> {

    private String label;
    private BiDimensionalPosition centre;
    private double height;
    private double width;

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
    public BiDimensionalPosition askPosition() {
        return this.centre;
    }

    @Override
    public boolean isInArea(BiDimensionalPosition position) {
        List<Double> pCoordinates = position.getCoordinates();
        List<Double> cCoordinates = this.centre.getCoordinates();
        return ((computeDistanceOnAxis(cCoordinates.get(0), pCoordinates.get(0)) < this.width/2) &&
                (computeDistanceOnAxis(cCoordinates.get(1), pCoordinates.get(1)) < this.height/2));
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

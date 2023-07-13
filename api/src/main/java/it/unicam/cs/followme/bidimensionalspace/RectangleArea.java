package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Shape;

import java.util.List;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceOnAxis;

public class RectangleArea implements Shape<BidimensionalPosition> {

    private String label;
    private BidimensionalPosition centre;
    private double height;
    private double width;

    public RectangleArea(String label, BidimensionalPosition centre, double height, double width) {
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
    public BidimensionalPosition getCentre() {
        return this.centre;
    }

    @Override
    public boolean isInArea(BidimensionalPosition position) {
        List<Double> pCoordinates = position.getCoordinates();
        List<Double> cCoordinates = this.centre.getCoordinates();
        return ((computeDistanceOnAxis(cCoordinates.get(0), pCoordinates.get(0)) < this.width/2) &&
                (computeDistanceOnAxis(cCoordinates.get(1), pCoordinates.get(1)) < this.height/2));
    }
}

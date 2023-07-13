package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Shape;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;

public class CircleArea implements Shape<BidimensionalPosition> {

    private String label;
    private BidimensionalPosition centre;
    private double radius;

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public BidimensionalPosition getCentre() {
        return this.centre;
    }

    @Override
    public boolean isInArea(BidimensionalPosition position) {
        boolean result = (computeDistanceBetweenTwoPosition(this.centre, position) <= radius) ? true : false;
        return result;
    }
}

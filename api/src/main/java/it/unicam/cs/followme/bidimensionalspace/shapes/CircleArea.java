package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.EnvironmentEntity;
import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Shape;
import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;

public class CircleArea implements Shape<BidimensionalPosition>, EnvironmentEntity {

    private String label;
    private BidimensionalPosition centre;
    private double radius;

    public CircleArea(String label, BidimensionalPosition centre, double radius) {
        this.label = label;
        this.centre = centre;
        this.radius = radius;
    }

    @Override
    public String getLabel() {
        return null;
    }

    @Override
    public BidimensionalPosition getPosition() {
        return this.centre;
    }

    @Override
    public boolean isInArea(BidimensionalPosition position) {
        return (computeDistanceBetweenTwoPosition(this.centre, position) <= radius) ? true : false;
    }
}

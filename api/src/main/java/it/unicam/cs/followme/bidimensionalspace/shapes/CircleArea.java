package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.EnvironmentEntity;
import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;
import it.unicam.cs.followme.utilities.ShapeData;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;

public class CircleArea implements Area<BidimensionalPosition>, EnvironmentEntity {

    private String label;
    private BidimensionalPosition centre;
    private double radius;

    public CircleArea(String label, BidimensionalPosition centre, double radius) {
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
    public BidimensionalPosition getPosition() {
        return this.centre;
    }

    @Override
    public boolean isInArea(BidimensionalPosition position) {
        return (computeDistanceBetweenTwoPosition(this.centre, position) <= radius) ? true : false;
    }
}

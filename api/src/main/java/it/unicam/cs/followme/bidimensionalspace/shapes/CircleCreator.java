package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.AreaCreator;
import it.unicam.cs.followme.bidimensionalspace.BiDimensionalPosition;
import it.unicam.cs.followme.utilities.ShapeData;

import java.util.List;
import java.util.Optional;

public class CircleCreator implements AreaCreator<Double> {
    @Override
    public Optional<Area<Double>> createArea(ShapeData data) {
        if (!data.shape().equals("CIRCLE")) {
            return Optional.empty();
        }
        double[] args = data.args();
        BiDimensionalPosition p = new BiDimensionalPosition(List.of(args[0], args[1]));
        return Optional.of(new CircleArea(data.label(), p, args[2]));
    }
}

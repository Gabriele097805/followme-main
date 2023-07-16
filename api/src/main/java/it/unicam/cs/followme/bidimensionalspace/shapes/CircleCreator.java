package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.IArea;
import it.unicam.cs.followme.Interfaces.IAreaCreator;
import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CircleCreator implements IAreaCreator {
    @Override
    public Optional<IArea> createArea(ShapeData data) throws IOException {
        if (data.shape() != "CIRCLE") {
            return Optional.empty();
        }
        double[] args = data.args();
        BidimensionalPosition p = new BidimensionalPosition(List.of(args[0], args[1]));
        return Optional.of(new CircleArea(data.label(), p, args[2]));
    }
}
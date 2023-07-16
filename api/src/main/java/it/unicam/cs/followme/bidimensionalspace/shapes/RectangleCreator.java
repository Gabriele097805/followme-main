package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.AreaCreator;
import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class RectangleCreator implements AreaCreator {
    @Override
    public Optional<Area> createArea(ShapeData data) throws IOException {
        if (data.shape() != "RECTANGLE") {
            return Optional.empty();
        }
        double[] args = data.args();
        BidimensionalPosition p = new BidimensionalPosition(List.of(args[0], args[1]));
        return Optional.of(new RectangleArea(data.label(), p, args[2], args[3]));
    }
}

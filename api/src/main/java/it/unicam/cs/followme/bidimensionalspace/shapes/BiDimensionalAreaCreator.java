package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.AreaCreator;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * This class wraps all the implemented AreaCreator to do a control on
 * the shape type and call the corresponding AreaCreator.
 */
public class BiDimensionalAreaCreator implements AreaCreator<Double> {
    List<AreaCreator<Double>> creators;

    public BiDimensionalAreaCreator(List<AreaCreator<Double>> creators) {
        this.creators = creators;
    }

    @Override
    public Optional<Area<Double>> createArea(ShapeData data) throws IOException {
        for (AreaCreator<Double> creator: creators) {
            Optional<Area<Double>> o = creator.createArea(data);
            if (o.isPresent()) {
                return o;
            }
        }
        return Optional.empty();
    }
}

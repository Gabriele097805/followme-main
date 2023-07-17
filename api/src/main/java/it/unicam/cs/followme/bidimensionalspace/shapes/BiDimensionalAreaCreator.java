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
public class BiDimensionalAreaCreator implements AreaCreator {

    List<it.unicam.cs.followme.Interfaces.AreaCreator> creators;

    public BiDimensionalAreaCreator(List<it.unicam.cs.followme.Interfaces.AreaCreator> creators) {
        this.creators = creators;
    }
    @Override
    public Optional<Area> createArea(ShapeData data) throws IOException {
        for (AreaCreator creator: creators) {
            Optional<Area> o = creator.createArea(data);
            if (o.isPresent()) {
                return o;
            }
        }
        return Optional.empty();
    }
}

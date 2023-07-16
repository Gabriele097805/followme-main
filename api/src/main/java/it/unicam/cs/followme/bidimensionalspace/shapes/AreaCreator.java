package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.IArea;
import it.unicam.cs.followme.Interfaces.IAreaCreator;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AreaCreator implements IAreaCreator {

    List<IAreaCreator> creators;

    public AreaCreator(List<IAreaCreator> creators) {
        this.creators = creators;
    }
    @Override
    public Optional<IArea> createArea(ShapeData data) throws IOException {
        for (IAreaCreator creator: creators) {
            Optional<IArea> o = creator.createArea(data);
            if (o.isPresent()) {
                return o;
            }
        }
        return Optional.empty();
    }
}

package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class AreaCreator implements it.unicam.cs.followme.Interfaces.AreaCreator {

    List<it.unicam.cs.followme.Interfaces.AreaCreator> creators;

    public AreaCreator(List<it.unicam.cs.followme.Interfaces.AreaCreator> creators) {
        this.creators = creators;
    }
    @Override
    public Optional<Area> createArea(ShapeData data) throws IOException {
        for (it.unicam.cs.followme.Interfaces.AreaCreator creator: creators) {
            Optional<Area> o = creator.createArea(data);
            if (o.isPresent()) {
                return o;
            }
        }
        return Optional.empty();
    }
}

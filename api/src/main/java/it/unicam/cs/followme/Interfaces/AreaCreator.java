package it.unicam.cs.followme.Interfaces;

import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.util.Optional;

public interface AreaCreator {
    Optional<Area> createArea(ShapeData data) throws IOException;
}

package it.unicam.cs.followme.Interfaces;

import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.util.Optional;

/**
 *
 */
public interface AreaCreator<T> {
    /**
     * The method take as input a ShapeData to create the corresponding
     * Area Object.
     *
     * @param data is a ShapeData with all the information to create an Area.
     * @return an Optional<Area>, if empty it wasn't possible to create the Area
     *          with the taken ShapeData.
     * @throws IOException
     */
    Optional<Area<T>> createArea(ShapeData data) throws IOException;
}

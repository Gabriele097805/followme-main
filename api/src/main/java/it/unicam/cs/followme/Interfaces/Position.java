package it.unicam.cs.followme.Interfaces;

import java.util.List;

/**
 * The coordinates used to keep track of a robot or area spot
 * in the environment are represented by a Position.
 *
 * @param <T> is the type used by the coordinates.
 */
public interface Position<T> {

    List<T> getCoordinates();
}

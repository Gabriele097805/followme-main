package it.unicam.cs.followme.Interfaces;

import java.util.List;

/**
 * A Direction represents the vector in space that the Robot moves through.
 *
 * @param <T> is the type used for the Direction value.
 */
public interface Direction<T> {

    List<T> getDirectionValues();
}

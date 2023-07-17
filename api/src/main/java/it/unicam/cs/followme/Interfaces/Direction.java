package it.unicam.cs.followme.Interfaces;

import java.util.List;

/**
 * A Direction represents the vector in space that the Robot moves through.
 *
 * @param <S> is the type used for the Direction value.
 */
public interface Direction<S> {

    List<S> getDirectionValues();
}

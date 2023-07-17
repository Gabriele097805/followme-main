package it.unicam.cs.followme.Interfaces;

import java.util.List;

/**
 * An Environment whose only responsibility is to
 * store all the Robots and Areas in the simulation.
 */
public interface Environment<T, S> {
    /**
     * @param robots
     * @param areas
     */
    void addElements(List<Robot<T, S>> robots, List<Area<T>> areas);

    /**
     * Return all the entities which implements Robot Interface in the environment.
     *
     * @return a List of Robots.
     */
    List<Robot<T, S>> getRobots();

    /**
     * Return all the entities which implements Area Interface in the environment.
     *
     * @return a List of Areas.
     */
    List<Area<T>> getAreas();

    List<Position<T>> filterPositions(String label);

    List<Robot<T, S>> whoIsInLabel(String label);
}

package it.unicam.cs.followme.Interfaces;

import java.util.List;

/**
 * An Environment whose only responsibility is to
 * store all the Robots and Areas in the simulation.
 *
 * @param <R>
 * @param <A>
 */
public interface Environment<R extends Robot, A extends Area> {
    /**
     * @param robots
     * @param areas
     */
    void addElements(List<R> robots, List<A> areas);

    /**
     * Return all the entities which implements Robot Interface in the environment.
     *
     * @return a List of Robots.
     */
    List<Robot> getRobots();

    /**
     * Return all the entities which implements Area Interface in the environment.
     *
     * @return a List of Areas.
     */
    List<Area> getAreas();


}

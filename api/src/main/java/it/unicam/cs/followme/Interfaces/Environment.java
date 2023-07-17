package it.unicam.cs.followme.Interfaces;

import java.util.List;

/**
 * An Environment whose only responsibility is to
 * store all the Robots and Areas in the simulation.
 */
public interface Environment<T, S> {
    /**
     * Add a List of Robots and Areas in the Environment.
     *
     * @param robots is the list of robots.
     * @param areas is the list of Areas.
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

    /**
     * This method create a list of Position of robots who
     * signal the label.
     *
     * @param label is the label to find
     * @return a list of robots position that signal
     * the wanted label.
     */
    List<Position<T>> filterPositions(String label);

    /**
     * This method search for the robots that are in an area whose label
     * is the parameter.
     *
     * @param label label to find.
     * @return a list of robots whose position is in the looked areas.
     */
    List<Robot<T, S>> whoIsInLabel(String label);
}

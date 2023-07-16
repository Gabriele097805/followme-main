package it.unicam.cs.followme.Interfaces;

import java.util.List;

/**
 * An Environment whose only responsibility is to
 * store all the Robots and Areas in the simulation.
 *
 * @param <R>
 * @param <A>
 */
public interface IEnvironment<R extends IRobot, A extends IArea> {
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
    List<IRobot> getRobots();

    /**
     * Return all the entities which implements Area Interface in the environment.
     *
     * @return a List of Areas.
     */
    List<IArea> getAreas();


}

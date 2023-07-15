package it.unicam.cs.followme.Interfaces;

import java.util.List;

/**
 * An Environment store all the Robots and Areas in the simulation.
 *
 * @param <E> extends the EnvironmentEntity interface which is an element
 *           such as Robots and Areas in the simulation.
 */
public interface Environment<E extends EnvironmentEntity> {

    /**
     * Method to add a list of Robots or Areas in the environment.
     *
     * @param entities is a List of Robots or Areas.
     */
    void addEnvironmentEntities(List<E> entities);

    /**
     * Return all the entities in the environment.
     *
     * @return a List of EnvironmentEntity.
     */
    List<E> getEntities();

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

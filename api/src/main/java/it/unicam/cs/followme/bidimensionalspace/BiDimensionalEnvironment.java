package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.Interfaces.Area;

import java.util.List;

public class BiDimensionalEnvironment<R extends Robot, A extends Area> implements Environment {

    private List<SimpleRobot> robots;
    private List<Area> areas;

    public void addElements(List robots, List areas) {
        this.robots = robots;
        this.areas = areas;
    }

    @Override
    public List<SimpleRobot> getRobots() {
        return this.robots;
    }

    @Override
    public List<Area> getAreas() {
        return this.areas;
    }

    /*public Position getAveragePosition(String label) {

    }*/
}

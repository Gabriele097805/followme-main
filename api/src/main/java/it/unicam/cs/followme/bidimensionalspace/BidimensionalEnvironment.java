package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.Interfaces.Area;

import java.util.List;

public class BidimensionalEnvironment<R extends Robot, A extends Area> implements Environment {

    private List<R> robots;
    private List<A> areas;

    public void addElements(List robots, List areas) {
        this.robots = robots;
        this.areas = areas;
    }

    @Override
    public List<R> getRobots() {
        return this.robots;
    }

    @Override
    public List<A> getAreas() {
        return this.areas;
    }
}

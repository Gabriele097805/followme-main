package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.IEnvironment;
import it.unicam.cs.followme.Interfaces.IRobot;
import it.unicam.cs.followme.Interfaces.IArea;

import java.util.List;

public class BidimensionalEnvironment<R extends IRobot, A extends IArea> implements IEnvironment {

    private List<SimpleRobot> robots;
    private List<IArea> areas;

    public void addElements(List robots, List areas) {
        this.robots = robots;
        this.areas = areas;
    }

    @Override
    public List<SimpleRobot> getRobots() {
        return this.robots;
    }

    @Override
    public List<IArea> getAreas() {
        return this.areas;
    }
}

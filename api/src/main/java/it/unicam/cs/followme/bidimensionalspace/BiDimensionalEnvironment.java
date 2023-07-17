package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.Interfaces.Area;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;

public class BiDimensionalEnvironment<R extends Robot, A extends Area> implements Environment {

    private List<Robot> robots;
    private List<Area> areas;

    public void addElements(List robots, List areas) {
        this.robots = robots;
        this.areas = areas;
    }

    @Override
    public List<Robot> getRobots() {
        return this.robots;
    }

    @Override
    public List<Area> getAreas() {
        return this.areas;
    }

    @Override
    public List<Position> filterPositions(String label) {
        return this.robots.stream()
                .filter(r -> r.askLabel().equals(label))
                .map(r -> r.askPosition())
                .collect(Collectors.toList());
    }

    @Override
    public List<Robot> whoIsInLabel(String label) {
        List<Robot> result = new ArrayList<>();
        for (Robot r : this.robots) {
            for (Area a : this.areas) {
                if (a.isInArea(r.askPosition())) {
                    result.add(r);
                }
            }
        }
        return result;
    }
}

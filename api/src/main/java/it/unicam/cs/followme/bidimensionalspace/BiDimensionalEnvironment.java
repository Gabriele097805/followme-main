package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.Interfaces.Area;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * This Class is a representation of an Environment in a bi-dimensional system.
 */
public class BiDimensionalEnvironment implements Environment<Double, Double> {

    private List<Robot<Double, Double>> robots;
    private List<Area<Double>> areas;

    public void addElements(List<Robot<Double, Double>> robots, List<Area<Double>> areas) {
        this.robots = robots;
        this.areas = areas;
    }

    @Override
    public List<Robot<Double, Double>> getRobots() {
        return this.robots;
    }

    @Override
    public List<Area<Double>> getAreas() {
        return this.areas;
    }

    @Override
    public List<Position<Double>> filterPositions(String label) {
        return this.robots.stream()
                .filter(r -> r.askLabel().equals(label))
                .map(Robot::askPosition)
                .collect(Collectors.toList());
    }

    @Override
    public List<Robot<Double, Double>> whoIsInLabel(String label) {
        List<Robot<Double, Double>> result = new ArrayList<>();
        for (Robot<Double, Double> r : this.robots) {
            for (Area<Double> a : this.areas) {
                if (a.isInArea(r.askPosition())) {
                    result.add(r);
                }
            }
        }
        return result;
    }
}

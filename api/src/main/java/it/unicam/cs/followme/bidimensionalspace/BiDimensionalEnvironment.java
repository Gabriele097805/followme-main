package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.Interfaces.Area;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Robot> whoIsClose()

    public Position getAveragePosition(String label) {
        List<Position> positions = filterPositions(label);
        double sumX = 0.0;
        double sumY = 0.0;
        for (Position p : positions) {
            List<Double> coordinates = p.getCoordinates();
            sumX += coordinates.get(0);
            sumY += coordinates.get(1);
        }
        return new BiDimensionalPosition(List.of(sumX/positions.size(), sumY/positions.size()));
    }

    public List<Position> filterPositions(String label) {
        return this.robots.stream()
                .filter(r -> r.askLabel().equals(label))
                .map(r -> r.askPosition())
                .collect(Collectors.toList());
    }

    public List<Robot> whoIsOnLabel(String label) {
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

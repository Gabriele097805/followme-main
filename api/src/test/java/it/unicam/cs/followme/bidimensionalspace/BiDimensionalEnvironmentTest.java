package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.bidimensionalspace.shapes.CircleArea;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiDimensionalEnvironmentTest {

    @Test
    void getRobotsTest() throws IOException {
        Environment env = new BiDimensionalEnvironment();
        Robot a = new SimpleRobot(0);
        Robot b = new SimpleRobot(1);
        Robot c = new SimpleRobot(2);
        Robot d = new SimpleRobot(3);
        Area area = new CircleArea("label", new BiDimensionalPosition(List.of(6.0, 4.0)), 30.0);
        List<Robot<Position, Command>> robots = List.of(a, b, c, d);
        List<Area> areas = List.of(area);
        env.addElements(robots, areas);
        assertTrue(env.getRobots().equals(List.of(a, b, c, d)));
    }

    @Test
    void getAreasTest() throws IOException {
        Environment env = new BiDimensionalEnvironment();
        Robot a = new SimpleRobot(0);
        Robot b = new SimpleRobot(1);
        Robot c = new SimpleRobot(2);
        Robot d = new SimpleRobot(3);
        Area area = new CircleArea("label", new BiDimensionalPosition(List.of(6.0, 4.0)), 30.0);
        List<Robot> robots = List.of(a, b, c, d);
        List<Area> areas = List.of(area);
        env.addElements(robots, areas);
        assertTrue(env.getAreas().equals(List.of(area)));
    }
}
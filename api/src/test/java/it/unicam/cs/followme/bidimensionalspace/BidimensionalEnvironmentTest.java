package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.Environment;
import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.bidimensionalspace.shapes.CircleArea;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class BidimensionalEnvironmentTest {

    @Test
    void getRobotsTest() throws IOException {
        Environment env = new BidimensionalEnvironment();
        Robot a = new SimpleRobot(1, env);
        Robot b = new SimpleRobot(1, env);
        Robot c = new SimpleRobot(1, env);
        Robot d = new SimpleRobot(1, env);
        Area area = new CircleArea("label", new BidimensionalPosition(List.of(6.0, 4.0)), 30.0);
        List<Robot> robots = List.of(a, b, c, d);
        List<Area> areas = List.of(area);
        env.addElements(robots, areas);
        assertTrue(env.getRobots().equals(List.of(a, b, c, d)));
    }

    @Test
    void getAreasTest() throws IOException {
        Environment env = new BidimensionalEnvironment();
        Robot a = new SimpleRobot(1, env);
        Robot b = new SimpleRobot(1, env);
        Robot c = new SimpleRobot(1, env);
        Robot d = new SimpleRobot(1, env);
        Area area = new CircleArea("label", new BidimensionalPosition(List.of(6.0, 4.0)), 30.0);
        List<Robot> robots = List.of(a, b, c, d);
        List<Area> areas = List.of(area);
        env.addElements(robots, areas);
        assertTrue(env.getAreas().equals(List.of(area)));
    }
}
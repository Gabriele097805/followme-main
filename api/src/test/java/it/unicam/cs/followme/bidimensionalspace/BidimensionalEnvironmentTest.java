package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.IArea;
import it.unicam.cs.followme.Interfaces.IEnvironment;
import it.unicam.cs.followme.Interfaces.IRobot;
import it.unicam.cs.followme.bidimensionalspace.shapes.CircleArea;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BidimensionalEnvironmentTest {

    @Test
    void getRobotsTest() throws IOException {
        IEnvironment env = new BidimensionalEnvironment();
        IRobot a = new SimpleRobot(1, env);
        IRobot b = new SimpleRobot(1, env);
        IRobot c = new SimpleRobot(1, env);
        IRobot d = new SimpleRobot(1, env);
        IArea area = new CircleArea("label", new BidimensionalPosition(List.of(6.0, 4.0)), 30.0);
        List<IRobot> robots = List.of(a, b, c, d);
        List<IArea> areas = List.of(area);
        env.addElements(robots, areas);
        assertTrue(env.getRobots().equals(List.of(a, b, c, d)));
    }

    @Test
    void getAreasTest() throws IOException {
        IEnvironment env = new BidimensionalEnvironment();
        IRobot a = new SimpleRobot(1, env);
        IRobot b = new SimpleRobot(1, env);
        IRobot c = new SimpleRobot(1, env);
        IRobot d = new SimpleRobot(1, env);
        IArea area = new CircleArea("label", new BidimensionalPosition(List.of(6.0, 4.0)), 30.0);
        List<IRobot> robots = List.of(a, b, c, d);
        List<IArea> areas = List.of(area);
        env.addElements(robots, areas);
        assertTrue(env.getAreas().equals(List.of(area)));
    }
}
package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.bidimensionalspace.shapes.CircleArea;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BiDimensionalEnvironmentTest {

    @Test
    void getRobotsTest() {
        Environment<Double, Double> env = new BiDimensionalEnvironment();
        Robot<Double, Double> a = new SimpleRobot(0, env);
        Robot<Double, Double> b = new SimpleRobot(1, env);
        Robot<Double, Double> c = new SimpleRobot(2, env);
        Robot<Double, Double> d = new SimpleRobot(3, env);
        Area<Double> area = new CircleArea("label", new BiDimensionalPosition(List.of(6.0, 4.0)), 30.0);
        List<Robot<Double, Double>> robots = List.of(a, b, c, d);
        List<Area<Double>> areas = List.of(area);
        env.addElements(robots, areas);
        assertEquals(env.getRobots(), List.of(a, b, c, d));
    }

    @Test
    void getAreasTest() {
        Environment<Double, Double> env = new BiDimensionalEnvironment();
        Robot<Double, Double> a = new SimpleRobot(0, env);
        Robot<Double, Double> b = new SimpleRobot(1, env);
        Robot<Double, Double> c = new SimpleRobot(2, env);
        Robot<Double, Double> d = new SimpleRobot(3, env);
        Area<Double> area = new CircleArea("label", new BiDimensionalPosition(List.of(6.0, 4.0)), 30.0);
        List<Robot<Double, Double>> robots = List.of(a, b, c, d);
        List<Area<Double>> areas = List.of(area);
        env.addElements(robots, areas);
        assertEquals(env.getAreas(), List.of(area));
    }
}
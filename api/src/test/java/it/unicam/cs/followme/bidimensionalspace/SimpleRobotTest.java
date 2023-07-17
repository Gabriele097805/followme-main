package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Robot;
import it.unicam.cs.followme.bidimensionalspace.commands.ContinueCommand;
import it.unicam.cs.followme.bidimensionalspace.commands.FollowCommand;
import it.unicam.cs.followme.bidimensionalspace.commands.MoveCommand;
import it.unicam.cs.followme.bidimensionalspace.commands.StopCommand;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRobotTest {

    @Test
    void executeMoveCommandTest() {
        Robot robot = new SimpleRobot(0, 0.0,0.0);
        robot.executeCommand(new MoveCommand(new double[] {0.5, -0.5, 8.0}));
        assertEquals(robot.askPosition(), new BiDimensionalPosition(List.of(5.65685424949238, -5.65685424949238)));
    }

    @Test
    void executeStopCommandTest() {
        Robot robot = new SimpleRobot(0, 0.0,0.0);
        robot.executeCommand(new MoveCommand(new double[] {0.5, -0.5, 8.0}));
        robot.executeCommand(new StopCommand());
        assertEquals(robot.askDirection(), new BiDimensionalDirection(List.of(0.0, 0.0)));
    }

    @Test
    void executeContinueCommandTest() {
        Robot robot = new SimpleRobot(0, 0.0,0.0);
        robot.executeCommand(new MoveCommand(new double[] {0.5, -0.5, 8.0}));
        robot.executeCommand(new ContinueCommand());
        assertEquals(robot.askPosition(), new BiDimensionalPosition(List.of(11.31370849898476, -11.31370849898476)));
    }

    @Test
    void executeFollowCommandTest() {
        Robot robot = new SimpleRobot(0, 0.0,0.0);
        robot.executeCommand(new FollowCommand(new double[] {0.0, 15.0, 8.0}));
        assertEquals(robot.askPosition(), new BiDimensionalPosition(List.of(0.0, 8.0)));
    }
}
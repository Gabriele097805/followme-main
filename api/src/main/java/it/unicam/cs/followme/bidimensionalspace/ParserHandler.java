package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.bidimensionalspace.commands.Continue;
import it.unicam.cs.followme.bidimensionalspace.commands.Move;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;

import java.util.ArrayList;
import java.util.List;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeRandomBetweenTwoDouble;

public class ParserHandler implements FollowMeParserHandler {
    private Environment env;

    private List<Command> commands;

    public ParserHandler(Environment env) {
        this.env = env;
        this.commands = new ArrayList<>();
    }

    @Override
    public void parsingStarted() {

    }

    @Override
    public void parsingDone() {

    }

    @Override
    public void moveCommand(double[] args) {
        Command command = new Move(args);
        List<SimpleRobot> robots = env.getRobots();
        for (SimpleRobot robot : robots) {
            robot.executeCommand(command);
        }
    }

    @Override
    public void moveRandomCommand(double[] args) {
        double x = computeRandomBetweenTwoDouble(args[0], args[1]);
        double y = computeRandomBetweenTwoDouble(args[2], args[3]);
        double[] newArgs = {x, y, args[4]};
        Command command = new Move(newArgs);
        List<SimpleRobot> robots = env.getRobots();
        for (SimpleRobot robot : robots) {
            robot.executeCommand(command);
        }
    }

    @Override
    public void signalCommand(String label) {

    }

    @Override
    public void unsignalCommand(String label) {

    }

    @Override
    public void followCommand(String label, double[] args) {

    }

    @Override
    public void stopCommand() {
        List<Robot> robots = env.getRobots();
        for (Robot robot : robots) {
            robot.executeCommand(new Move(new double[] {0.0, 0.0, 0.0}));
        }
    }

    @Override
    public void continueCommand(int s) {
        Command command = new Continue();
        List<Robot> robots = env.getRobots();
        for (int i = 0; i < s; i++) {
            for (Robot robot : robots) {
                robot.executeCommand(command);
            }
        }
    }

    @Override
    public void repeatCommandStart(int n) {

    }

    @Override
    public void untilCommandStart(String label) {

    }

    @Override
    public void doForeverStart() {

    }

    @Override
    public void doneCommand() {

    }
}

package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.bidimensionalspace.commands.*;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.stream.Collectors;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeRandomBetweenTwoDouble;

public class ParserHandler implements FollowMeParserHandler {
    private Environment env;

    private List<Command> commands;

    private boolean[] iterationCheck;

    public ParserHandler(Environment env) {
        this.env = env;
        this.commands = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.iterationCheck[i] = false;
        }
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
        Command command = new Signal(label);
        List<Robot> robots = env.whoIsInLabel(label);
        for (Robot r : robots) {
            r.executeCommand(command);
        }
    }

    //TODO
    @Override
    public void unsignalCommand(String label) {
        List<Robot> robots = env.getRobots();
        List<Robot> filteredRobots = robots.stream()
                .filter(robot -> robot.askLabel().equals(label))
                .collect(Collectors.toList());
        for (Robot r: filteredRobots) {
            r.executeCommand(new UnSignal(label));
        }
    }

    @Override
    public void followCommand(String label, double[] args) {
        List<Robot> robotsWithLabel = env.filterPosition(label);
        for (Robot robot : robotsWithLabel) {
            List<Robot> closeRobots = env.whoIsClose(robot.askPosition(), args[0]);
            Position p = env.averegePosition();
            List<Double> coordinates = p.getCoordinates();
            robot.executeCommand(new Follow(new double[] {coordinates.get(0), coordinates.get(1), args[2]}));
        }
    }

    @Override
    public void stopCommand() {
        Command command = new Stop();
        /*if (iterationCheck() != -1) {
            this.commands.add(command);
            return;
        }*/
        List<Robot> robots = env.getRobots();
        for (Robot robot : robots) {
            robot.executeCommand(command);
        }
    }

    @Override
    public void continueCommand(int s) {
        Command command = new Continue();
        /*if (iterationCheck() != -1) {
            this.commands.add(command);
            return;
        }*/
        List<Robot> robots = env.getRobots();
        for (int i = 0; i < s; i++) {
            for (Robot robot : robots) {
                robot.executeCommand(command);
            }
        }
    }

    @Override
    public void repeatCommandStart(int n) {
        this.iterationCheck[0] = true;
    }

    @Override
    public void untilCommandStart(String label) {
        this.iterationCheck[1] = true;
    }

    @Override
    public void doForeverStart() {
        this.iterationCheck[2] = true;
    }

    @Override
    public void doneCommand() {
        switch (iterationCheck()) {
            case 0 ->
        }
    }

    private int iterationCheck() {
        for (int i = 0; i < 3; i++){
            if (this.iterationCheck[i]) {
                return i;
            }
        }
        return -1;
    }

    private void repeat(int n) {
        List<Robot> robots = env.getRobots();
        for (int i = 0; i < n; i++) {
            for (Command command : this.commands) {
                for (Robot robot : robots) {
                    robot.executeCommand(command);
                }
            }
        }
    }

    private void until(String label) {
        List<Robot> robots = env.getRobots();
        while (env.whoIsInLabel())
    }





}

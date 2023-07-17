package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.*;
import it.unicam.cs.followme.bidimensionalspace.commands.*;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * This implementation of the FollowMeParser is structured to communicate
 * with an Environment to get access to the Robots. It then takes the commands
 * values from the parser and use them to create a Command record to give
 * to all the Robots in the Environment. It also organizes the iterative
 * commands as Lists of commands and count the turn of the simulation.
 */
public class ParserHandler implements FollowMeParserHandler {
    private final Environment<Double, Double> env;
    private final boolean[] iterationsCheck;
    private List<Command> commands;
    private int repeatArgument;
    private String untilArgument;
    private final int numberOfTurns;
    private int turnCounter;

    public ParserHandler(Environment<Double, Double> env, int simulationTime) {
        this.env = env;
        this.commands = new ArrayList<>();
        this.iterationsCheck = new boolean[] {false, false, false};
        this.numberOfTurns = simulationTime;
    }

    @Override
    public void parsingStarted() {
        System.out.println("Simulation has started.");
        this.turnCounter = 0;
    }

    @Override
    public void parsingDone() {
        System.out.println("Simulation has finished.");
    }

    @Override
    public void moveCommand(double[] args) {
        Command command = new MoveCommand(args);
        if (iterationCheck() != -1) {
            this.commands.add(command);
            return;
        }
        List<Robot<Double, Double>> robots = env.getRobots();
        assignCommand(robots, command);
    }

    @Override
    public void moveRandomCommand(double[] args) {
        Command command = new MoveCommand(args);
        if (iterationCheck() != -1) {
            this.commands.add(command);
            return;
        }
        List<Robot<Double, Double>> robots = env.getRobots();
        assignCommand(robots, command);
    }

    @Override
    public void signalCommand(String label) {
        Command command = new SignalCommand(label);
        if (iterationCheck() != -1) {
            this.commands.add(command);
            return;
        }
        List<Robot<Double, Double>> robots = env.whoIsInLabel(label);
        assignCommand(robots, command);
    }

    @Override
    public void unsignalCommand(String label) {
        Command command = new UnSignalCommand(label);
        List<Robot<Double, Double>> robots = env.getRobots();
        List<Robot<Double, Double>> filteredRobots = robots.stream()
                .filter(robot -> robot.askLabel().equals(label))
                .toList();
        assignCommand(filteredRobots, command);
    }

    @Override
    public void followCommand(String label, double[] args) {
        Command command = new FollowCommand(label, args);
        if (iterationCheck() != -1) {
            this.commands.add(command);
            return;
        }
        List<Robot<Double, Double>> robots = env.getRobots();
        assignCommand(robots, command);
    }

    @Override
    public void stopCommand() {
        Command command = new StopCommand();
        if (iterationCheck() != -1) {
            this.commands.add(command);
            return;
        }
        List<Robot<Double, Double>> robots = env.getRobots();
        assignCommand(robots, command);
    }

    @Override
    public void continueCommand(int s) {
        Command command = new ContinueCommand();
        if (iterationCheck() != -1) {
            this.commands.add(command);
            return;
        }
        List<Robot<Double, Double>> robots = env.getRobots();
        assignCommand(robots, command);
    }

    @Override
    public void repeatCommandStart(int n) {
        this.iterationsCheck[0] = true;
        this.repeatArgument = n;
        this.commands = new ArrayList<>();
    }

    @Override
    public void untilCommandStart(String label) {
        this.iterationsCheck[1] = true;
        this.untilArgument = label;
        this.commands = new ArrayList<>();
    }

    @Override
    public void doForeverStart() {
        this.iterationsCheck[2] = true;
        this.commands = new ArrayList<>();
    }

    @Override
    public void doneCommand() {
        switch (iterationCheck()) {
            case 0 -> {
                repeat(repeatArgument);
                this.iterationsCheck[0] = false;
            }
            case 1 -> {
                until(untilArgument);
                this.iterationsCheck[1] = false;
            }
            case 2 -> {
                forever();
                this.iterationsCheck[2] = false;
            }
        }

    }

    private int iterationCheck() {
        for (int i = 0; i < 3; i++){
            if (this.iterationsCheck[i]) {
                return i;
            }
        }
        return -1;
    }

    private void repeat(int n) {
        List<Robot<Double, Double>> robots = env.getRobots();
        for (int i = 0; i < n; i++) {
            for (Command command : this.commands) {
                assignCommand(robots, command);
            }
        }
    }

    private void until(String label) {
        List<Robot<Double, Double>> robots = env.getRobots();
        while (env.whoIsInLabel(label).isEmpty()) {
            for (Command command : this.commands) {
                assignCommand(robots, command);
            }
        }
    }

    private void forever() {
        List<Robot<Double, Double>> robots = env.getRobots();
        while (isTimeEnded()) {
            for (Command command : this.commands) {
                assignCommand(robots, command);
            }
        }
    }

    private void assignCommand(List<Robot<Double,Double>> robots, Command command) {
        for (Robot<Double, Double> robot : robots) {
            robot.executeCommand(command);
        }
        waitOneSecond();
        isTimeEnded();
    }

    private boolean isTimeEnded() {
        if (this.turnCounter == this.numberOfTurns) {
            this.parsingDone();
            System.exit(0);
        }
        return true;
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(1000);
            this.turnCounter++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

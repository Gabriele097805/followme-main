package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.ICommand;
import it.unicam.cs.followme.Interfaces.IEnvironment;
import it.unicam.cs.followme.bidimensionalspace.commands.MovementCommand;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;
import it.unicam.cs.followme.utilities.RobotCommand;

import java.util.ArrayList;
import java.util.List;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeRandomBetweenTwoDouble;

public class ParserHandler implements FollowMeParserHandler {
    private IEnvironment env;

    private List<ICommand> commands;

    public ParserHandler(IEnvironment env) {
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
        ICommand command = new MovementCommand(RobotCommand.MOVE, args);
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
        ICommand command = new MovementCommand(RobotCommand.MOVE, newArgs);
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
        ICommand command = new MovementCommand(RobotCommand.STOP,
                new double[] {0.0, 0.0, 0.0});
    }

    @Override
    public void continueCommand(int s) {

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

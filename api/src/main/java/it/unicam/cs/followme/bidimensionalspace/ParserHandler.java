package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Command;
import it.unicam.cs.followme.utilities.FollowMeParserHandler;

import java.util.List;

public class ParserHandler implements FollowMeParserHandler {

    private List<Command> commands;

    @Override
    public void parsingStarted() {

    }

    @Override
    public void parsingDone() {

    }

    @Override
    public void moveCommand(double[] args) {

    }

    @Override
    public void moveRandomCommand(double[] args) {

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

package it.unicam.cs.followme.Interfaces;

import it.unicam.cs.followme.utilities.RobotCommand;

import java.util.Optional;

/**
 * This interface represent an instruction given to a robot.
 */
public interface Command { }

public record Move(double[] args) implements Command {}

public record Continue() implements Command {}

public record Follow(double[] args) implements Command {}

public record Signal(String label) implements Command {}

public record Unsignal(String label) implements Command {}

public record Stop() implements Command {}

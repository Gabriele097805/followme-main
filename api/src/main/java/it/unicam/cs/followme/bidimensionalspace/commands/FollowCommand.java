package it.unicam.cs.followme.bidimensionalspace.commands;

import it.unicam.cs.followme.Interfaces.Command;

public record FollowCommand(String label, double[] args) implements Command {
}

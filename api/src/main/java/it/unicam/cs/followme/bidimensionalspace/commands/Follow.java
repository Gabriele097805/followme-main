package it.unicam.cs.followme.bidimensionalspace.commands;

import it.unicam.cs.followme.Interfaces.Command;

public record Follow(String label, double[] args) implements Command {
}

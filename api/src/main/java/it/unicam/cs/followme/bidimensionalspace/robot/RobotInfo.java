package it.unicam.cs.followme.bidimensionalspace.robot;

import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;

record RobotInfo(BidimensionalPosition position, BidimensionalPosition direction, double speed) {
}

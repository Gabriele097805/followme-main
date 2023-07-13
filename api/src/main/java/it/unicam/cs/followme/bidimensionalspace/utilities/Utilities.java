package it.unicam.cs.followme.bidimensionalspace.utilities;

import it.unicam.cs.followme.Interfaces.Position;

import static java.lang.Math.abs;

public class Utilities {

    public static double computeDistanceBetweenTwoPosition(Position position1, Position position2) {
        return 0.0;
    }

    public static double computeDistanceOnAxis(double first, double second) {
        if ((first >= 0 && second < 0) || (first < 0 && second >= 0)) {
            return abs(first) + abs(second);
        } else {
            return Double.max(first, second) - Double.min(first, second);
        }
    }

}

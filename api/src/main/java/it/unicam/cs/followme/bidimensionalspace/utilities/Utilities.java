package it.unicam.cs.followme.bidimensionalspace.utilities;

import it.unicam.cs.followme.Interfaces.IPosition;
import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Utilities {

    /**
     * Method used to get the distance between two <code>BidimensionalPosition</code>.
     *
     * @param position1
     * @param position2
     * @return
     */
    public static double computeDistanceBetweenTwoPosition(BidimensionalPosition position1, BidimensionalPosition position2) {
        double x1 = position1.getCoordinates().get(0);
        double y1 = position1.getCoordinates().get(1);
        double x2 = position2.getCoordinates().get(0);
        double y2 = position2.getCoordinates().get(1);
        return sqrt(((x1 - x2) * (x1 - x2)) + ((y1 - y2) * (y1 - y2)));
    }

    /**
     * Method used to get the distance between two coordinates on an axis.
     *
     * @param first
     * @param second
     * @return
     */
    public static double computeDistanceOnAxis(double first, double second) {
        return abs(first - second);
    }

    public static double computeRandomBetweenTwoDouble(double first, double second) {
        double max = Double.max(first, second);
        double min = Double.min(first, second);
        Random random = new Random();
        return random.nextDouble() * (max - min) + min;
    }

    public static IPosition computeDirection(BidimensionalPosition start, BidimensionalPosition end) throws IOException {
        double x = -Double.compare(start.getCoordinates().get(1), end.getCoordinates().get(1));
        double y = -Double.compare(start.getCoordinates().get(1), end.getCoordinates().get(1));
        return new BidimensionalPosition(List.of(x, y));
    }
}

package it.unicam.cs.followme.bidimensionalspace.utilities;

import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;
import static org.junit.jupiter.api.Assertions.*;

class UtilitiesTest {

    @Test
    void computeDistanceBetweenTwoPositionTest() throws IOException {
        BidimensionalPosition position1 = new BidimensionalPosition(List.of(18.0, 19.0));
        BidimensionalPosition position2 = new BidimensionalPosition(List.of(14.0, 16.0));
        assertTrue(computeDistanceBetweenTwoPosition(position1, position2) == 5.0);
    }

    @Test
    void computeDistanceOnAxis() {
    }
}
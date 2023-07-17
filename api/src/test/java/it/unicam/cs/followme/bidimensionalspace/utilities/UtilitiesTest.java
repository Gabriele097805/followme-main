package it.unicam.cs.followme.bidimensionalspace.utilities;

import it.unicam.cs.followme.bidimensionalspace.BiDimensionalPosition;
import org.junit.jupiter.api.Test;

import java.util.List;

import static it.unicam.cs.followme.bidimensionalspace.utilities.Utilities.computeDistanceBetweenTwoPosition;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilitiesTest {

    @Test
    void computeDistanceBetweenTwoPositionTest() {
        BiDimensionalPosition position1 = new BiDimensionalPosition(List.of(18.0, 19.0));
        BiDimensionalPosition position2 = new BiDimensionalPosition(List.of(14.0, 16.0));
        assertEquals(5.0, computeDistanceBetweenTwoPosition(position1, position2));
    }
}
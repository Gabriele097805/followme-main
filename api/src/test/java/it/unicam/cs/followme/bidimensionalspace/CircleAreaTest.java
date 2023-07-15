package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Shape;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircleAreaTest {

    @Test
    void isInArea() throws IOException {
        Shape Circle = new CircleArea("label",
                new BidimensionalPosition(List.of(3.0, 4.0)),
                30.0);
        Position position1 = new BidimensionalPosition(List.of(17.0, 16.0));
        Position position2 = new BidimensionalPosition(List.of(-13.0, -8.0));
        Position position3 = new BidimensionalPosition(List.of(-4.0, 5.0));
        Position position4 = new BidimensionalPosition(List.of(-4.0, 35.0));
        Position position5 = new BidimensionalPosition(List.of(-28.0, 5.0));
        Position position6 = new BidimensionalPosition(List.of(27.0, 27.0));

        assertTrue(Circle.isInArea(position1));
        assertTrue(Circle.isInArea(position2));
        assertTrue(Circle.isInArea(position3));
        assertFalse(Circle.isInArea(position4));
        assertFalse(Circle.isInArea(position5));
        assertFalse(Circle.isInArea(position6));
    }
}
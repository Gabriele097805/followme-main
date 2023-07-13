package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Shape;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleAreaTest {

    @Test
    void isInArea() throws IOException {
        Shape Rectangle = new RectangleArea("label",
                new BidimensionalPosition(List.of(3.0, 4.0)),
                30.0,
                40.0);
        Position position = new BidimensionalPosition(List.of(24.0, 32.0));
        assertTrue(Rectangle.isInArea(position));
    }
}
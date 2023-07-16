package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.bidimensionalspace.shapes.RectangleArea;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleAreaTest {

    @Test
    void isInArea() throws IOException {
        Area Rectangle = new RectangleArea("label",
                new BiDimensionalPosition(List.of(3.0, 4.0)),
                30.0,
                40.0);
        Position position1 = new BiDimensionalPosition(List.of(17.0, 16.0));
        Position position2 = new BiDimensionalPosition(List.of(-13.0, -8.0));
        Position position3 = new BiDimensionalPosition(List.of(-4.0, 5.0));

        assertTrue(Rectangle.isInArea(position1));
        assertTrue(Rectangle.isInArea(position2));
        assertTrue(Rectangle.isInArea(position3));
    }
}
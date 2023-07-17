package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Position;
import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.bidimensionalspace.BiDimensionalPosition;
import it.unicam.cs.followme.bidimensionalspace.shapes.CircleArea;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CircleAreaTest {

    @Test
    void isInArea() throws IOException {
        Area<Double> Circle = new CircleArea("label",
                new BiDimensionalPosition(List.of(3.0, 4.0)),
                30.0);
        Position<Double> position1 = new BiDimensionalPosition(List.of(17.0, 16.0));
        Position<Double> position2 = new BiDimensionalPosition(List.of(-13.0, -8.0));
        Position<Double> position3 = new BiDimensionalPosition(List.of(-4.0, 5.0));
        Position<Double> position4 = new BiDimensionalPosition(List.of(-4.0, 35.0));
        Position<Double> position5 = new BiDimensionalPosition(List.of(-28.0, 5.0));
        Position<Double> position6 = new BiDimensionalPosition(List.of(27.0, 27.0));

        assertTrue(Circle.isInArea(position1));
        assertTrue(Circle.isInArea(position2));
        assertTrue(Circle.isInArea(position3));
        assertFalse(Circle.isInArea(position4));
        assertFalse(Circle.isInArea(position5));
        assertFalse(Circle.isInArea(position6));
    }
}
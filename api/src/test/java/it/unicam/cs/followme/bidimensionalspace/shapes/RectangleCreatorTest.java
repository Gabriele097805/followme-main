package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.Interfaces.AreaCreator;
import it.unicam.cs.followme.bidimensionalspace.BiDimensionalPosition;
import it.unicam.cs.followme.utilities.ShapeData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RectangleCreatorTest {

    @Test
    void createArea() throws IOException {
        ShapeData data = new ShapeData("label", "RECTANGLE", new double[] {0.0, 0.0, 10.0, 20.0});
        AreaCreator creator = new RectangleCreator();
        Optional<Area> rectangleTest1 = creator.createArea(data);
        assertTrue(rectangleTest1.isPresent());

        Area rectangleTest2 = new RectangleArea(data.label(),
                new BiDimensionalPosition(List.of(0.0, 0.0)),
                10.0,
                20.0);
        assertTrue(rectangleTest1.get().equals(rectangleTest2));
    }
}
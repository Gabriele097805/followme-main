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

class CircleCreatorTest {

    @Test
    void createCircleAreaTest() throws IOException {
        ShapeData data = new ShapeData("label", "CIRCLE", new double[] {0.0, 0.0, 30.0});
        AreaCreator creator = new CircleCreator();
        Optional<Area> circleTest1 = creator.createArea(data);
        assertTrue(circleTest1.isPresent());

        Area circleTest2 = new CircleArea(data.label(),
                new BiDimensionalPosition(List.of(0.0, 0.0)), 30.0);
        assertTrue(circleTest1.get().equals(circleTest2));
    }
}
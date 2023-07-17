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

class BiDimensionalAreaCreatorTest {

    @Test
    void createAreaTest() throws IOException {
        ShapeData data1 = new ShapeData("label", "RECTANGLE", new double[] {0.0, 0.0, 10.0, 20.0});
        ShapeData data2 = new ShapeData("label", "CIRCLE", new double[] {0.0, 0.0, 10.0});
        ShapeData data3 = new ShapeData("label", "TRIANGLE", new double[] {0.0, 0.0, 10.0, 20.0});
        AreaCreator<Double> rectangleCreator = new RectangleCreator();
        AreaCreator<Double> circleCreator = new CircleCreator();
        AreaCreator<Double> creator = new BiDimensionalAreaCreator(List.of(rectangleCreator, circleCreator));

        Optional<Area<Double>> rectangleTest = creator.createArea(data1);
        assertTrue(rectangleTest.isPresent());
        Area<Double> rectangleTest2 = new RectangleArea(data1.label(),
                new BiDimensionalPosition(List.of(0.0, 0.0)),
                10.0,
                20.0);
        assertEquals(rectangleTest.get(), rectangleTest2);

        Optional<Area<Double>> circleTest = creator.createArea(data2);
        assertTrue(circleTest.isPresent());
        Area<Double> circleTest2 = new CircleArea(data1.label(),
                new BiDimensionalPosition(List.of(0.0, 0.0)),
                10.0);
        assertEquals(circleTest.get(), circleTest2);

        Optional<Area<Double>> exceptionTest = creator.createArea(data3);
        assertTrue(exceptionTest.isEmpty());
    }
}
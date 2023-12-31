package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Direction;

import java.util.List;
import java.util.Objects;

/**
 * This Class represent a Direction in a bi-dimensional system.
 */
public class BiDimensionalDirection implements Direction<Double> {

    private final double x;
    private final double y;

    public BiDimensionalDirection(List<Double> values) {
        for (double value : values) {
            if (value < -1 || value > 1) {
                throw new IllegalArgumentException();
            }
        }
        this.x = values.get(0);
        this.y = values.get(1);
    }

    @Override
    public List<Double> getDirectionValues() {
        return List.of(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiDimensionalDirection that = (BiDimensionalDirection) o;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "BiDimensionalDirection{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

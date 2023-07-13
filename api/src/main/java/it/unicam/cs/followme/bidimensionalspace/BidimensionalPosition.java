package it.unicam.cs.followme.bidimensionalspace;

import it.unicam.cs.followme.Interfaces.Position;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class BidimensionalPosition implements Position<Double> {
    private final double x;
    private final double y;

    public BidimensionalPosition(List<Double> coordinates) throws IOException {
        if (coordinates.size() != 2) {
            throw new IOException("Illegal format!");
        }
        this.x = coordinates.get(0);
        this.y = coordinates.get(1);
    }

    @Override
    public List<Double> getCoordinates() {
        return List.of(this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BidimensionalPosition) obj;
        return Double.doubleToLongBits(this.x) == Double.doubleToLongBits(that.x) &&
                Double.doubleToLongBits(this.y) == Double.doubleToLongBits(that.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Position[" +
                "x=" + x + ", " +
                "y=" + y + ']';
    }

}

package it.unicam.cs.followme.bidimensionalspace.shapes;

import it.unicam.cs.followme.Interfaces.Area;
import it.unicam.cs.followme.bidimensionalspace.BidimensionalPosition;
import it.unicam.cs.followme.utilities.ShapeData;

import java.io.IOException;
import java.util.List;

public class AreaFactory {

    //TODO fix factory return null
    public Area<BidimensionalPosition> getShape(ShapeData data) throws IOException {
        switch (data.shape()) {
            case "CIRCLE" ->  {
                double[] args = data.args();
                BidimensionalPosition p = new BidimensionalPosition(List.of(args[0], args[1]));
                return new CircleArea(data.label(), p, args[2]);
            }
            case "RECTANGLE" -> {
                double[] args = data.args();
                BidimensionalPosition p = new BidimensionalPosition(List.of(args[0], args[1]));
                return new RectangleArea(data.label(), p, args[2], args[3]);
            }
        }
        return null;
    }
}

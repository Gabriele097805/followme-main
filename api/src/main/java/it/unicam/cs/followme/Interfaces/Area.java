package it.unicam.cs.followme.Interfaces;

/**
 * This interface represent a shape of space with a label in it.
 */
public interface Area<P extends Position> {
    /**
     * Return the label of the shape.
     *
     * @return the label of the shape.
     */
    String getLabel();

    /**
     * Return the centre of the shape.
     *
     * @return
     */
    P getPosition();

    /**
     * Return the Area of the shape.
     *
     * @return a double that represent the area.
     */
    boolean isInArea(P position);

}
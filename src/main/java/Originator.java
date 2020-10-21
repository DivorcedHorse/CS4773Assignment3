/**
 * Originator by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Object with internal state that we want to save
 *      to return to later. Stores the version of the shape
 *      before we change/update its values.
 */
public class Originator {
    private String shapeType;
    private String color;
    private int xCord;
    private int yCord;
    private boolean isAlive;
    private boolean isSelected;

    public void saveShapeState(Shape shape) {
        shapeType = shape.getShapeType();
        color = shape.getColor();
        xCord = shape.getxCord();
        yCord = shape.getyCord();
        isAlive = shape.getIsAlive();
        isSelected = shape.isSelected();
    }

    /**
     * storeMemento
     *
     * Purpose:
     *      Using the values of the given shape, creates
     *      a new memento (snapshot) of the shape to save.
     *
     * @return new Memento - snapshot of shape.
     */
    public Memento createNewMemento() {
        return new Memento(shapeType, color, xCord, yCord, isAlive, isSelected);
    }

    /**
     * restoreMemento
     *
     * Purpose:
     *      Passed in a memento, loads the values of that
     *      memento for the shape.  The "undo"
     * @param memento
     */
    public void restoreMemento(Memento memento) {
        shapeType = memento.getShapeType();
        color = memento.getColor();
        xCord = memento.getxCord();
        yCord = memento.getyCord();
        isAlive = memento.getIsAlive();
        isSelected = memento.getIsSelected();
    }

    // ------------ GETTERS -----------------

    public String getShapeType() {
        return shapeType;
    }

    public String getColor() {
        return color;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public boolean getIsSelected() {
        return isSelected;
    }


}

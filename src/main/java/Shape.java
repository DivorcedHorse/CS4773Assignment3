import java.util.ArrayList;

/**
 * Shape by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Receiver class for Command Design Pattern.
 *      Abstract class that represents a default shape.
 *      Has the command methods that will be invoked for
 *      the given shape.
 */
public abstract class Shape {
    protected String shapeType;
    protected String color;
    protected int xCord;
    protected int yCord;
    protected boolean isAlive;

    /**
     * COLOR
     *
     * Purpose:
     *      Changes the color for the shape.
     *
     * @param selectedColor - New color for shape
     */
    public void COLOR(String selectedColor) {
        color = selectedColor;
    }

    public void CREATE() {
        setAlive(true);
    }


    /**
     * DELETE
     *
     * Purpose:
     *      Deletes the shape.
     */
    public void DELETE() {
        setAlive(false);
    }

    /**
     * DRAW
     *
     * Purpose:
     *      Abstract so that each subclass of shape
     *      can "draw" their own shape.
     */
    public abstract void DRAW();

    /**
     * DRAWSCENE
     *
     * Purpose:
     *      Will draw the current shape and
     *      all shapes in the drawing list.
     */
    public void DRAWSCENE(Shape shape) {
        shape.DRAW();
    }

    /**
     * MOVE
     *
     * Purpose:
     *      Moves the shapes coordinates.  Updates
     *      their x and y position.
     */
    public void MOVE(int x, int y) {
        xCord = x;
        yCord = y;
    }

    // ------ GETTERS AND SETTERS --------

    public String getShapeType() {
        return shapeType;
    }

    public void setShapeType(String shapeType) {
        this.shapeType = shapeType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getxCord() {
        return xCord;
    }

    public void setxCord(int xCord) {
        this.xCord = xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public void setyCord(int yCord) {
        this.yCord = yCord;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
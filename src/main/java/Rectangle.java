/**
 * Rectangle by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Domain model that represents the shape Rectangle.
 *      Stores simple attributes for a rectangle.
 */
public class Rectangle extends Shape {
    private int height;
    private int width;

    public Rectangle(int newWidth, int newHeight) {
        color = "Red";
        shapeType = "Rectangle";
        width = newWidth;
        height = newHeight;
        xCord = 0;
        yCord = 0;
    }

    /**
     *  DRAW
     *
     *  Purpose:
     *      Prints out the contents of the rectangle.
     */
    public void DRAW() {
        System.out.println(shapeType + ", Color: " + color
                + ", Origin: (" + xCord + "," + yCord +"), Width: "
                + width + ", Height: " + height);
    }

    // -------- GETTERS AND SETTERS -------------

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

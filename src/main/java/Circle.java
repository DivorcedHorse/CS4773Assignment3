/**
 * Circle by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Domain model that represents the shape Circle.
 *      Stores simple attributes for a Circle.
 */
public class Circle extends Shape {
    private int radius;

    public Circle(int newRadius) {
        color = "Blue";
        shapeType = "Circle";
        radius = newRadius;
        xCord = 0;
        yCord = 0;
    }

    /**
     *  DRAW
     *
     *  Purpose:
     *      Prints out the contents of the circle.
     */
    public void DRAW() {
        System.out.println(shapeType + ", Color: " + color
                + ", Origin: (" + xCord + "," + yCord
                +"), Radius: " + radius);

    }

    // -------- GETTERS AND SETTERS -------------

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

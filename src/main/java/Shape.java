import java.awt.*;

public abstract class Shape {

    String color;
    Point origin;

    public Rectangle createRectangle(int x, int y) {
        return new Rectangle(x, y);
    }

    public Circle createCircle(int r) {
        return new Circle(r);
    }

    public void MOVE() {

    }

    public void COLOR() {

    }


    public void DELETE() {

    }

    public void DRAW() {

    }

    public void DRAWSCENE() {

    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

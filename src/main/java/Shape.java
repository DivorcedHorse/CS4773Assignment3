import java.awt.*;

public abstract class Shape {
    String shapeType;
    String color;
    int xCord, yCord;


    public void MOVE(int x, int y) {
        xCord = x;
        yCord = y;

    }

    public void COLOR(String selectedColor) {
        color = selectedColor;

    }


    public void DELETE() {

    }
    public abstract void DRAW();

    public void DRAWSCENE() {

    }



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

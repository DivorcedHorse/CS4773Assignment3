public class Memento {
    String shapeType;
    String color;
    int xCord, yCord;

    public Memento(String shape, String c, int x, int y) {
        shapeType = shape;
        color = c;
        xCord = x;
        yCord = y;
    }

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
}

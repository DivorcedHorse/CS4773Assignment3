public class Originator {
    private String shapeType;
    private String color;
    private int xCord;
    private int yCord;

    public void saveState(Shape shape) {
        shapeType = shape.getShapeType();
        color = shape.getColor();
        xCord = shape.getxCord();
        yCord = shape.getyCord();
    }

    public Memento storeMemento() {
        return new Memento(shapeType, color,xCord,yCord);
    }

    public void restoreMemento(Memento memento) {
        shapeType = memento.getShapeType();
        color = memento.getColor();
        xCord = memento.getxCord();
        yCord = memento.getyCord();
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

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
        //shapeType = "NULL";
    }

    public abstract void DRAW();

    public void DRAWSCENE() {

    }

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
}
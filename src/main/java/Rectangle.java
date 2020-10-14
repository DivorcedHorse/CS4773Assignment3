public class Rectangle extends Shape {

    int height;
    int width;

    public Rectangle(int x, int y) {
        height = x;
        width = y;
        xCord = 0;
        yCord = 0;
        color = "Red";
        shapeType = "Rectangle";
    }

    public void DRAW() {
        //Rectangle, Color: Red, Origin: (10,15), Width: 5, Height: 7
        System.out.println(shapeType + ", Color: " + color + ", Origin: (" + xCord + "," + yCord +"), Width: " + width + ","+ height);

    }

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

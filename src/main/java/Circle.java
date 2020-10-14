public class Circle extends Shape {

    int radius;

    public Circle(int r) {
        radius = r;
        xCord = 0;
        yCord = 0;
        color = "Blue";
        shapeType = "Circle";
    }

    public void DRAW() {
        //Rectangle, Color: Red, Origin: (10,15), Width: 5, Height: 7
        //Circle, Color: Blue, Origin: (7,7), Radius: 10
        System.out.println(shapeType + ", Color: " + color + ", Origin: (" + xCord + "," + yCord +"), Radius: " + radius);

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

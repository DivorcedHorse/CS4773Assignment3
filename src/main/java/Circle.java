public class Circle extends Shape {

    int radius;

    public Circle(int r) {
        radius = r;
        origin.setLocation(0,0);
        color = "Blue";
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}

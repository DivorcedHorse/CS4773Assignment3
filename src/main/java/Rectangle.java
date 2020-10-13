public class Rectangle extends Shape {

    int height;
    int width;

    public Rectangle(int x, int y) {
        height = x;
        width = y;
        origin.setLocation(0,0);
        color = "Red";
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

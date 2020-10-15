public class CreateRectangle extends Command {

    Rectangle newRec;
    int height;
    int width;

    public CreateRectangle(int w, int h) {
        width = w;
        height = h;
        newRec = new Rectangle(width, height);
    }

    @Override
    public void execute(Shape shape) {

    }
}

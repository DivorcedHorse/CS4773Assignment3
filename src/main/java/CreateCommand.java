public class CreateCommand extends Command {
    Shape myShape;

    public CreateCommand(Shape shape) {

        myShape = shape;
    }

    public void execute() {
        myShape.CREATE();
    }
}

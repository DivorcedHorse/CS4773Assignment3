/**
 * DeleteCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for deleting a shape.
 */


public class DeleteCommand extends Command {
    Shape myShape;

    public DeleteCommand(Shape shape) {
        myShape = shape;
    }

    public void execute() {

        myShape.DELETE();
    }
}

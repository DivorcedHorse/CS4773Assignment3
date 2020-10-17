/**
 * DeleteCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for deleting a shape.
 */


public class DeleteCommand extends Command {
    public DeleteCommand(Shape shape) {
        super(shape);
    }

    public void execute() {
        shape.DELETE();
    }
}

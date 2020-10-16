/**
 * DeleteCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for deleting a shape.
 */

public class DeleteCommand extends Command {
    public void execute(Shape shape) {
        shape.DELETE();
    }
}

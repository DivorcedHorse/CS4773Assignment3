/**
 * DrawCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for outputting the shapes contents.
 */

public class DrawCommand extends Command {
    public DrawCommand(Shape shape) {
        super(shape);
    }

    public void execute() {
        shape.DRAW();

    }
}

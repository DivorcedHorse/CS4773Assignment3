/**
 * MoveCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for moving the coordinates/points
 *      of a shape.
 */

public class MoveCommand extends Command {
    private Shape myShape;
    private int xCord;
    private int yCord;

    public MoveCommand(Shape shape, int newXLocation, int newYLocation) {
        myShape = shape;
        xCord = newXLocation;
        yCord = newYLocation;
    }

    public void execute() {
        myShape.MOVE(xCord, yCord);
    }
}


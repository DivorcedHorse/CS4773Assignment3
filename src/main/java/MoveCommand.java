/**
 * MoveCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for moving the coordinates/points
 *      of a shape.
 */

public class MoveCommand extends Command {
    private int xCord;
    private int yCord;

    public MoveCommand(Shape shape, int newXLocation, int newYLocation) {
        super(shape);
        xCord = newXLocation;
        yCord = newYLocation;
    }

    public void execute() {
        shape.MOVE(xCord, yCord);
    }
}

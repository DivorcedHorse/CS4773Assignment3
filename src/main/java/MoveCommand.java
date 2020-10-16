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

    public MoveCommand(int newXLocation, int newYLocation){
        xCord = newXLocation;
        yCord = newYLocation;
    }

    public void execute(Shape shape) {
        shape.MOVE(xCord, yCord);
    }
}

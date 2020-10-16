/**
 * ShapeInvoker by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      calls storeAndExecute() on the command, and can do
 *      other things with Commands, like swapping them out,
 *      bookkeeping, logging, and determine when
 *      Commands execute
 */
import java.util.ArrayList;
import java.util.List;

public class ShapeInvoker {

    private List<Command> commandHistory;
    private Shape currentShape;

    public ShapeInvoker(Shape myShape) {
        this.currentShape = myShape;
        commandHistory = new ArrayList<Command>();
    }

    /**
     * storeAndExecute
     *
     * Purpose:
     *      Given a new command, adds it to the shapes
     *      history of commands as well as calling the
     *      execute method for that command.
     *
     * @param command
     */
    public void storeAndExecute(Command command) {
        commandHistory.add(command);
        command.execute(currentShape);
    }

    /**
     * printHistory
     *
     * Purpose:
     *      Prints out the commands of the shape.
     */
    public void printHistory() {
        System.out.println(commandHistory);
    }

    // ----------- GETTERS AND SETTERS -------------

    public Shape getShape() {
        return currentShape;
    }

    public void setShape(Shape shape) {
        currentShape = shape;
    }

}


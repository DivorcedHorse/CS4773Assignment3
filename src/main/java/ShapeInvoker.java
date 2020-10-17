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
    private ArrayList<Shape> shapes;

    public ShapeInvoker() {
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
        command.execute();
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

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }
}


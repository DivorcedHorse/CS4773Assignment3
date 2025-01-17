/**
 * ShapeInvoker by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      calls storeAndExecute() on the command, and can do
 *      other things with Commands, like swapping them out,
 *      bookkeeping, logging, and determine when
 *      Commands execute. Our drawingList.
 */
import java.util.ArrayList;
import java.util.Stack;

public class ShapeInvoker {
    private Stack<Command> commandHistory;
    private Stack<SelectCommand> selectHistory;
    private ArrayList<Shape> shapes;
    private Shape currentShape;

    public ShapeInvoker() {
        commandHistory = new Stack<>();
        selectHistory = new Stack<>();
        shapes = new ArrayList<>();
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
        if (command instanceof SelectCommand) {
            selectHistory.add((SelectCommand) command);
        }
        commandHistory.add(command);
        command.execute();
    }

    public void executeUndo(UndoCommand command) {
        command.execute();
    }

    /**
     * getLastSelect
     *
     * Purpose:
     *      Returns the shape of the previously
     *      selected command (undo select).
     *
     * @return - Shape
     */
    public Shape getLastSelect() {
        if (selectHistory.size() >= 2) {
            selectHistory.pop();
            SelectCommand tmp = selectHistory.pop();

            int index = tmp.getIndex();

            return shapes.get(index);
        }
        else {
            return null;
        }
    }

    /**
     * getSelectHistoryIndex
     *
     * Purpose:
     *      Returns the index of the last selected shape.
     * @return
     */
    public int getSelectHistoryIndex() {
        return selectHistory.peek().getIndex();
    }

    /**
     * printHistory
     *
     * Purpose:
     *      Prints out the commands of the shape.
     */
    public void printHistory() {
        System.out.println(selectHistory);
    }

    // ----------- GETTERS AND SETTERS -------------

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    public void setShapes(ArrayList<Shape> shapes) {
        this.shapes = shapes;
    }

    public Stack<Command> getCommandHistory() {
        return commandHistory;
    }

    public void setCommandHistory(Stack<Command> commandHistory) {
        this.commandHistory = commandHistory;
    }


    public Stack<SelectCommand> getSelectHistory() {
        return selectHistory;
    }

    public void setSelectHistory(Stack<SelectCommand> selectHistory) {
        this.selectHistory = selectHistory;
    }


    public Shape getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(Shape currentShape) {
        this.currentShape = currentShape;
    }
}
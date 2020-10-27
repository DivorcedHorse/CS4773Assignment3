/**
 * UndoCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for reverting the current shape
 *      back to its old values.
 */
public class UndoCommand extends Command {
    static ShapeInvoker shapeInvoker;
    static Originator originator;
    static Caretaker caretaker;

    public UndoCommand(ShapeInvoker shape, Originator orig, Caretaker care) {
        shapeInvoker = shape;
        originator = orig;
        caretaker = care;
    }

    public void execute() {
        UNDO();
    }

    /**
     * UNDO
     *
     * Purpose:
     *      Grabs the last command that was given and
     *      performs the necessary undo to change it back to its
     *      original shape.
     */
    private void UNDO() {
        Command tmpCommand = shapeInvoker.getCommandHistory().pop();

        if (tmpCommand instanceof SelectCommand) {
            shapeInvoker.setCurrentShape(shapeInvoker.getLastSelect());

        } else if (tmpCommand instanceof DeleteCommand) {
            shapeInvoker.setCurrentShape(shapeInvoker.getShapes().get(shapeInvoker.getSelectHistoryIndex()));
            shapeInvoker.getCurrentShape().setAlive(true);

        } else if (tmpCommand instanceof CreateCommand) {
            shapeInvoker.setCurrentShape(shapeInvoker.getShapes().get(shapeInvoker.getShapes().size() - 1));
            shapeInvoker.getCurrentShape().setAlive(false);
            shapeInvoker.getShapes().remove(shapeInvoker.getShapes().size() - 1);
            shapeInvoker.setCurrentShape(null);

        } else if (tmpCommand instanceof DrawCommand || tmpCommand instanceof DrawSceneCommand) {
            return;
        } else {
            restoreShapeState();
        }
    }

    private static void restoreShapeState() {
        originator.restoreMemento(caretaker.getMemento());
        shapeInvoker.getCurrentShape().setColor(originator.getColor());
        shapeInvoker.getCurrentShape().setxCord(originator.getxCord());
        shapeInvoker.getCurrentShape().setyCord(originator.getyCord());
        shapeInvoker.getCurrentShape().setAlive(originator.getIsAlive());
        shapeInvoker.getCurrentShape().setSelected(originator.getIsSelected());
    }
}

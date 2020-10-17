import java.util.ArrayList;

/**
 * Command by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Encapsulates everything needed to
 *      perform the action on the Receiver.
 */

public abstract class Command {
    protected Shape shape;
    protected ArrayList<Shape> allShapes;
    protected int position;

    public Command(Shape newShape) {
        shape = newShape;
    }

    public Command(ArrayList<Shape> allPassedShapes) {
        allShapes = allPassedShapes;
    }

    public Command() {
    }

        /**
         * execute
         *
         * Purpose:
         *      The subclass command will execute corresponding
         *      shape method.
         */
    public abstract void execute();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
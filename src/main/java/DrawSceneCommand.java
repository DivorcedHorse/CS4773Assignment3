/**
 * DrawSceneCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Draws/outputs the contents of all shapes
 *      in the drawing list.
 */
import java.util.ArrayList;

public class DrawSceneCommand extends Command {
    private ArrayList<ShapeInvoker> allShapes;

    public DrawSceneCommand(ArrayList<ShapeInvoker> passedShapes) {
        allShapes = passedShapes;
    }

    public void execute(Shape shape) {
        shape.DRAWSCENE(allShapes);
    }
}

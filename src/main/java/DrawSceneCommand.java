/**
 * DrawSceneCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Draws/outputs the contents of all shapes
 *      in the drawing list.
 */


import java.util.ArrayList;

public class DrawSceneCommand extends Command {
    //private ArrayList<Shape> allShapes;

    public DrawSceneCommand(ArrayList<Shape> passedShapes) {
        super(passedShapes);
    }

    public void execute() {
        for (Shape shape : allShapes) {
            shape.DRAWSCENE(shape);
        }
    }
}
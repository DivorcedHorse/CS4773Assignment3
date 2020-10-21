/**
 * DrawCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for outputting the shapes contents.
 */

public class DrawCommand extends Command {
    Shape myShape;

    public DrawCommand(Shape shape) {
        myShape = shape;
    }

    public void execute() {
        if(myShape == null){
            System.out.println("ERROR: no currently selected shape");
            return;
        }
        myShape.DRAW();

    }
}

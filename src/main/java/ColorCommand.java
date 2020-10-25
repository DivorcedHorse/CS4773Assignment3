/**
 * ColorCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for changing color.
 */
public class ColorCommand extends Command {
    Shape myShape;
    String curColor;

    public ColorCommand(Shape shape, String color) {
        myShape = shape;
        curColor = color;
    }

    public void execute() {
        myShape.COLOR(curColor);
    }
}

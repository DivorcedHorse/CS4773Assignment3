/**
 * ColorCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for changing color.
 */
public class ColorCommand extends Command {
    Shape myshape;
    String curColor;
    public ColorCommand(Shape shape, String color) {
        myshape = shape;
        curColor = color;
    }

    public void execute() {
        myshape.COLOR(curColor);

    }
}

/**
 * ColorCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for changing color.
 */
public class ColorCommand extends Command {
    String curColor;

    public ColorCommand(Shape shape, String color) {
        super(shape);
        curColor = color;
    }

    public void execute() {
        shape.COLOR(curColor);

    }
}

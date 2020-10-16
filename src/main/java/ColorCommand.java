/**
 * ColorCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Command class for changing color.
 */
public class ColorCommand extends Command {
    String curColor;

    public ColorCommand(String color){
        curColor = color;
    }

    public void execute(Shape shape) {
        shape.COLOR(curColor);

    }
}

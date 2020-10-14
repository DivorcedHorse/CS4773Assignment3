public class ColorCommand extends Command {
    String curColor;

    public ColorCommand(String color){
        curColor = color;

    }

    public void execute(Shape shape) {
        shape.COLOR(curColor);

    }
}

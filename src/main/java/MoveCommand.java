public class MoveCommand extends Command {
    int xCord, yCord;
    public MoveCommand(int x, int y){
        xCord = x;
        yCord = y;

    }

    public void execute(Shape shape) {
        shape.MOVE(xCord, yCord);
    }
}

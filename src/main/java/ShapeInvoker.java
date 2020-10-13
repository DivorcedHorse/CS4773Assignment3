import java.util.ArrayList;
import java.util.List;

public class ShapeInvoker {

    private List<Command> commandHistory;
    private Shape currentShape;

    public ShapeInvoker(Shape myShape) {
        this.currentShape = myShape;
        commandHistory = new ArrayList<Command>();
    }

    public void storeAndExecute(Command command) {
        commandHistory.add(command);
        command.execute(currentShape);
    }

    public void printHistory() {
        System.out.println(commandHistory);
    }
}


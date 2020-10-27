/**
 * ProcessFile By Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Given an input file, reads through the lines
 *      and determines which command must be performed
 *      to satisfy the request.
 *
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProcessFile {
    static ShapeInvoker shapeInvoker = new ShapeInvoker();
    static Originator originator = new Originator();
    static Caretaker caretaker = new Caretaker();

    /**
     * main
     *
     * Purpose:
     *      Reads an input file until an empty line occurs.
     *      Parses the line and passes it into determineAndExecute
     *      which determines what command should be created.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            File inputFile = new File("../../InputSet1.txt");
            Scanner myReader = new Scanner(inputFile);

            while (myReader.hasNextLine()) {
                String commandText = myReader.nextLine();
                String[] commandParts = commandText.split(" ");
                String command = commandParts[0];

                determineAndExecute(commandText, commandParts, command);
            }
            myReader.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }
    }

    private static void determineAndExecute(String commandText, String[] commandParts, String command) {
        switch (command) {
            case "COLOR":
                saveCurrentShape();
                shapeInvoker.storeAndExecute(new ColorCommand(shapeInvoker.getCurrentShape(), commandParts[1]));
                break;
            case "CREATE":
                shapeInvoker.storeAndExecute(new CreateCommand(commandText, shapeInvoker));
                break;
            case "DELETE":
                saveCurrentShape();
                shapeInvoker.storeAndExecute(new DeleteCommand(shapeInvoker.getCurrentShape()));
                shapeInvoker.setCurrentShape(null);
                break;
            case "DRAW":
                shapeInvoker.storeAndExecute(new DrawCommand(shapeInvoker.getCurrentShape()));
                break;
            case "DRAWSCENE":
                shapeInvoker.storeAndExecute(new DrawSceneCommand(shapeInvoker.getShapes()));
                break;
            case "MOVE":
                saveCurrentShape();
                shapeInvoker.storeAndExecute(new MoveCommand(shapeInvoker.getCurrentShape()
                        , Integer.parseInt(commandParts[1]), Integer.parseInt(commandParts[2])));
                break;
            case "SELECT":
                int selectIndex = Integer.parseInt(commandParts[1]);
                if (selectIndex > shapeInvoker.getShapes().size()) {
                    System.out.println("ERROR: Invalid shape for SELECT");
                    break;
                }
                shapeInvoker.storeAndExecute(new SelectCommand(selectIndex - 1, commandText, shapeInvoker));
                break;
            case "UNDO":
                shapeInvoker.executeUndo(new UndoCommand(shapeInvoker, originator, caretaker));
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    private static void saveCurrentShape() {
        originator.saveShapeState(shapeInvoker.getCurrentShape());
        caretaker.addMemento(originator.createNewMemento());

    }
}
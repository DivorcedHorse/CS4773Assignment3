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
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessFile {
    static ShapeInvoker shapeInvoker = new ShapeInvoker();
    static Originator originator = new Originator();
    static Caretaker caretaker = new Caretaker();
    static ArrayList<Shape> shapes = shapeInvoker.getShapes();
    static int careTakerIndex = 0;

    /**
     * main
     *
     * Purpose:
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
                    System.out.println("ERROR: Invalid shape for select");
                    break;
                }
                shapeInvoker.storeAndExecute(new SelectCommand(selectIndex - 1, commandText, shapeInvoker));
                break;
            case "UNDO":
                undoCommand();
                break;
            default:
                System.out.println("Invalid command");
        }
    }

    private static void undoCommand() {
        Command tmpCommand = shapeInvoker.getCommandHistory().pop();

        if (tmpCommand instanceof SelectCommand) {
            shapeInvoker.setCurrentShape(shapeInvoker.getLastSelect());

        } else if (tmpCommand instanceof DeleteCommand) {
            shapeInvoker.setCurrentShape(shapes.get(shapeInvoker.getSelectHistoryIndex()));
            shapeInvoker.getCurrentShape().setAlive(true);

        } else if (tmpCommand instanceof CreateCommand) {
            shapeInvoker.setCurrentShape(shapes.get(shapeInvoker.getShapes().size() - 1));
            shapeInvoker.getCurrentShape().setAlive(false);
            shapeInvoker.setCurrentShape(null);

        } else if (tmpCommand instanceof DrawCommand || tmpCommand instanceof DrawSceneCommand) {
            return;
        } else {
            restoreShapeState();
        }
    }

    private static void restoreShapeState() {
        careTakerIndex--;
        originator.restoreMemento(caretaker.getMemento(careTakerIndex));
        shapeInvoker.getCurrentShape().setColor(originator.getColor());
        shapeInvoker.getCurrentShape().setxCord(originator.getxCord());
        shapeInvoker.getCurrentShape().setyCord(originator.getyCord());
        shapeInvoker.getCurrentShape().setAlive(originator.getIsAlive());
        shapeInvoker.getCurrentShape().setSelected(originator.getIsSelected());
    }

    private static void saveCurrentShape() {
        originator.saveShapeState(shapeInvoker.getCurrentShape());
        caretaker.addMemento(originator.createNewMemento());
        careTakerIndex++;
    }

}
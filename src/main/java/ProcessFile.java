import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// THIS CLASS IS OUR
public class ProcessFile {
    //static ArrayList<Shape> shapes = new ArrayList<Shape>();
    static ShapeInvoker shapeInvoker = new ShapeInvoker();
    static Originator originator = new Originator();
    static Caretaker caretaker = new Caretaker();
    static int careTakerIndex = 0;

    public static void main(String[] args) {
        try {
            File myObj = new File("../../InputSet1.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] lineParts = line.split(" ");
                String command = lineParts[0];

                switch (command) {
                    case "CREATE":
                        shapeInvoker.storeAndExecute(new CreateCommand(line,shapeInvoker));
                        break;
                    case "SELECT":
                        if (Integer.parseInt(lineParts[1]) > shapeInvoker.getShapes().size()) {
                            System.out.println("ERROR: Invalid shape for select");
                            break;
                        }
                        shapeInvoker.storeAndExecute(new SelectCommand(Integer.parseInt(lineParts[1]) - 1, line, shapeInvoker));
                        break;
                    case "DRAW":
                        shapeInvoker.storeAndExecute(new DrawCommand(shapeInvoker.getCurrentShape()));
                        break;

                    case "DRAWSCENE":
                        shapeInvoker.storeAndExecute(new DrawSceneCommand(shapeInvoker.getShapes()));
                        break;
                    case "COLOR":
                        originator.saveShapeState(shapeInvoker.getCurrentShape());
                        caretaker.addMemento(originator.createNewMemento());
                        careTakerIndex++;
                        shapeInvoker.storeAndExecute(new ColorCommand(shapeInvoker.getCurrentShape(), lineParts[1]));
                        break;
                    case "MOVE":
                        originator.saveShapeState(shapeInvoker.getCurrentShape());
                        caretaker.addMemento(originator.createNewMemento());
                        careTakerIndex++;
                        shapeInvoker.storeAndExecute(new MoveCommand(shapeInvoker.getCurrentShape(), Integer.parseInt(lineParts[1]),
                                Integer.parseInt(lineParts[2])));
                        break;
                    case "UNDO":
                        Command tmpCommand = shapeInvoker.getCommandHistory().pop();
                        if (tmpCommand instanceof SelectCommand) {
                            shapeInvoker.setCurrentShape(shapeInvoker.getLastSelect());
                        } else if (tmpCommand instanceof DeleteCommand) {
                            shapeInvoker.setCurrentShape(shapeInvoker.getShapes().get(shapeInvoker.getSelectHistory().peek().getIndex()));
                            shapeInvoker.getCurrentShape().setAlive(true);
                        } else if (tmpCommand instanceof CreateCommand) {
                            shapeInvoker.setCurrentShape(shapeInvoker.getShapes().get(shapeInvoker.getShapes().size() - 1));
                            shapeInvoker.getCurrentShape().setAlive(false);
                            shapeInvoker.setCurrentShape(null);
                        } else if (tmpCommand instanceof DrawCommand || tmpCommand instanceof DrawSceneCommand) {
                            break;
                        } else {
                            careTakerIndex--;
                            originator.restoreMemento(caretaker.getMemento(careTakerIndex));
                            shapeInvoker.getCurrentShape().setColor(originator.getColor());
                            shapeInvoker.getCurrentShape().setxCord(originator.getxCord());
                            shapeInvoker.getCurrentShape().setyCord(originator.getyCord());
                            shapeInvoker.getCurrentShape().setAlive(originator.getIsAlive());
                            shapeInvoker.getCurrentShape().setSelected(originator.getIsSelected());
                            //careTakerIndex++;
                        }
                        break;
                    case "DELETE":
                        originator.saveShapeState(shapeInvoker.getCurrentShape());
                        caretaker.addMemento(originator.createNewMemento());
                        careTakerIndex++;

                        shapeInvoker.storeAndExecute(new DeleteCommand(shapeInvoker.getCurrentShape()));
                        shapeInvoker.setCurrentShape(null);
                        break;
                    default:
                        System.out.println("Invalid command");
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }

    }

}
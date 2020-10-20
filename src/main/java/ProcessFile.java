import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// THIS CLASS IS OUR
public class ProcessFile {
    static ArrayList<Shape> shapes = new ArrayList<Shape>();
    static ShapeInvoker shapeInvoker = new ShapeInvoker();
    static Shape currentShape;

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
                        if (lineParts[1].equals("RECTANGLE")) {
                            Rectangle tmp = new Rectangle(Integer.parseInt(lineParts[2]), Integer.parseInt(lineParts[3]));
                            shapes.add(tmp);
                            shapeInvoker.getShapes().add(tmp);
                            shapeInvoker.storeAndExecute(new CreateCommand(tmp));
                        }
                        if (lineParts[1].equals("CIRCLE")) {
                            Circle tmp2 = new Circle(Integer.parseInt(lineParts[2]));
                            shapes.add(tmp2);
                            shapeInvoker.getShapes().add(tmp2);
                            shapeInvoker.storeAndExecute(new CreateCommand(tmp2));
                        }

                        break;
                    case "SELECT":
                        if (Integer.parseInt(lineParts[1]) > shapes.size()) {
                            System.out.println("ERROR: Invalid shape for select");
                            break;
                        }
                        Shape tmp = currentShape;
                        currentShape = shapes.get(Integer.parseInt(lineParts[1]) - 1);
                        if (currentShape.isAlive == false) {
                            System.out.println("ERROR: invalid shape for SELECT");
                            currentShape = tmp;
                        }
                        shapeInvoker.storeAndExecute(new SelectCommand(Integer.parseInt(lineParts[1]) - 1));
                        break;
                    case "DRAW":
                        shapeInvoker.storeAndExecute(new DrawCommand(currentShape));
                        break;

                    case "DRAWSCENE":
                        shapeInvoker.storeAndExecute(new DrawSceneCommand(shapes));
                        break;
                    case "COLOR":
                        originator.saveShapeState(currentShape);
                        caretaker.addMemento(originator.createNewMemento());
                        careTakerIndex++;
                        shapeInvoker.storeAndExecute(new ColorCommand(currentShape, lineParts[1]));
                        break;
                    case "MOVE":
                        originator.saveShapeState(currentShape);
                        caretaker.addMemento(originator.createNewMemento());
                        careTakerIndex++;
                        shapeInvoker.storeAndExecute(new MoveCommand(currentShape, Integer.parseInt(lineParts[1]),
                                Integer.parseInt(lineParts[2])));
                        break;
                    case "UNDO":
                        Command tmpCommand = shapeInvoker.getCommandHistory().pop();
                        if (tmpCommand instanceof SelectCommand) {
                            currentShape = shapeInvoker.getLastSelect();
                        } else if (tmpCommand instanceof DeleteCommand) {
                            currentShape = shapeInvoker.getShapes().get(shapeInvoker.getSelectHistory().peek().getIndex());
                            currentShape.setAlive(true);
                        } else if (tmpCommand instanceof CreateCommand) {
                            currentShape = shapeInvoker.getShapes().get(shapeInvoker.getShapes().size() - 1);
                            currentShape.setAlive(false);
                            currentShape = null;
                        } else if (tmpCommand instanceof DrawCommand || tmpCommand instanceof DrawSceneCommand) {
                            break;
                        } else {
                            careTakerIndex--;
                            originator.restoreMemento(caretaker.getMemento(careTakerIndex));
                            currentShape.setColor(originator.getColor());
                            currentShape.setxCord(originator.getxCord());
                            currentShape.setyCord(originator.getyCord());
                            currentShape.setAlive(originator.getIsAlive());
                            careTakerIndex++;
                        }
                        break;
                    case "DELETE":
                        originator.saveShapeState(currentShape);
                        caretaker.addMemento(originator.createNewMemento());
                        careTakerIndex++;

                        shapeInvoker.storeAndExecute(new DeleteCommand(currentShape));
                        currentShape = null;
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
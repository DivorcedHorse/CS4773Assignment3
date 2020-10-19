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

                switch (command){
                    case "CREATE":
                        if (lineParts[1].equals("RECTANGLE")){
                            Rectangle tmp = new Rectangle(Integer.parseInt(lineParts[2]),Integer.parseInt(lineParts[3]));
                            shapes.add(tmp);
                        }
                        if (lineParts[1].equals("CIRCLE")){
                            Circle tmp2 = new Circle(Integer.parseInt(lineParts[2]));
                            shapes.add(tmp2);
                        }
                        break;
                    case "SELECT":

                        if(Integer.parseInt(lineParts[1]) > shapes.size()){
                            System.out.println("ERROR: Invalid shape for select");
                            break;
                        }
                        currentShape = shapes.get(Integer.parseInt(lineParts[1]) - 1);
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
                        careTakerIndex--;
                        originator.restoreMemento(caretaker.getMemento(careTakerIndex));
                        currentShape.setColor(originator.getColor());
                        currentShape.setxCord(originator.getxCord());
                        currentShape.setyCord(originator.getyCord());
                        careTakerIndex++;
                        break;

                    case "DELETE":
                        originator.saveShapeState(currentShape);
                        caretaker.addMemento(originator.createNewMemento());
                        careTakerIndex++;
                        shapeInvoker.storeAndExecute(new DeleteCommand(currentShape));
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

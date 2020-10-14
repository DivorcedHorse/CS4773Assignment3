import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessFile {

    static ArrayList<ShapeInvoker> shapes = new ArrayList<ShapeInvoker>();
    static ShapeInvoker currShape = null;
    static ArrayList<Command> shapesCommands = new ArrayList<Command>();


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
                        shapes.add(new ShapeInvoker(new Rectangle(Integer.parseInt(lineParts[2]),Integer.parseInt(lineParts[3]))));
                        }
                        if (lineParts[1].equals("CIRCLE")){
                        shapes.add(new ShapeInvoker(new Circle(Integer.parseInt(lineParts[2]))));
                        }
                        break;
                    case "SELECT":
                        if(Integer.parseInt(lineParts[1]) > shapes.size()){
                            System.out.println("ERROR: Invalid shape for select");
                            break;
                        }
                        currShape = shapes.get(Integer.parseInt(lineParts[1]) - 1);
                        break;
                    case "MOVE":
                        currShape.storeAndExecute(new MoveCommand(Integer.parseInt(lineParts[1]), Integer.parseInt(lineParts[2])));
                        break;
                    case "DRAW":
                        currShape.storeAndExecute(new DrawCommand());
                        break;
                    case "COLOR":
                        currShape.storeAndExecute(new ColorCommand(lineParts[1]));
                        break;
                    case "DELETE":
                        break;
                    case "DRAWSCENE":
                        for(ShapeInvoker shape : shapes){
                            shape.storeAndExecute(new DrawSceneCommand());
                        }
                        break;
                    case "UNDO":
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

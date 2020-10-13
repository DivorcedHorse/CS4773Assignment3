import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessFile {

    ArrayList<ShapeInvoker> shapes = new ArrayList<ShapeInvoker>();

    public static void main(String[] args) {

        try {
            File myObj = new File("../../InputSet1.txt");
            Scanner myReader = new Scanner(myObj);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] lineParts = line.split(" ");

                if (lineParts[0] == "CREATE" ) {
                    if (lineParts[1] == "RECTANGLE") {
                        shapes.add(new ShapeInvoker());
                    }
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("ERROR");
        }

    }
}

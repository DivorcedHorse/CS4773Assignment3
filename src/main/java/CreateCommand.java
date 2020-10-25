/**
 * CreateCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Given the necessary values to create
 *      a new shape, creates the new shape and
 *      adds it to the drawing list.
 */
public class CreateCommand extends Command {
    ShapeInvoker shapes;
    String shapeInfo;

    public CreateCommand(String shapeInfo, ShapeInvoker shapes) {
        this.shapeInfo = shapeInfo;
        this.shapes = shapes;
    }

    /**
     * execute
     *
     * Purpose:
     *      With the values that were provided in the constructor,
     *      determines which new shape should be created.  Once
     *      created, it adds it to the shapes list and calls
     *      the CREATE method.
     */
    public void execute() {
        String[] shapeInfoParts = shapeInfo.split(" ");

        if (shapeInfoParts[1].equals("RECTANGLE")){
            Rectangle newRec = new Rectangle(Integer.parseInt(shapeInfoParts[2]),Integer.parseInt(shapeInfoParts[3]));
            shapes.getShapes().add(newRec);
            newRec.CREATE();
        }

        if (shapeInfoParts[1].equals("CIRCLE")){
            Circle newCir = new Circle(Integer.parseInt(shapeInfoParts[2]));
            shapes.getShapes().add(newCir);
            newCir.CREATE();
        }
    }
}

public class CreateCommand extends Command {
    ShapeInvoker shapes;
    String shapeInfo;

    public CreateCommand(String shapeInfo, ShapeInvoker shapes) {
        this.shapeInfo = shapeInfo;
        this.shapes = shapes;
    }


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

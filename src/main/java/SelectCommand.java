public class SelectCommand extends Command {
    int index;
    String selectInfo;
    ShapeInvoker shapes;

    public SelectCommand(int x, String selectInfo, ShapeInvoker shapes) {
        index = x;
        this.selectInfo = selectInfo;
        this.shapes = shapes;
    }

    public void execute() {
        String[] selectInfoParts = selectInfo.split(" ");

        Shape tmp = shapes.getCurrentShape();
        shapes.setCurrentShape(shapes.getShapes().get(Integer.parseInt(selectInfoParts[1]) - 1));
        if (shapes.getCurrentShape().isAlive == false) {
            System.out.println("ERROR: invalid shape for SELECT");
            shapes.setCurrentShape(tmp);
        }



    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

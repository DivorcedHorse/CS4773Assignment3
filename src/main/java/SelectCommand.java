/**
 * SelectCommand by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      SelectCommand will select the correct shape
 *      in the drawinglist as the shape that will
 *      be "changed" with the other commands.
 */
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
            return;
        }
        shapes.getCurrentShape().SELECT();
    }

    // ------------ GETTERS AND SETTERS --------------

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSelectInfo() {
        return selectInfo;
    }

    public void setSelectInfo(String selectInfo) {
        this.selectInfo = selectInfo;
    }

    public ShapeInvoker getShapes() {
        return shapes;
    }

    public void setShapes(ShapeInvoker shapes) {
        this.shapes = shapes;
    }
}

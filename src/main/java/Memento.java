/**
 * Memento by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Snapshot of originator state shape.  Stores
 *      the current values of that shape at that given
 *      time it was snapped.
 */
public class Memento {
    private String shapeType;
    private String color;
    private int xCord;
    private int yCord;

    public Memento(String saveShape, String saveColor, int saveXPos, int saveYPos) {
        shapeType = saveShape;
        color = saveColor;
        xCord = saveXPos;
        yCord = saveYPos;
    }

    // ----- GETTERS --------

    public String getShapeType() {
        return shapeType;
    }

    public String getColor() {
        return color;
    }

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }
}

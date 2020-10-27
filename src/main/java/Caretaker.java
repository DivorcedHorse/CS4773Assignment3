/**
 * CareTaker by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Object that is going to change the originator but wants to undo the
 *      change. Stores the list/history of mementos/snapshots of all the
 *      shapes.
 */

import java.util.ArrayList;

public class Caretaker {
    private ArrayList<Memento> savedShapeStates;
    private int careTakerIndex;

    public Caretaker() {
        savedShapeStates = new ArrayList<>();
        careTakerIndex = 0;
    }

    /**
     * addMemento
     *
     * Purpose:
     *      Saves the given memento into an arraylist.
     *      Stores all mementos/snapshots.
     * @param m
     */
    public void addMemento(Memento m) {
        careTakerIndex++;
        savedShapeStates.add(m);
    }

    public Memento getMemento() {
        careTakerIndex--;
        Memento tmp = savedShapeStates.get(careTakerIndex);
        savedShapeStates.remove(careTakerIndex);
        return tmp;
    }
}

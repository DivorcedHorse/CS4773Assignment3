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

    public Caretaker() {
        savedShapeStates = new ArrayList<>();
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
        savedShapeStates.add(m);
    }

    // ---------- GETTER ---------------
    public Memento getMemento(int index) {
        return savedShapeStates.get(index);
    }
}

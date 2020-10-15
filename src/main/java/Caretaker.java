import java.util.ArrayList;

public class Caretaker {
    ArrayList<Memento> savedShapeStates = new ArrayList<>();

    public void addMemento(Memento m) {
        savedShapeStates.add(m);
    }

    public Memento getMemento(int index) {
        return savedShapeStates.get(index);
    }
}

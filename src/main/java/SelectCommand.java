public class SelectCommand extends Command {
    int index;

    public SelectCommand(int x) {
        index = x;
    }

    public void execute() {

    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}

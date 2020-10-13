public abstract class Command {

    public abstract void execute(Shape shape);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
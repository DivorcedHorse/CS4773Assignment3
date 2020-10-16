/**
 * Command by Daniel Tellez and Hao Tran
 *
 * Purpose:
 *      Encapsulates everything needed to
 *      perform the action on the Receiver.
 */

public abstract class Command {

    /**
     * execute
     *
     * Purpose:
     *      The subclass command will execute corresponding
     *      shape method.
     * @param shape
     */
    public abstract void execute(Shape shape);

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
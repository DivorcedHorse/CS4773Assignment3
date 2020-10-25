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
     *      The subclass command will execute its unique
     *      shape method/command that will change/affect
     *      properties of given shape.
     */
    public abstract void execute();

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

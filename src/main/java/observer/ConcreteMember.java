package observer;

/**
 * This class implements the Member interface in the observer design pattern.
 * This class has 2 fields: "myStr" to hold the updated UndoableStringBuilder, and a "name".
 *
 * @author Shalev and Tair
 * @version 1.2
 */
public class ConcreteMember implements Member {
    private UndoableStringBuilder myStr;
    private final String name;

    /**
     * Constructor creates a new object of type ConcreteMember.
     *
     * @param name The name of the new ConcreteMember.
     */
    public ConcreteMember (String name) {
        this.name = name;
        myStr = new UndoableStringBuilder();
    }

    /**
     * Method for receiving updates from GroupAdmin.
     * The method does a shallow-copy (makes "myStr" point to the same address as the "usb").
     *
     * @param usb - The UndoableStringBuilder object of "statesCollection" to which we want to point in order
     *            to get the update.
     */
    @Override
    public void update(UndoableStringBuilder usb) {
        myStr = usb;
        System.out.println(name + ": Got update!");
    }

    /**
     *
     * @return myStr.
     */
    public UndoableStringBuilder getMyStr () {
        return myStr;
    }

    /**
     * prints the name of the ConcreteMember.
     *
     * @return name.
     */
    @Override
    public String toString() {
        return name;
    }
}

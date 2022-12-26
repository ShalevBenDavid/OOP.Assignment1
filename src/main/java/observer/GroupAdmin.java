package observer;
import java.util.ArrayList;

/**
 * This class implements the Sender interface in the observer design pattern.
 * This class has 2 fields: "statesCollection" to hold the main  UndoableStringBuilder object
 * which all members want to be updated on, and a Member type list "members" to keep all members.
 *
 * @author Shalev and Tair
 * @version 1.2
 */
public class GroupAdmin implements Sender {
    private final UndoableStringBuilder statesCollection;
    private final ArrayList <Member> members;

    /**
     * Constructor creates a new object of type GroupAdmin.
     *
     * @param statesCollection An initialized UndoableStringBuilder object.
     */
    public GroupAdmin (UndoableStringBuilder statesCollection) {
        this.statesCollection = statesCollection;
        members = new ArrayList<>();
    }

    /**
     * Method that goes through the "member list" and notifies them of the update using update() method.
     * Upon updating all members, the method prints "Updated All members!" message.
     */
    public void notifyObservers() {
        for (Member x : members) {
            x.update(statesCollection);
        }
        System.out.println("Updated All members!");
    }

    /**
     *
     * @return statesCollection.
     */
    public UndoableStringBuilder getStatesCollection() {
        return statesCollection;
    }

    /**
     * Method that adds/subscribes a new member to the "members" list.
     * Upon adding "obj", method prints obj's name + "was added!".
     * If "obj" is already subscribed, we will not add him again.
     *
     * @param obj A Member type object that is added to the list.
     */
    @Override
    public void register(Member obj) {
        if (members.contains(obj)) {
            System.out.println(obj.toString() + " is already subscribed!");
            return;
        }
        members.add(obj);
        System.out.println(obj.toString() + " was added!");
    }

    /**
     * Method that removes/un-subscribes a member from the "members" list.
     * Upon removing "obj", method prints obj's name + "was removed!".
     * If "obj" is already unsubscribed, we will not remove him from the list.
     *
     * @param obj The Member type object that is removed from the list.
     */
    @Override
    public void unregister(Member obj) {
        if (!members.contains(obj)) {
            System.out.println(obj.toString() + " is not subscribed!");
            return;
        }
        members.remove(obj);
        System.out.println(obj.toString() + " was removed!");
    }

    /**
     * Method that uses the insert() method (which is in UndoableStringBuilder class) on "statesCollection"
     * and then call notifyObservers() to update all members of the change (if a change was made,
     * meaning "backup" size was changed).
     *
     * @param offset The index in which we want to insert obj string to our sequence.
     * @param obj The string we want to insert.
     */
    @Override
    public void insert(int offset, String obj) {
        if (statesCollection.getBackup().size() != statesCollection.insert(offset, obj).getBackup().size()) {
            notifyObservers();
        }
    }

    /**
     * Method that uses the append() method (which is in UndoableStringBuilder class) on "statesCollection"
     * and then call notifyObservers() to update all members of the change.
     *
     * @param obj The string we want to append.
     */
    @Override
    public void append(String obj) {
        statesCollection.append(obj);
        notifyObservers();
    }

    /**
     * Method that uses the delete() method (which is in UndoableStringBuilder class) on "statesCollection"
     * and then call notifyObservers() to update all members of the change (if a change was made,
     * meaning "backup" size was changed).
     *
     * @param start The beginning index of the substring we want to delete, included.
     * @param end The ending index of the substring we want to delete, not included.
     */
    @Override
    public void delete(int start, int end) {
        if (statesCollection.getBackup().size() != statesCollection.delete(start, end).getBackup().size()) {
            notifyObservers();
        }
    }

    /**
     * Method that uses the undo() method (which is in UndoableStringBuilder class) on "statesCollection"
     * and then call notifyObservers() to update all members of the change.
     */
    @Override
    public void undo() {
        statesCollection.undo();
        notifyObservers();
    }

    /**
     * Prints the current state of "statesCollection" and all members currently registered.
     * @return The statesCollection's string and the member list.
     */
    @Override
    public String toString() {
        return "GroupAdmin{" +
                "statesCollection=" + statesCollection.toString() +
                ", members=" + members +
                '}';
    }
}

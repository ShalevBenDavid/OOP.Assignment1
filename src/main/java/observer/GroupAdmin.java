package observer;
import java.util.ArrayList;

public class GroupAdmin implements Sender {
    private final UndoableStringBuilder statesCollection;
    private final ArrayList <Member> members;

    public GroupAdmin (UndoableStringBuilder statesCollection) {
        this.statesCollection = statesCollection;
        members = new ArrayList<>();
    }
    public void notifyObservers() {
        for (Member x : members) {
            x.update(statesCollection);
        }
        System.out.println("Updated All members!");
    }

    public UndoableStringBuilder getStatesCollection() {
        return statesCollection;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    @Override
    public void register(Member obj) {
        members.add(obj);
        System.out.println(obj.toString() + " was added!");
    }

    @Override
    public void unregister(Member obj) {
        members.remove(obj);
        System.out.println(obj.toString() + " was removed!");
    }

    @Override
    public void insert(int offset, String obj) {
            statesCollection.insert(offset, obj);
            notifyObservers();
    }

    @Override
    public void append(String obj) {
        statesCollection.append(obj);
        notifyObservers();
    }

    @Override
    public void delete(int start, int end) {
        statesCollection.delete(start, end);
        notifyObservers();
    }

    @Override
    public void undo() {
        statesCollection.undo();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "GroupAdmin{" +
                "statesCollection=" + statesCollection.toString() +
                ", members=" + members +
                '}';
    }
}

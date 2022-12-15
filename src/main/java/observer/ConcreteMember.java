package observer;

public class ConcreteMember implements Member {
    private UndoableStringBuilder myStr;
    private final String name;

    public ConcreteMember (String name) {
        this.name = name;
        myStr = new UndoableStringBuilder();
    }
    @Override
    public void update(UndoableStringBuilder usb) {
        myStr = new UndoableStringBuilder(usb);
        System.out.println(name + ": Got update!");
    }

    public UndoableStringBuilder getMyStr () {
        return myStr;
    }

    @Override
    public String toString() {
        return name;
    }
}

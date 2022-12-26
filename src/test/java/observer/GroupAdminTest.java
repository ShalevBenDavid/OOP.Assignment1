package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAdminTest {

    @Test
    void notifyObservers() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Create member.
        ConcreteMember observer1 = new ConcreteMember("John");
        observable.register(observer1);

        // Change StatesCollection using append (which calls notifyObservers()).
        observable.append("hello");
        assertEquals("hello", observable.getStatesCollection().toString());

        // Add another member.
        ConcreteMember observer2 = new ConcreteMember("Alon");
        observable.register(observer2);
        assertEquals("", observer2.getMyStr().toString());

        // Use notifyObservers() to update myStr for observer2.
        observable.notifyObservers();
        assertEquals("hello", observer2.getMyStr().toString());
    }

    @Test
    void register() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Create members and register them.
        ConcreteMember observer1 = new ConcreteMember("John");
        observable.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Alon");
        observable.register(observer2);


        // Create observer 3 with the same name as observer 2 and register him.
        ConcreteMember observer3 = new ConcreteMember("Alon");
        observable.register(observer3);

        // Try to register observer3 again.
        observable.register(observer3);

        // Print observable object data.
        System.out.println(observable);
    }

    @Test
    void unregister() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Create members and register them.
        ConcreteMember observer1 = new ConcreteMember("John");
        observable.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Alon");
        observable.register(observer2);

        // Change StatesCollection using append (which calls notifyObservers()).
        observable.append("update1");
        assertEquals("update1", observable.getStatesCollection().toString());

        // Print observable object data.
        System.out.println(observable);

        // Unregister observer 1 twice.
        observable.unregister(observer1);
        observable.unregister(observer1);

        // Change StatesCollection using append (which calls notifyObservers()).
        observable.append(".1");
        assertEquals("update1.1", observer2.getMyStr().toString());

        // Print observable object data.
        System.out.println(observable);
    }

    @Test
    void insert() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Create member and register him.
        ConcreteMember observer = new ConcreteMember("John");
        observable.register(observer);

        // Call insert () from start index and check to see if updated.
        observable.insert(0, "hello");
        assertEquals("hello", observable.getStatesCollection().toString());

        // Call insert () again and check to see if updated.
        observable.insert(5, " again!");
        assertEquals("hello again!", observable.getStatesCollection().toString());

        // Call insert() with negative index to print error and to see no one gets update.
        observable.insert(-2, "h");

        // Print observable object data.
        System.out.println(observable);
    }

    @Test
    void append() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Create member and register him.
        ConcreteMember observer1 = new ConcreteMember("John");
        observable.register(observer1);

        // Call append() with "".
        observable.append("");
        assertEquals("", observable.getStatesCollection().toString());

        // Call append() with "hello".
        observable.append("hello");
        assertEquals("hello", observable.getStatesCollection().toString());

        // Create another member and register him.
        ConcreteMember observer2 = new ConcreteMember("Alon");
        observable.register(observer2);

        // Call append() with " again!" and check if updated.
        observable.append(" again!");
        assertEquals("hello again!", observable.getStatesCollection().toString());
    }

    @Test
    void delete() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Create member and register him.
        ConcreteMember observer = new ConcreteMember("John");
        observable.register(observer);

        // Call delete() and check if StatesCollection is "".
        observable.delete(0,1);
        assertEquals("", observable.getStatesCollection().toString());

        // Call append () and check to see if updated.
        observable.append("hello");
        assertEquals("hello", observable.getStatesCollection().toString());

        // Call delete() again to delete all and check if StatesCollection is "".
        observable.delete(0,3);
        assertEquals("lo", observable.getStatesCollection().toString());

        // Call delete() with negative index to print error and to see no one gets update.
        observable.delete(-2, 0);

        // Print observable object data.
        System.out.println(observable);
    }

    @Test
    void undo() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Check initialized string in StatesCollection is "".
        assertEquals("", observable.getStatesCollection().toString());

        // Create members and register them.
        ConcreteMember observer1 = new ConcreteMember("John");
        observable.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Alon");
        observable.register(observer2);

        // Call undo()
        observable.undo();
        assertEquals("", observable.getStatesCollection().toString());

        // Call append () twice and check to see if updated.
        observable.append("hello");
        observable.append("");
        assertEquals("hello", observable.getStatesCollection().toString());

        // Call Undo() twice and check.
        observable.undo();
        assertEquals("hello", observable.getStatesCollection().toString());
        observable.undo();
        assertEquals("", observable.getStatesCollection().toString());
    }
}
package observer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ConcreteMemberTest {

    @Test
    void update() {
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Create members.
        ConcreteMember observer1 = new ConcreteMember("John");
        observable.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Alon");
        observable.register(observer2);

        // Change with append the StateCollection and see if update was successful.
        observable.append("hello new members!");
        assertEquals("hello new members!", observer1.getMyStr().toString());
        assertEquals("hello new members!", observer2.getMyStr().toString());

        // Unsubscribe observer2 (Alon) and check who got the update.
        observable.unregister(observer2);
        observable.undo();
        assertEquals("", observer1.getMyStr().toString());
        assertEquals("hello new members!", observer2.getMyStr().toString());
    }
}
package observer;

import org.junit.jupiter.api.Test;

public class TestResources {
    @Test
    public void test(){
        UndoableStringBuilder str = new UndoableStringBuilder();
        GroupAdmin observable = new GroupAdmin(str);

        // Create members.
        ConcreteMember observer1 = new ConcreteMember("John");
        observable.register(observer1);
        ConcreteMember observer2 = new ConcreteMember("Ron");
        observable.register(observer2);
        System.out.println("\n*************** This Is Before Appending *************** " + "\n");
        System.out.println("observable memory consumption: " + JvmUtilities.objectFootprint(observable));
        System.out.println("observer1 memory consumption: " + JvmUtilities.objectTotalSize(observer1));
        System.out.println("observer2 memory consumption: " + JvmUtilities.objectTotalSize(observer2));


        observable.append("hello new members!");
        System.out.println("\n*************** This Is After Appending *************** " + "\n");
        System.out.println("observable memory consumption: " + JvmUtilities.objectFootprint(observable));
        System.out.println("observer1 memory consumption: " + JvmUtilities.objectTotalSize(observer1));
        System.out.println("observer2 memory consumption: " + JvmUtilities.objectTotalSize(observer2));
        System.out.println("\nTotal memory consumption of program: " + JvmUtilities.jvmInfo());
    }
}

package practiceTestCases;

/**
 * Created by Император on 07.12.2016.
 */
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SampleEntry {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Logger chance = LogManager.getLogger(SampleEntry.class.getName());
        Logger logger1 = LogManager.getLogger("Child1");
        Logger logger1Child = logger1.getLogger("Child1.ChildOfLogger1");
        Logger loggerGrandChild = LogManager.getLogger("Child1.ChildOfLogger1.GrandChild");

        System.out.println("logger1's full name is " + logger1.getParent().getName());
        System.out.println("logger1Child's full name is " + logger1Child.getParent().getName());
        System.out.println("loggerGrandChild's full name is " + loggerGrandChild.getParent().getName());

    }
}

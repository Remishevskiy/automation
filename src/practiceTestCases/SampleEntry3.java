/*
package practiceTestCases;

*/
/**
 * Created by Император on 07.12.2016.
 *//*

import org.apache.log4j.*;

public class SampleEntry3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        BasicConfigurator.configure();
        Logger OurLogger = LogManager.getLogger("OurLogger");

        //create a ConsoleAppender object
        //You will also have to set a layout also, here
        //We have chosen a SimpleLayout
        ConsoleAppender ConsoleAppender = new ConsoleAppender();
        ConsoleAppender.setLayout(new SimpleLayout());

        //Add the appender to our Logger Object.
        //from now onwards all the logs will be directed
        //to file mentioned by FileAppender
        OurLogger.addAppender(ConsoleAppender);
        ConsoleAppender.activateOptions();

        //lets print some log 10 times
        int x = 0;
        while(x < 11){
            OurLogger.debug("This is just a log that I want to print " + x);
            x++;
        }
    }
}

*/

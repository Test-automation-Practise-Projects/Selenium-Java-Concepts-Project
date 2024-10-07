/*
Step 1: Created package demo inside src/main/java
Step 2: Created this Java class
Step 3: Created a file as log4j2.properties inside src/main/resources (Use the same name for the file always)
Step 4: Add all configurations to  log4j2.properties file (Referenece: https://springframework.guru/log4j-2-configuration-using-properties-file/)
Step 5: Run this Java class -> Then the logs folder and Mylogs file will be created inside that
 */

/*
If we want to use log4j2.xml instead of properties file, just rename the properties file into something else because then it won't run.
The reason is if we have both xml and properties files, it gives priority to properties file and not to xml file
 */

package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4jSample {
       static Logger logger = LogManager.getLogger(log4jSample.class);
    public static void main(String[] args) {
        System.out.println("\n Hello world     \n");

       logger.trace("This is trace msg");
        //To print trace level log, we have to change logger.file.level = debug and rootLogger.level = debug in log4j2.properties file to trace instead of debug
        logger.info("This is information msg");
        logger.error("This is an error msg");
        logger.warn("This is an warning msg");
        logger.fatal("This is an fatal msg");


        System.out.println("\n Completed");
    }
}

/*
NOTE: LOG4J LEVELS
        DEBUG   Designates fine-grained informational events that are most useful to debug an application.
        INFO	Designates informational messages that highlight the progress of the application at coarse-grained level.
        WARN	Designates potentially harmful situations.
        ERROR	Designates error events that might still allow the application to continue running.
        FATAL	Designates very severe error events that will presumably lead the application to abort.
        OFF	    The highest possible rank and is intended to turn off logging.
        TRACE	Designates finer-grained informational events than the DEBUG.
        ALL  	Has all levels including custom levels.
 */

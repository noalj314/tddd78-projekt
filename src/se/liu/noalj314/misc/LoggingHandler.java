package se.liu.noalj314.misc;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingHandler
{
    public static final Logger LOGGER = Logger.getLogger(LoggingHandler.class.getName());

    static {
	try {
	    FileHandler fileHandler = new FileHandler("logfile.log", true);
	    SimpleFormatter formatter = new SimpleFormatter();
	    fileHandler.setFormatter(formatter);
	    LOGGER.addHandler(fileHandler);
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
}

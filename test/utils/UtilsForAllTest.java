package utils;

import org.junit.Test;

import java.io.File;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.*;
import static utils.ConstantForAll.FILE_XML_PARAMS;
import static utils.ConstantForAll.LOG_FILENAME;
import static utils.UtilsForAll.*;

public class UtilsForAllTest {

    @Test
    public void isXMLSettingsFileTest() throws Exception {
        Logger logger = Logger.getLogger(utils.UtilsForAll.getMainClass().getName());
        XMLProgramSettings xmlProgramSettings = new XMLProgramSettings(logger);
        assertTrue(xmlProgramSettings.isXMLSettingsFile());
    }

    @Test
    public void testGetUserDirectoryMyDocuments() throws Exception {
        Logger.getGlobal().info(getFileNameXMLParams());
    }

    @Test
    public void createLogDirTest() throws Exception {
        Logger logger = Logger.getLogger(utils.UtilsForAll.getMainClass().getName());
        assertTrue(setLoggerFileHandler(logger));

        logger.log(Level.INFO, "first log");
        logger.info("second log");
    }
}
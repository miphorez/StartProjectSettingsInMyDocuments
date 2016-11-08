package main;

import utils.XMLProgramSettings;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Logger logger;

    public static void main(String[] args) {
        if (!setupLogger()) utils.UtilsForAll.exitFromProgram();
    }

    private static boolean setupLogger() {
        logger = Logger.getLogger(utils.UtilsForAll.getMainClass().getName());
        if (!utils.UtilsForAll.setLoggerFileHandler(logger)) {
            System.out.println("Ошибка настройки логгера");
            return false;
        }

        XMLProgramSettings xmlProgramSettings = new XMLProgramSettings(logger);
        if (!xmlProgramSettings.isXMLSettingsFile()){
            System.out.println("Ошибка файла настроек программы");
            return false;
        }

        if (xmlProgramSettings.isLogInSettings()){
                logger.setLevel(Level.INFO);
                logger.info("Установлен уровень логгера: INFO");
        } else logger.setLevel(Level.OFF);

        logger.info("Запуск программы");
        return true;
    }
}

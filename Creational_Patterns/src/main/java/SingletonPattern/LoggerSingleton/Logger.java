package SingletonPattern.LoggerSingleton;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Logger {
    private static Logger logger;
    FileWriter fileWriter;
    private Logger () throws IOException {
        openFile();
    }
    public static Logger getInstance() throws IOException {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }
    public void openFile() throws IOException {
        try {
            fileWriter = new FileWriter("logFile.log",true);
        } catch (IOException e) {
            System.out.println("File not found or not created. " + e.getMessage());
        }
    }
    public void writeLog(String log) throws IOException {
        try {
            openFile();
            fileWriter.write(log + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("File not found or not created. " + e.getMessage());
        }
        closeFile();
    }
    public void closeFile() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("File not found or not created. " + e.getMessage());
        }
    }
}

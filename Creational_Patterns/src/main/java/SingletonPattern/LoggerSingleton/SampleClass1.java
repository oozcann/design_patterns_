package SingletonPattern.LoggerSingleton;

import java.io.IOException;
import java.util.Date;

public class SampleClass1 {
    public SampleClass1 () throws IOException {
        Logger logger = Logger.getInstance();
        logger.writeLog(new Date().toGMTString() + " - " + this.getClass().getSimpleName() + " has been initialized.");
    }
}

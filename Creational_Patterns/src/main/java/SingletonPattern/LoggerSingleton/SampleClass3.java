package SingletonPattern.LoggerSingleton;

import java.io.IOException;
import java.util.Date;

public class SampleClass3 {
    public SampleClass3 () throws IOException {
        Logger logger = Logger.getInstance();
        logger.writeLog(new Date().toGMTString() + " - " + this.getClass().getSimpleName() + " has been initialized.");
    }
}

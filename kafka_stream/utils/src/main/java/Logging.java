/**
 * Created by williamguan on 2018/6/15.
 */
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class Logging {
    static {
        try {
            PropertyConfigurator.configure("log4j.properties");
        } catch {

        }
    }
}

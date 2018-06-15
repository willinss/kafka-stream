/**
 * Created by williamguan on 2018/6/15.
 */
import org.apache.log4j.Logger;

public class Helloworld {
    private static Logger logger = Logger.getLogger(Helloworld.class.getClass());

    public static void main(String[] args) {
        System.out.println("helloworld");
        logger.info("debug message");
    }
}

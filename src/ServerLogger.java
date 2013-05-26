import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:40
 * To change this template use File | Settings | File Templates.
 */
public class ServerLogger {
    private static ArrayList<String> log = new ArrayList<String>();

    public static void log(String line) {
        log.add(line);

        System.out.println(line);
    }
}

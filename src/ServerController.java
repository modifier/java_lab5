import java.net.*;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:19
 * To change this template use File | Settings | File Templates.
 */
public class ServerController {
    static int PORT = 9090;
    static int PACKET_SIZE = 24;
    static int TIMEOUT = 500;
    static ResourceBundle locale;

    public static void main(String[] args) {
        String locale_abbr = args.length >= 1 && args[0].equals("es") ? "es" : "ru";
        locale = ResourceBundle.getBundle("Locale_" + locale_abbr);

        byte[] data = new byte[PACKET_SIZE];
        try {
            ServerSocket socket = new ServerSocket(PORT);
            log(String.format((String) locale.getObject("ConnectionStart"), PORT));

            while(true) {
                new Thread(new PointHandler(socket.accept()).setLocale(locale)).start();
            }
        }
        catch(Exception e) {
            ServerLogger.log((String)locale.getObject("CasualError"));
        }
    }

    public static void log(String log) {
        System.out.println(log);
    }
}

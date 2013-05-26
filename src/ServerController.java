import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ListResourceBundle;

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
    static ListResourceBundle locale = new Locale_en();

    public static void main(String[] args) {
        byte[] data = new byte[PACKET_SIZE];
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            log(String.format((String)locale.getObject("ConnectionStart"), PORT));

            while(true) {
                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);

                new PointHandler(packet, socket).setLocale(locale).start();
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

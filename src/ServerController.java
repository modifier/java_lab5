import java.net.DatagramPacket;
import java.net.DatagramSocket;

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

    public static void main(String[] args) {
        byte[] data = new byte[PACKET_SIZE];
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            log("Port " + PORT + " is open. Establish connection.");

            while(true) {
                DatagramPacket packet = new DatagramPacket(data, data.length);
                socket.receive(packet);

                new PointHandler(packet, socket).start();
            }
        }
        catch(Exception e) {
            ServerLogger.log("Something is wrong.");
        }
    }

    public static void log(String log) {
        System.out.println(log);
    }
}

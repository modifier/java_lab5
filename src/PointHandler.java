import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:27
 * To change this template use File | Settings | File Templates.
 */
public class PointHandler extends Thread {
    private DatagramPacket packet;
    private DatagramSocket socket;
    private ListResourceBundle locale;

    public PointHandler(DatagramPacket packet, DatagramSocket socket) {
        this.packet = packet;
        this.socket = socket;
    }

    public PointHandler setLocale(ListResourceBundle locale) {
        this.locale = locale;

        return this;
    }

    public void run() {
        float x, y;
        int r;

        ByteArrayInputStream istream = new ByteArrayInputStream(packet.getData());
        DataInputStream distream = new DataInputStream(istream);

        try {
            x = (float)distream.readDouble();
            y = (float)distream.readDouble();
            r = (int)distream.readDouble();

            distream.close();

            Area area = new Area(r);
            Mark m = new Mark(x, y);
            boolean result = area.contains(m);

            prepareAnswer(result);
        }
        catch (IOException e) {
            ServerLogger.log((String)locale.getObject("IOError"));
        }

    }

     private void prepareAnswer(boolean result) throws IOException {
         ByteArrayOutputStream ostream = new ByteArrayOutputStream();
         DataOutputStream dostream = new DataOutputStream(ostream);

         dostream.writeBoolean(result);
         byte[] send = ostream.toByteArray();

         InetAddress ip = packet.getAddress();
         int port = packet.getPort();
         DatagramPacket sendPacket = new DatagramPacket(send, send.length, ip, port);

         socket.send(sendPacket);
         dostream.close();
     }
}

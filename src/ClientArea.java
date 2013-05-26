import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 1:15
 * To change this template use File | Settings | File Templates.
 */
public class ClientArea {
    private int PORT = 9090;
    private float radius;

    public ClientArea(float R) {
        this.radius = R;
    }

    public MarkStatus contains(Mark m) {
        try {
            DatagramSocket socket = new DatagramSocket();
            socket.connect(InetAddress.getLocalHost(), PORT);

            ByteArrayOutputStream ostream = new ByteArrayOutputStream();
            DataOutputStream dostream = new DataOutputStream(ostream);

            dostream.writeFloat(m.x);
            dostream.writeFloat(m.y);
            dostream.writeFloat(radius);

            byte[] send = ostream.toByteArray();

            DatagramPacket packet = new DatagramPacket(send, send.length);
            socket.send(packet);
            dostream.close();

            return handle(socket) ? MarkStatus.Inside : MarkStatus.Outside;
        }
        catch (Exception e) {
            return MarkStatus.Unknown;
        }
    }

    private boolean handle(DatagramSocket socket) throws IOException {
        if(!socket.isConnected()) {
            throw new IOException();
        }

        byte[] received = new byte[1];
        DatagramPacket packet = new DatagramPacket(received, received.length);
        socket.receive(packet);

        ByteArrayInputStream istream = new ByteArrayInputStream(packet.getData());
        DataInputStream distream = new DataInputStream(istream);
        boolean result = distream.readBoolean();

        distream.close();
        return result;
    }
}
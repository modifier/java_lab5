import java.io.*;
import java.net.*;

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
            Socket socket = new Socket(InetAddress.getLocalHost(), PORT);

            DataOutputStream dostream = new DataOutputStream(socket.getOutputStream());
            dostream.writeDouble(m.x);
            dostream.writeDouble(m.y);
            dostream.writeDouble(radius);

            DataInputStream distream = new DataInputStream(socket.getInputStream());
            boolean result = distream.readBoolean();

            distream.close();
            dostream.close();
            socket.close();

            return result ? MarkStatus.Inside : MarkStatus.Outside;
        }
        catch (Exception e) {
            return MarkStatus.Unknown;
        }
    }
}
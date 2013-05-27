import java.io.*;
import java.net.*;
import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:27
 * To change this template use File | Settings | File Templates.
 */
public class PointHandler implements Runnable {
    private Socket socket;
    private ListResourceBundle locale;

    public PointHandler(Socket socket) {
        this.socket = socket;
    }

    public PointHandler setLocale(ListResourceBundle locale) {
        this.locale = locale;

        return this;
    }

    public void run() {
        try {
            DataInputStream distream = new DataInputStream(socket.getInputStream());

            float x = distream.readFloat();
            float y = distream.readFloat();
            float r = distream.readFloat();

            ServerArea serverArea = new ServerArea(r);
            Mark m = new Mark(x, y);
            boolean result = serverArea.contains(m);

            DataOutputStream dostream = new DataOutputStream(socket.getOutputStream());
            dostream.writeBoolean(result);

            distream.close();
            dostream.close();
            socket.close();
        }
        catch (IOException e) {
            ServerLogger.log((String)locale.getObject("IOError"));
        }
    }
}

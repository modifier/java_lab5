/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 11.05.13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ListResourceBundle;
import java.util.Observable;
import java.util.Observer;

public class MainController implements Observer {
    public float[] y_values = new float[]{-4, 2, 4};
    public float[] x_values = new float[]{-3, -2, 1, 2, 5};

    private MarkCollection points;

    private MainView window;

    private Graphic graphic;

    private ListResourceBundle locale = new Locale_en();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        final ListResourceBundle locale = args.length >= 1 && args[0].equals("es") ? new Locale_es() : new Locale_en();

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainController controller = new MainController(locale);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MainController(ListResourceBundle locale) {
        this.locale = locale;

        points = new MarkCollection();
        points.setRadius(15);

        initializeWindow();
    }

    private void initializeWindow() {
        window = new MainView(locale);
        window.setVisible();

        window.setPoints(points);

        window.setXValues(x_values);
        window.setYValues(y_values);
        window.setRadius(points.getRadius());

        graphic = new Graphic(points);
        graphic.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                graphic.setPointFromCoords(e.getX(), e.getY());
            }
        });
        window.setGraphic(graphic);

        window.initPointRadius();

        points.addObserver(this);
    }

    public void update(Observable o, Object arg) {
        String action = (String)arg;
        if(action.equals("animate") || action.equals("add")) {
            Mark last = points.last();

            String template = (String)locale.getObject("Position");
            window.setLabel(String.format(template, last.x, last.y));
        }
    }
}


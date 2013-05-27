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

public class MainController {
    public float[] y_values = new float[]{-4, 2, 4};
    public float[] x_values = new float[]{-3, -2, 1, 2, 5};
    
    private ListResourceBundle locale;
    private MarkCollection points;

    private Graphic graphic;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        final ListResourceBundle locale;
        if(args.length > 0) {
            if(args[0].equals("eo")) {
                locale = new Locale_eo();
            } else if(args[0].equals("en")) {
                locale = new Locale_en();
            } else {
                System.out.println("Unknown locale");
                return;
            }
        } else {
            locale = new Locale_en();
        }
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
        points.setRadius(20);

        initializeWindow();
    }

    private void initializeWindow() {
        MainView window = new MainView(locale);
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
    }
}


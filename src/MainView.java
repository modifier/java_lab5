/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 11.05.13
 * Time: 15:43
 * To change this template use File | Settings | File Templates.
 */
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;


public class MainView {
    private JFrame frame;

    private MarkCollection points;

    private JPanel west_panel;
    private JPanel east_panel;

    private XPanel xlist;
    private YPanel ylist;

    private ResourceBundle locale;

    /**
     * Create the application.
     */
    public MainView(ResourceBundle locale) {
        this.locale = locale;
        initialize();
    }

    public void setVisible() {
        frame.setVisible(true);
    }

    public void setPoints(MarkCollection points) {
        this.points = points;
    }

    public void setGraphic(JPanel graphic) {
        east_panel = graphic;
        frame.getContentPane().add(east_panel, BorderLayout.CENTER);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        west_panel = new JPanel(new FlowLayout());
        frame.getContentPane().add(west_panel, BorderLayout.EAST);
    }

    public void setYValues(float[] values) {
        ylist = new YPanel(values, new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                newDots();
            }
        });
        ylist.setLabel((String)locale.getObject("YValue"));
        west_panel.add(ylist, BorderLayout.NORTH);
    }

    public void setXValues(float[] values) {
        xlist = new XPanel(values, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newDots();
            }
        });
        xlist.setLabel((String)locale.getObject("XValue"));
        west_panel.add(xlist, BorderLayout.NORTH);
    }

    public void setRadius(float radius) {
        final RadiusPanel slider = new RadiusPanel(1, 20);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                points.setRadius(slider.getValue());
            }
        });
        slider.setValue(radius);
        west_panel.add(slider, BorderLayout.CENTER);
    }

    public void newDots() {
        ArrayList<Float> y_values = ylist.getValues();
        float x_value = xlist.getValue();
        for(int i = 0; i < y_values.size(); i++) {
            Mark mark = new Mark(x_value, y_values.get(i));
            points.add(mark);
        }
    }
}
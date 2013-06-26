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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    private JPanel master;

    private JPanel west_panel;
    private Graphic east_panel;

    private XPanel xlist;
    private YPanel ylist;

    private JLabel data_label;

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

    public void setGraphic(Graphic graphic) {
        east_panel = graphic;
        master.add(east_panel);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 800, 580);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        master = new JPanel(new GridLayout(1, 2));
        frame.getContentPane().add(master);

        west_panel = new JPanel(new FlowLayout());
        master.add(west_panel);

        data_label = new JLabel();
        west_panel.add(data_label);
    }

    public void setLabel(String label) {
        data_label.setText(label);
    }

    public void setYValues(float[] values) {
        ylist = new YPanel(values, new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                newDots();
            }
        });
        ylist.setLabel(locale.getObject("YValue") + ":");
        west_panel.add(ylist);
    }

    public void setXValues(float[] values) {
        xlist = new XPanel(values, new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                newDots();
            }
        });
        xlist.setLabel(locale.getObject("YValue") + ":");
        west_panel.add(xlist);
    }

    public void setRadius(float radius) {
        final RadiusPanel slider = new RadiusPanel(new JLabel((String)locale.getObject("Radius")));
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                points.setRadius(slider.getValue());
            }
        });
        slider.setValue(radius);
        west_panel.add(slider);
    }

    public void newDots() {
        ArrayList<Float> y_values = ylist.getValues();
        float x_value = xlist.getValue();
        for(int i = 0; i < y_values.size(); i++) {
            if(!Float.isNaN(y_values.get(i)) && !Float.isNaN(x_value)) {
                Mark mark = new Mark(x_value, y_values.get(i));
                points.add(mark);
            }
        }
    }
}
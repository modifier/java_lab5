import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 11.05.13
 * Time: 22:57
 * To change this template use File | Settings | File Templates.
 */
public class RadiusPanel extends JPanel {
    private JSpinner spinner;

    public RadiusPanel() {
        super(new GridLayout(2, 1));

        JLabel label = new JLabel("Radius:");
        add(label);

        spinner = new JSpinner();
        add(spinner);
    }

    public float getValue() {
        return (Integer)spinner.getValue();
    }

    public void setValue(float value) {
        spinner.setValue((int) value);
    }

    public synchronized void addChangeListener(ChangeListener changed) {
        spinner.addChangeListener(changed);
    }
}

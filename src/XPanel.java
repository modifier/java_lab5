import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 11.05.13
 * Time: 21:25
 * To change this template use File | Settings | File Templates.
 */
public class XPanel extends JPanel {
    private JLabel label;
    private JList x_group;
    private float[] values;

    public XPanel(float[] values, ListSelectionListener changed) {
        super(new GridLayout(0, 1));

        this.values = values;

        label = new JLabel();
        this.add(label);

        DefaultListModel model = new DefaultListModel();
        for(int i = 0; i < values.length; i++) {
            model.addElement(Float.toString(values[i]));
        }

        x_group = new JList();
        x_group.setModel(model);

        x_group.addListSelectionListener(changed);

        this.add(x_group);
    }

    public void setLabel(String label) {
        this.label.setText(label);
    }

    public float getValue() {
        if(x_group.getSelectedIndex() != -1) {
            return values[x_group.getSelectedIndex()];
        }
        return Float.NaN;
    }
}

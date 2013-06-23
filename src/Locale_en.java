import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:54
 * To change this template use File | Settings | File Templates.
 */
public class Locale_en extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object[][] contents = {
            {"CasualError", "Something is wrong."},
            {"IOError", "Data IO error."},
            {"ConnectionStart", "Port %s is open. Establish connection."},
            {"XValue", "X Value"},
            {"YValue", "Y Value"}       ,
            {"Position", "Recently added point has coordinates: (%.2f, %.2f)"},
            {"PointSize", "Point Size"},
            {"Radius", "Radius"}
    };
}

import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:58
 * To change this template use File | Settings | File Templates.
 */
public class Locale_de extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object[][] contents = {
            {"CasualError", "Etwas ist falsch."},
            {"IOError", "Eraro de IO donitajxoj."},
            {"ConnectionStart", "Port %s offen ist. Verbindung herstellen."},
            {"XValue", "X Wert"},
            {"YValue", "Y Wert"}
    };
}

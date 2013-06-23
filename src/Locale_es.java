import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:58
 * To change this template use File | Settings | File Templates.
 */
public class Locale_es extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object[][] contents = {
            {"CasualError", "Algo ha pasado."},
            {"IOError", "Error IO Data."},
            {"ConnectionStart", "El puerto %s está abierto. Establecer conexión."},
            {"XValue", "X Valor"},
            {"YValue", "Y Valor"},
            {"Position", "Puntos recientemente agregado tiene coordenadas: (%.2f, %.2f)"},
            {"PointSize", "Tamaño de punto"},
            {"Radius", "Radio"}
    };
}

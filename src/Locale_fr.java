import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:58
 * To change this template use File | Settings | File Templates.
 */
public class Locale_fr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object[][] contents = {
            {"CasualError", "Quelque chose ne va pas."},
            {"IOError", "IO data error."},
            {"ConnectionStart", "Port %s est ouvert. Établir la connexion."},
            {"XValue", "X Valuer"},
            {"YValue", "Y Valuer"}       ,
            {"Position", "Point ajouté récemment a pour coordonnées: (%.2f, %.2f)"},
            {"PointSize", "Taille du point"},
            {"Radius", "Radius"}
    };
}

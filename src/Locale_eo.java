import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:58
 * To change this template use File | Settings | File Templates.
 */
public class Locale_eo extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object[][] contents = {
            {"CasualError", "Ion estas malgxusta."},
            {"IOError", "Eraro de IO donitajxoj."},
            {"ConnectionStart", "Porto %s estas apertan. Mi instalas kunigon."}
    };
}

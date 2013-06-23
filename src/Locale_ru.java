import java.util.ListResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 27.05.13
 * Time: 0:54
 * To change this template use File | Settings | File Templates.
 */
public class Locale_ru extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return contents;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private Object[][] contents = {
            {"CasualError", "Что-то не так."},
            {"IOError", "Ошибка ввода-вывода данных."},
            {"ConnectionStart", "Порт %s открыт. Соединение установлено."},
            {"XValue", "Значение X"},
            {"YValue", "Значение Y"}       ,
            {"Position", "Недавно добавленная точка имеет координаты: (%.2f, %.2f)"},
            {"PointSize", "Размер точки"},
            {"Radius", "Радиус"}
    };
}

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 12.05.13
 * Time: 2:11
 * To change this template use File | Settings | File Templates.
 */
public class MarkCollection extends Observable {
    private ArrayList<Mark> points;
    private float radius;
    private ClientArea area;

    public MarkCollection() {
        this.points = new ArrayList<Mark>();
    }

    public void add(Mark mark) {
        for(int i = 0; i < points.size(); i++) {
            if(mark.equals(points.get(i))) {
                return;
            }
        }

        points.add(mark);
        mark.radius = radius / 8;

        setChanged();
        notifyObservers("add");
    }

    public Mark last() {
        return points.get(points.size() - 1);
    }

    public void setRadius(float radius) {
        this.radius = radius;
        area = new ClientArea(radius);
        check();

        setChanged();
        notifyObservers("change");
    }

    public float getRadius() {
        return radius;
    }

    public void check() {
        forEach(new IMarkIterator() {
            @Override
            public boolean Iterate(Mark mark, MarkStatus isInside) {
                if(isInside == MarkStatus.Outside) {
                    setChanged();
                    notifyObservers("animate");
                    return false;
                }
                return true;
            }
        });
    }

    public void forEach(IMarkIterator foo) {
        for(int i = 0; i < points.size(); i++) {
            if(!foo.Iterate(points.get(i), area.contains(points.get(i)))) {
                break;
            };
        }
    }
}

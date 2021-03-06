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

        setChanged();
        notifyObservers("change");
    }

    public void setRadius(float radius) {
        check(radius);
        this.radius = radius;
        area = new ClientArea(radius);

        setChanged();
        notifyObservers("change");
    }

    public float getRadius() {
        return radius;
    }

    public void check(final float radius) {
        final ClientArea new_area = new ClientArea(radius);
        forEach(new IMarkIterator() {
            @Override
            public boolean Iterate(Mark mark, MarkStatus isInside) {
                if(new_area.contains(mark) == MarkStatus.Outside && isInside == MarkStatus.Inside) {
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

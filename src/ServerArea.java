/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 14.05.13
 * Time: 0:17
 * To change this template use File | Settings | File Templates.
 */
public class ServerArea {
    private float radius;
    public ServerArea(float R) {
        this.radius = R;
    }

    public boolean contains(Mark m) {
        if(m.top() && m.right()) {
            return m.x*m.x + m.y*m.y < radius*radius / 4;
        } else if(m.top() && (m.left() || m.middle())) {
            return m.x > -radius && m.y < radius / 2;
        } else if((m.bottom() || m.vmiddle()) && m.right()) {
            return 2 * m.x - radius < m.y;
        }
        return false;
    }
}

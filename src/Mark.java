/**
 * Created with IntelliJ IDEA.
 * User: Модификатор
 * Date: 11.05.13
 * Time: 15:38
 * To change this template use File | Settings | File Templates.
 */

public class Mark {
    public float x;
    public float y;
    public float radius;

    public Mark(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Mark mark) {
        return mark.x == x && mark.y == y;
    }

    public boolean top() {
        return y > 0;
    }

    public boolean bottom() {
        return y < 0;
    }

    public boolean vmiddle() {
        return y == 0;
    }

    public boolean right() {
        return x > 0;
    }

    public boolean left() {
        return x < 0;
    }

    public boolean middle() {
        return x == 0;
    }
}
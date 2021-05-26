import java.awt.*;

public class HilbertCurve extends Shape {
    private Graphics2D g;
    private int count = 0;
    int order = 4;
    int n = (int) Math.pow(2, order);
    int totalPoints = n * n;
    Point[] path = new Point[totalPoints];

    public HilbertCurve(Main main) {
        super(main, "Hilbert Curve");
    }

    public void begin(Graphics g) {
        count += 1;
        if(count > totalPoints )
            count--;
        this.g = (Graphics2D) g;
        int width = main.getFrame().getWidth();

        float len = width / n;

        for (int i = 0; i < count; i++) {
            path[i] = hilbert(i);
            path[i].x *= len;
            path[i].y *= len;
            path[i].x += len/2;
            path[i].y += len/2;
        }

        fractal();
    }

    public int howManyTimes()
    {
        return totalPoints * 2;
    }

    @Override
    public void restart() {
        count = 0;
    }

    private void fractal() {


        for (int i = 1; i < count; i++) {
            g.drawLine((int) path[i].x, (int) path[i].y + 70, (int) path[i-1].x, (int) path[i-1].y + 70);
            //System.out.println("x: " + path[i].x + "  y: " + path[i].y + "  x i-1: "+ path[i-1].x + " y i-1: " + path[i-1].y);
        }


    }

    Point hilbert(int i) {
        Point[] points = {
                new Point(0, 0),
                new Point(0, 1),
                new Point(1, 1),
                new Point(1, 0)
        };

        int index = i & 3;
        Point v = points[index];

        for (int j = 1; j < order; j++) {
            i = i >>> 2;
            index = i & 3;
            int len = (int) Math.pow(2, j);
            if (index == 0) {
                float temp = v.x;
                v.x = v.y;
                v.y = temp;
            } else if (index == 1) {
                v.y += len;
            } else if (index == 2) {
                v.x += len;
                v.y += len;
            } else
            {
                float temp = len - 1 - v.x;
                v.x = len - 1 - v.y;
                v.y = temp;
                v.x += len;
            }
        }

        return v;
    }

    public void setAngle1(double angle1) {
        if(angle1 < 10)
            order = (int) angle1;
        else
            order = 4;

        n = (int) Math.pow(2, order);
        totalPoints = n * n;
        path = new Point[totalPoints];

    }

    public void setAngle2(double angle2) {

    }
}

class Point
{

    float x;
    float y;

    Point(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

}

import java.awt.Graphics;
import java.awt.Graphics2D;


public class RhombusTree extends Shape {
    private Graphics2D g;
    private int length = 300;
    private int count = 0;
    private double angle1 = Math.PI / 4;
    private double angle2 = Math.PI / 4;

    public RhombusTree(Main main) {
        super(main, "Fractal Tree");
    }

    public void begin(Graphics g) {
        if(++count > 10)
            count--;
        this.g = (Graphics2D) g;
        int width = main.getFrame().getWidth();
        int height = main.getFrame().getHeight();

        g.translate(width / 2, height);
        fractal(length, count - 1);
    }

    public int howManyTimes()
    {
        return 25;
    }

    @Override
    public void restart() {
        count = 0;
    }

    private void fractal(int length, int count) {
        g.drawLine(0, 0, 0, -length);
        g.translate(0, -length);

        if(count < 1)
            return;

        g.rotate(angle1);
        fractal(length / 3 * 2, count - 1);

        g.translate(0, length / 3 * 2);
        g.rotate(-angle1);

        g.rotate(-angle2);
        fractal(length / 3 * 2, count - 1);

        g.translate(0, length / 3 * 2);
        g.rotate(angle2);

        g.rotate(-Math.toRadians(0));
        fractal(length / 3 * 2, count - 1);

        g.translate(0, length / 3 * 2);
        g.rotate(Math.toRadians(0));
    }

    public void setAngle1(double angle1) {
        this.angle1 = Math.toRadians(angle1);
    }

    public void setAngle2(double angle2) {
        this.angle2 = Math.toRadians(angle2);
    }
}

import java.awt.Graphics;
import java.awt.Graphics2D;


public class AnimateTree extends Shape {
    private Graphics2D g;
    private int length = 300;
    private int count = 15;
    private int howManyIterations = 0;
    private double angle1;
    private double angle2;
    private double angle1Before = 0;
    private double angle2Before = 0;

    public AnimateTree(Main main) {
        super(main, "Animate Tree");
    }

    public void begin(Graphics g) {

        howManyIterations++;

        if(howManyIterations <= 720)
        {
            angle1Before += 0.5;
            angle2Before += 0.5;
        }else
        {
            angle1Before += 0.5;
            angle2Before -= 1;
        }

        angle1 = Math.toRadians(angle1Before);
        angle2 = Math.toRadians(angle2Before);

        this.g = (Graphics2D) g;
        int width = main.getFrame().getWidth();
        int height = main.getFrame().getHeight();

        g.translate(width / 2, height);
        fractal(length, count - 1);
    }

    public int howManyTimes()
    {
        return 2880;
    }

    @Override
    public void restart() {
        howManyIterations = 0;
        count = 15;
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

    }

    public void setAngle1(double angle1) {
        this.angle1 = Math.toRadians(angle1);
    }

    public void setAngle2(double angle2) {
        this.angle2 = Math.toRadians(angle2);
    }
}
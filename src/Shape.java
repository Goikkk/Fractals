import java.awt.Graphics;
import java.awt.Graphics2D;


public abstract class Shape {
    protected Main main;
    protected Graphics2D g;
    private String name;
    private int count;

    public Shape(Main main, String name) {
        this.main = main;
        this.name = name;
    }

    public abstract void begin(Graphics g);

    public String getName() {
        return name;
    }

    public abstract void restart();
    public abstract int howManyTimes();

    public abstract void setAngle1(double parseDouble);
    public abstract void setAngle2(double parseDouble);
}

import java.awt.*;


public class FractalPyramid extends Shape {
    private Graphics2D g;
    private int length = 310;
    private int count = 0;
    private int fact = 2;
    private int fact2 = 2;
    private int fact3 = 2;


    public FractalPyramid(Main main) {
        super(main, "Fractal Pyramid");
    }


    /**
     * Is call howManyTimes and with every call draws one shape more
     */
    public void begin(Graphics g) {

        if(++count > 30)
            count--;

        this.g = (Graphics2D) g;

        length = 310;
        fact = 2;
        fact2 = 2;
        fact3 = 2;

        fractal(count, 200, 200);
    }

    @Override
    public void restart() {
        count = 0;
    }

    @Override
    public int howManyTimes() {
        return 60;
    }


    /**
     * Recursively draws smaller and smaller squares
     * @param count how many squares
     * @param x position of new square
     * @param y position of new square
     */
    private void fractal( int count, int x, int y) {

        if(count < 1)
            return;

        if(length > 10)
        {
            length -= 10;

            drawRect(length, x + fact - 2, y + fact - 2);
            drawRect(length, x - fact, y - fact);

            drawRect(length, 300 + x + fact2, y - fact);
            drawRect(length, 300 + x - fact + fact3, y + fact-2);

            drawRect(length, x + fact - 2, 300 + y - fact + fact3);
            drawRect(length, x - fact, 300 + y + fact2-2);

            drawRect(length, 300 + x - fact + fact3, 300 + y - fact + fact3);
            drawRect(length, 300 + x + fact2, 300 + y + fact2-2);

            fact += 2;
            fact2 += 12;
            fact3 += 10;
        } else
            return;

        fractal(count-1, x, y);

    }

    private void drawRect(int length, int x, int y)
    {
        g.drawRect(x,y, length, length);
    }

    @Override
    public void setAngle1(double parseDouble) {}

    @Override
    public void setAngle2(double parseDouble) {}
}

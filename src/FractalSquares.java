import java.awt.*;

public class FractalSquares extends Shape {
    private Graphics2D g;
    private int length = 310;
    private int count = 0;
    private int fact = 2;
    private int fact1 = 2;
    private int fact2 = 2;


    public FractalSquares(Main main) {
        super(main, "Fractal Squares");
    }

    public void begin(Graphics g) {

        if(++count > 30)
            count = 0;

        this.g = (Graphics2D) g;

        length = 310;
        fact = 2;
        fact1 = 2;
        fact2 = 2;

        fractal(count, 200, 200);
    }

    @Override
    public void restart() {
        count = 0;
    }

    @Override
    public int howManyTimes() {
        return 370;
    }

    @Override
    public void setAngle1(double parseDouble) {

    }

    @Override
    public void setAngle2(double parseDouble) {

    }

    private void fractal( int count, int x, int y) {

        if(count < 1)
            return;

        if(length > 10)
        {
            length -= 10;

            drawRect(length, x + fact - 2 + 150, y + fact - 2 + 200);

            drawRect(length, x + fact1 - 150, y + fact1 - 100);
            drawRect(length, x + fact + 150 - 2, y + fact1 - 100);
            drawRect(length, x + fact2 + 450 - 2, y + fact1 - 100);

            drawRect(length, x + fact1 - 150, y + fact + 200);
            drawRect(length, x + fact2 + 450 - 2, y + fact + 200);

            drawRect(length, x + fact1 - 150, y + fact2 + 500);
            drawRect(length, x + fact + 150 - 2, y + fact2 + 500);
            drawRect(length, x + fact2 + 450 - 2, y + fact2 + 500);

            fact += 5;
            fact1 += 2;
            fact2 += 7;
        } else
            return;

        fractal(count-1, x, y);

    }

    private void drawRect(int length, int x, int y)
    {
        g.drawRect(x,y, length, length);
    }

}

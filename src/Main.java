import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferStrategy;

/**
 * Diffrent types of fractals and Hilbert curve.
 *
 * @author Rafal Karwowski
 */
public class Main {
    private final Frame frame;
    private Shape shape;
    public BufferStrategy bs;
    int speedOfAnimation = 10;

    public Main() {

        shape = new FractalPyramid(this);
        frame = new Frame(shape.getName());

        bs = frame.getBufferStrategy();

        if(bs == null) {
            frame.createBufferStrategy(3);
            bs = frame.getBufferStrategy();
        }

        JButton buttonRestart = frame.getButtonRestart();
        JButton buttonTree = frame.getButtonTree ();
        JButton buttonPyramid = frame.getButtonPyramid();
        JButton buttonAnimate = frame.getButtonAnimate();
        JButton buttonRhombus = frame.getButtonRhombus();
        JButton buttonHilbert = frame.getButtonHilbert();
        JButton buttonSquare = frame.getButtonSquares();
        JTextField textSpeed = frame.getSpeed();
        JTextField textAngle1= frame.getAngle1();
        JTextField textAngle2 = frame.getAngle2();

        frame.addToolBar();

        buttonTree.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new FractalTree(getMain());
                shape.restart();
                shape.setAngle1(Double.parseDouble(textAngle1.getText()));
                shape.setAngle2(Double.parseDouble(textAngle2.getText()));
                draw(bs, shape);
            }
        });

        buttonAnimate.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new AnimateTree(getMain());
                shape.restart();
                draw(bs, shape);
            }
        });

        buttonSquare.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new FractalSquares(getMain());
                shape.restart();
                draw(bs, shape);
            }
        });

        buttonRhombus.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new RhombusTree(getMain());
                shape.restart();
                draw(bs, shape);
            }
        });

        buttonHilbert.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new HilbertCurve(getMain());
                shape.setAngle1(Double.parseDouble(textAngle1.getText()));
                shape.restart();
                draw(bs, shape);
            }
        });

        buttonPyramid.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape = new FractalPyramid(getMain());
                shape.restart();
                draw(bs, shape);
            }
        });

        buttonRestart.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shape.restart();
                draw(bs, shape);
            }
        });

        textSpeed.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                speedOfAnimation = Integer.parseInt(textSpeed.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                speedOfAnimation = Integer.parseInt(textSpeed.getText());
            }
        });

    }

    public Main getMain()
    {
        return this;
    }

    public void draw(BufferStrategy bs, Shape currentShape)
    {

        for(int i = 0; i < currentShape.howManyTimes(); i++)
        {
            Graphics g = bs.getDrawGraphics();

            g.setColor(Color.BLACK);
            g.clearRect(0, 70, frame.getWidth(), frame.getHeight());
            g.fillRect(0, 70, frame.getWidth(), frame.getHeight());

            g.setColor(Color.WHITE);
            currentShape.begin(g);

            g.dispose();
            bs.show();

            try {
                Thread.sleep(speedOfAnimation);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i++;

        }

        frame.addToolBar();
    }

    public Frame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        new Main();
    }

}

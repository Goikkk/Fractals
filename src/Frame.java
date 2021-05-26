import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    static final long serialVersionUID = 1L;
    JPanel jp;
    JButton buttonRestart;
    JButton buttonTree;
    JTextField angle1;
    JTextField angle2;
    JButton buttonAnimate;
    JButton buttonRhombus;
    JButton buttonPyramid;
    JButton buttonHilbert;
    JButton buttonSquares;
    JTextField speed;

    public Frame(String title) {
        //GraphicsDevice[] ged = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

        //frame = new JFrame(title);
        //if(ged.length > 1)
            //frame.setLocation(ged[1].getDefaultConfiguration().getBounds().getLocation());

        setTitle(title);
        setSize(1000,1070);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jp = new JPanel();
        jp.setSize(getSize());
        jp.setBackground(Color.white);
        jp.setLayout(null);
        jp.setLocation(0,0);


        add(jp);


        addToolBar();

        setVisible(true);

        createBufferStrategy(2);

    }

    void addToolBar()
    {

        JToolBar toolBar = new JToolBar();
        JPanel panel = new JPanel();
        buttonRestart = new JButton("Restart");
        buttonTree = new JButton("Tree");
        angle1 = new JTextField("30",3);
        angle2 = new JTextField("30",3);
        buttonAnimate = new JButton("Animate");
        buttonRhombus = new JButton("Rhombus");
        buttonPyramid = new JButton("Pyramid");
        buttonHilbert = new JButton("Hilbert");
        buttonSquares = new JButton("Hypnosis");
        speed = new JTextField("10",5);

        panel.add(buttonTree);
        panel.add(angle1);
        panel.add(angle2);
        panel.add(buttonAnimate);
        panel.add(buttonRhombus);
        panel.add(buttonPyramid);
        panel.add(buttonHilbert);
        panel.add(buttonSquares);
        panel.add(buttonRestart);
        panel.add(speed);
        toolBar.add(panel);


        add(toolBar,BorderLayout.NORTH);

        setVisible(true);

    }

    JTextField getSpeed()
    {
        return this.speed;
    }

    JButton getButtonRestart()
    {
        return this.buttonRestart;
    }
    JButton getButtonTree()
    {
        return this.buttonTree;
    }
    JButton getButtonAnimate()
    {
        return this.buttonAnimate;
    }
    JButton getButtonRhombus()
    {
        return this.buttonRhombus;
    }

    JButton getButtonPyramid()
    {
        return this.buttonPyramid;
    }

    public JButton getButtonHilbert() {
        return buttonHilbert;
    }

    public JButton getButtonSquares() {
        return buttonSquares;
    }

    public JTextField getAngle1() {
        return angle1;
    }

    public JTextField getAngle2() {
        return angle2;
    }

}

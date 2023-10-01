import javax.swing.*;
import java.awt.*;

public class DrawingPanel extends JFrame /*implements ActionListener*/ {
    private final int WIDTH = 1000;
    private final int HEIGHT = 800;
    private final int CIRCLE_CENTER_X = 500;
    private final int CIRCLE_CENTER_Y = 400;
    private final int RADIUS = 350;
    private final int FROM_ANGLE = 45;
    private final int TO_ANGLE = 135;
    private final Color FROM_COLOR = Color.RED;
    private final Color TO_COLOR = Color.BLUE;
    /*private final int TIMER_DELAY = 500;
    private Timer timer = new Timer(TIMER_DELAY, this);
    private int time = 0;*/

    public DrawingPanel() {
        setTitle("Drawing panel");
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        /*timer.start();*/
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        CircleSector circle = new CircleSector(
                CIRCLE_CENTER_X, CIRCLE_CENTER_Y, RADIUS, FROM_ANGLE, TO_ANGLE, FROM_COLOR, TO_COLOR
        );
        circle.fill((Graphics2D) g);
    }

    /*@Override
    public void actionPerformed(ActionEvent e) {
        if (time <= 270) {
            TO_ANGLE = time;
        } else if (time <= 270 + 180) {
            FROM_ANGLE = time - 270;
        } else if (time <= 270 * 2 + 180) {
            TO_ANGLE = time - 180;
        }
        if (time <= 255) {
            FROM_COLOR = new Color(time, 0, 0);
            TO_COLOR = new Color(0, 0, time);
        } else if (time <= 255 * 2) {
            FROM_COLOR = new Color(255 * 2 - time, time - 255, 0);
            TO_COLOR = new Color(time - 255, 0, 255 * 2 - time);
        } else if (time <= 255 * 3) {
            FROM_COLOR = new Color(0, 255 * 3 - time, time - 255 * 2);
            TO_COLOR = new Color(255 * 3 - time, time - 255 * 2, 0);
        }
        repaint();
        time++;
    }*/
}

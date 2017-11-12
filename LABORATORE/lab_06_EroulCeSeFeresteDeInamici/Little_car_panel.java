package lab_06_EroulCeSeFeresteDeInamici;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Little_car_panel extends JPanel implements KeyListener {
	
	private int time10 = 0;
    private Car car1 = new Car();
    private Timer timer1 = new Timer(1000, new TimerListener());
    private ArrayList<Obstacle> list1 = new ArrayList<Obstacle>();
    private Random rand1 = new Random();

    public Little_car_panel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        setFocusable(true);
        addKeyListener(this);
        timer1.start();
    }

    public void keyPressed(KeyEvent e) {
        Integer key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            car1.move_left();
            check_collision();
        }
        if (key == KeyEvent.VK_RIGHT) {
            car1.move_right();
            check_collision();
        }
    }

    public void keyReleased(KeyEvent e) {

    }


    public void keyTyped(KeyEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        car1.draw_car(g);
        for (Obstacle obstacle : list1) {
            obstacle.draw_obstacle(g);
        }
        repaint();

    }

    public void check_collision() {
        Integer carX1 = car1.getxPos();
        Integer carX2 = carX1 + car1.getWidth();
        Integer carY1 = car1.getyPos();
        Integer carY2 = carY1 + car1.getHeight();
        for (Obstacle obstacle : list1) {
            Integer obstacleX1 = obstacle.getxPos();
            Integer obstacleX2 = obstacleX1 + obstacle.getLato();
            Integer obstacleY = obstacle.getyPos() + obstacle.getLato();
            if (((obstacleX1 >= carX1 && obstacleX1 <= carX2) || (obstacleX2 >= carX1 && obstacleX2 <= carX2))
                    && ((obstacleY >= carY1 && obstacleY <= carY2))) {
                timer1.stop();
                removeKeyListener(this);
            }

        }
    }

    public class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(time10 == 10) {
            	Integer x = rand1.nextInt(420);
            	list1.add(new Obstacle(x));
            	time10 = 0;
            }else{
        		time10++;
        	}
            for (Obstacle obstacle : list1) {
            	obstacle.move_down();
            	check_collision();
        	}
        }
    }
}
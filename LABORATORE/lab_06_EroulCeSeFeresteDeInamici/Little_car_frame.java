package lab_06_EroulCeSeFeresteDeInamici;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class Little_car_frame extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Little_car_frame frame = new Little_car_frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Little_car_frame() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().add(new Little_car_panel());
    }

}


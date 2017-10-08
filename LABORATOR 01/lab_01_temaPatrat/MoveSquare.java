package lab_01_temaPatrat;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

public class MoveSquare {

	private JFrame frame;
	private int nr_clickVar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoveSquare window = new MoveSquare();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MoveSquare() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel playingGround = new JPanel();
		frame.getContentPane().add(playingGround, BorderLayout.CENTER);
		playingGround.setLayout(null);
		
		JLabel lblClicked = new JLabel("Clicked:");
		lblClicked.setBounds(10, 236, 46, 14);
		playingGround.add(lblClicked);
		
		final JLabel nr_clicks = new JLabel("");
		nr_clicks.setBounds(66, 236, 46, 14);
		playingGround.add(nr_clicks);
		
		nr_clickVar = 0;
		
		final Canvas canvas = new Canvas();
		canvas.setBackground(Color.LIGHT_GRAY);
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				nr_clickVar++;
				nr_clicks.setText(Integer.toString(nr_clickVar));
				 Graphics g = canvas.getGraphics();
			     g.fillRect(10, 10, 25, 25);
			     
			}
		});
		canvas.setBounds(10, 10, 414, 199);
		playingGround.add(canvas);
		
		
	}
	 
}

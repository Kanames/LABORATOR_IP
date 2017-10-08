package lab_01_temaPatrat;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

public class MoveSquare {

	private JFrame frame;
	private int nr_clickVar;
	Random rand = new Random();

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
		lblClicked.setBounds(10, 215, 46, 14);
		playingGround.add(lblClicked);
		
		final JLabel nr_clicks = new JLabel("");
		nr_clicks.setBounds(66, 215, 46, 14);
		playingGround.add(nr_clicks);
		
		final JLabel lblWidth = new JLabel("Width:");
		lblWidth.setBounds(288, 215, 46, 14);
		playingGround.add(lblWidth);
		
		final JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(288, 236, 46, 14);
		playingGround.add(lblHeight);
		
		final JLabel width = new JLabel("");
		width.setBounds(344, 215, 46, 14);
		playingGround.add(width);
		
		final JLabel height = new JLabel("");
		height.setBounds(344, 236, 46, 14);
		playingGround.add(height);
		
		nr_clickVar = 0;
		
		final Canvas canvas = new Canvas();
		canvas.setBounds(10, 10, 414, 199);
		
		final int width_var = canvas.getWidth();
		final int height_var = canvas.getHeight();
		System.out.println("width_var: "+canvas.getWidth());
		System.out.println("height_var: "+canvas.getHeight());
		
		width.setText(Integer.toString(width_var));
		height.setText(Integer.toString(height_var));
		
		canvas.setBackground(Color.LIGHT_GRAY);
		canvas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				nr_clickVar++;
				nr_clicks.setText(Integer.toString(nr_clickVar));
				Graphics g = canvas.getGraphics();
				canvas.paint(g);
				
//				final int x_rand=rand.nextInt(width_var);
//				final int y_rand=rand.nextInt(height_var);
				final int x_rand=e.getX();
				final int y_rand=e.getY();
				
				
				int alegereDrum = rand.nextInt(4);
				System.out.println("alegereDrum: "+alegereDrum);
				
				switch(alegereDrum) {
				
				case 0:
					System.out.println("case 1 dreapta");
					for (int drp=0; drp <= width_var-25-e.getX(); drp++) {
						canvas.paint(g);
						g.fillRect( x_rand+ drp,  y_rand, 25, 25);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					break;
				case 1:
					System.out.println("case 2 jos");
					for (int jos=0; jos <= height_var-25-e.getY(); jos++) {
						canvas.paint(g);
						g.fillRect( x_rand,  y_rand+ jos, 25, 25);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					break;
				case 2:
					System.out.println("case 3 stanga ");
					
					for (int stg=0; stg <= width_var-25-e.getX(); stg++) {
						canvas.paint(g);
						g.fillRect( x_rand - stg,  y_rand, 25, 25);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					break;
				case 3:
					System.out.println("case 4 sus");
					for (int sus=0; sus <= width_var-25-e.getX(); sus++) {
						canvas.paint(g);
						g.fillRect( x_rand ,  y_rand- sus, 25, 25);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					break;
				}
				
				
				
				
				
				
				
//				 g.clearRect(width_var+nr_clickVar,hright_var+nr_clickVar, 25, 25);
//				 g.drawRect(width_var+nr_clickVar,hright_var+nr_clickVar, 25, 25);
				 
			}
		});
		
		playingGround.add(canvas);

		
	}
	 
}

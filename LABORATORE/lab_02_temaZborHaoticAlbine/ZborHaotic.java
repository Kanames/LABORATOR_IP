package lab_02_temaZborHaoticAlbine;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZborHaotic {

	private JFrame frame;
	private Random random = new Random();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ZborHaotic window = new ZborHaotic();
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
	public ZborHaotic() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 851, 517);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel MainJPanel = new JPanel();
		MainJPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(MainJPanel, BorderLayout.CENTER);
		MainJPanel.setLayout(null);
		
		JPanel AreaControl = new JPanel();
		AreaControl.setBackground(Color.LIGHT_GRAY);
		AreaControl.setBounds(10, 11, 825, 92);
		MainJPanel.add(AreaControl);
		AreaControl.setLayout(null);
		
		JLabel DimensionArea = new JLabel("Dimensiunea zonei de zbor:");
		DimensionArea.setBounds(10, 11, 155, 14);
		AreaControl.add(DimensionArea);
		JLabel lblNewLabel = new JLabel("Width:");
		lblNewLabel.setBounds(10, 35, 46, 14);
		AreaControl.add(lblNewLabel);
		
		JLabel lblX = new JLabel("Height:");
		lblX.setBounds(10, 60, 46, 14);
		AreaControl.add(lblX);
		
		final JLabel widthLbl = new JLabel("");
		widthLbl.setBounds(54, 36, 46, 14);
		AreaControl.add(widthLbl);
		
		final JLabel heightLbl = new JLabel("");
		heightLbl.setBounds(54, 60, 46, 14);
		AreaControl.add(heightLbl);
		
		
		final JPanel AreaFlying = new JPanel() {
		    public void paintComponent(Graphics g) {	
  
		    }
		};
		AreaFlying.setBackground(Color.LIGHT_GRAY);
		AreaFlying.setBounds(10, 114, 825, 363);
		MainJPanel.add(AreaFlying);
		
		final int maxWidthFlyingZone =  AreaFlying.getWidth();
		final int maxHeightFlyingZone = AreaFlying.getHeight();
		
		widthLbl.setText(Integer.toString(maxWidthFlyingZone));
		heightLbl.setText(Integer.toString(maxHeightFlyingZone));

		 
		
		JButton btnFly = new JButton("+ Fly");
		btnFly.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				
				int xCurrent = random.nextInt(825);
				int yCurrent = random.nextInt(363);
				
				int xCurrent2 = random.nextInt(825);
				int yCurrent2 = random.nextInt(363);
				//-pentru a desena o albina START
				File pathToFile = new File("C:\\Users\\stefa\\Desktop\\a.png");
			    Image img = null;
				try {
					img = ImageIO.read(pathToFile);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//-pentru a desena o albina END
				
				
				Graphics g = AreaFlying.getGraphics();
				g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
				g.clearRect(0, 0, 825, 363);

			  
				boolean miscareB = true;
				int miscare = 8;
				int viteaza = 7;
				while (miscareB) {
					int alegereDrum = random.nextInt(9);
					switch (alegereDrum) {
					case 1:
						for (int i = 0; i < miscare; i++) {
							g.clearRect(0, 0, 825, 363);
							xCurrent= xCurrent+i;
//							g.fillRoundRect(xCurrent, yCurrent, 25 + i, 25, 80, 80);
							g.drawImage(img,xCurrent,yCurrent,80,80,null);
							g.drawImage(img,xCurrent2,yCurrent2,80,80,null);
							try {
								Thread.sleep(viteaza);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case 2:
						for (int i = 0; i < miscare; i++) {
							g.clearRect(0, 0, 825, 363);
							yCurrent = yCurrent +i;
//							g.fillRoundRect(xCurrent, yCurrent + i, 25, 25, 80, 80);
							g.drawImage(img,xCurrent,yCurrent,80,80,null); 
							g.drawImage(img,xCurrent2,yCurrent2,80,80,null);
							try {
								Thread.sleep(viteaza);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case 3:
						for (int i = 0; i < miscare; i++) {
							g.clearRect(0, 0, 825, 363);
							xCurrent = xCurrent - i;
							xCurrent2 = xCurrent2 - i;
//							g.fillRoundRect(xCurrent, yCurrent, 25, 25, 80, 80);
							g.drawImage(img,xCurrent,yCurrent,80,80,null); 
							g.drawImage(img,xCurrent2,yCurrent2,80,80,null);
							try {
								Thread.sleep(viteaza);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case 4:
						for (int i = 0; i < miscare; i++) {
							g.clearRect(0, 0, 825, 363);
							yCurrent = yCurrent - i;
							yCurrent2 = yCurrent2 - i;
//							g.fillRoundRect(xCurrent, yCurrent, 25, 25, 80, 80);
							g.drawImage(img,xCurrent,yCurrent,80,80,null); 
							g.drawImage(img,xCurrent2,yCurrent2,80,80,null);
							try {
								Thread.sleep(viteaza);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case 5:
						for (int i = 0; i < miscare; i++) {
							g.clearRect(0, 0, 825, 363);
							yCurrent = yCurrent - i;
							xCurrent = xCurrent - i;
							yCurrent2 = yCurrent2 - i;
							xCurrent2 = xCurrent2 + i;
//							g.fillRoundRect(xCurrent, yCurrent, 25, 25, 80, 80);
							g.drawImage(img,xCurrent,yCurrent,80,80,null); 
							g.drawImage(img,xCurrent2,yCurrent2,80,80,null);
							try {
								Thread.sleep(viteaza);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case 6:
						for (int i = 0; i < miscare; i++) {
							g.clearRect(0, 0, 825, 363);
							yCurrent = yCurrent + i;
							xCurrent = xCurrent + i;
							yCurrent2 = yCurrent2 - i;
							xCurrent2 = xCurrent2 + i;
//							g.fillRoundRect(xCurrent, yCurrent, 25, 25, 80, 80);
							g.drawImage(img,xCurrent,yCurrent,80,80,null); 
							g.drawImage(img,xCurrent2,yCurrent2,80,80,null);
							try {
								Thread.sleep(viteaza);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case 7:
						for (int i = 0; i < 5; i++) {
							g.clearRect(0, 0, 825, 363);
							yCurrent = yCurrent + i;
							xCurrent = xCurrent - i;
							yCurrent2 = yCurrent2 - i;
							xCurrent2 = xCurrent2 + i;
//							g.fillRoundRect(xCurrent, yCurrent, 25, 25, 80, 80);
							g.drawImage(img,xCurrent,yCurrent,80,80,null); 
							g.drawImage(img,xCurrent2,yCurrent2,80,80,null);
							try {
								Thread.sleep(viteaza);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					case 8:
						for (int i = 0; i < 5; i++) {
							g.clearRect(0, 0, 825, 363);
							yCurrent = yCurrent - i;
							xCurrent = xCurrent + i;
							yCurrent2 = yCurrent2 - i;
							xCurrent2 = xCurrent2 + i;
//							g.fillRoundRect(xCurrent, yCurrent, 25, 25, 80, 80);
							g.drawImage(img,xCurrent,yCurrent,80,80,null); 
							g.drawImage(img,xCurrent2,yCurrent2,80,80,null);
							try {
								Thread.sleep(viteaza);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						break;
					}
					widthLbl.setText(Integer.toString(xCurrent));
					heightLbl.setText(Integer.toString(yCurrent));
					if(yCurrent < 0 || xCurrent < 0 || yCurrent >363  || xCurrent >  825) {
						miscareB = false;
					}
					
					
				}
			
			}
		});
		btnFly.setBounds(692, 11, 123, 23);
		AreaControl.add(btnFly);
		
		
	}
	
}

package lab_06_EroulCeSeFeresteDeInamici;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class App {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel Erou = new JLabel();
	File pathToFile = new File("C:\\Users\\Asus Home\\Desktop\\a.png");
    Image img = null;
	public App() {
		try {
			img = ImageIO.read(pathToFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5); // (gapUp,gapLeft,gapRight,gapDown)

		Erou.setIcon(new Icon() {
			
			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				g.drawImage(img,c.getHeight(),c.getWidth(),500,500,null);
			}
			
			@Override
			public int getIconWidth() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int getIconHeight() {
				// TODO Auto-generated method stub
				return 0;
			}
		});
		gbc.gridx = 0; // coloana 1
		gbc.gridy = 1; // rand 1
		panel.add(Erou, gbc);

		gbc.gridwidth = 2;  //CATE COLOANA VREAU SA IAU 
		gbc.gridx = 0; // coloana 1
		gbc.gridy = 3; // rand 3
		panel.add(Erou, gbc);
		
	
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new App();
			}
		});
	}

}
package lab_05_Formular;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.jws.soap.SOAPBinding.Style;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GridBagLayoutTutorial {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel labNume = new JLabel("Nume: ");
	JLabel labPrenume = new JLabel("Prenume: ");
	JLabel labCnp = new JLabel("CNP: ");
	JLabel labERR = new JLabel();
	JTextField nume   = new JTextField(15);
	JTextField prenume   = new JTextField(15);
	JTextField cnp   = new JTextField(15);
	JButton register = new JButton("Register");

	public GridBagLayoutTutorial() {
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(5, 5, 5, 5); // (gapUp,gapLeft,gapRight,gapDown)
 
		gbc.gridx = 0; // coloana 1 
		gbc.gridy = 0; // rand 0
		panel.add(labNume, gbc);
		gbc.gridx = 1; // coloana 2
		gbc.gridy = 0; // rand 0
		panel.add(nume, gbc);

		gbc.gridx = 0; // coloana 1
		gbc.gridy = 1; // rand 1
		panel.add(labPrenume, gbc);
		gbc.gridx = 1; // coloana 2
		gbc.gridy = 1; // rand 1
		panel.add(prenume, gbc);
		
		gbc.gridx = 0; // coloana 1
		gbc.gridy = 2; // rand 2
		panel.add(labCnp, gbc);
		gbc.gridx = 1; // coloana 2
		gbc.gridy = 2; // rand 2
		panel.add(cnp, gbc);
		
		gbc.gridwidth = 2;  //CATE COLOANA VREAU SA IAU 
		gbc.gridx = 0; // coloana 1
		gbc.gridy = 3; // rand 3
		panel.add(register, gbc);
		
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean insertMADE = false;
				try {
					Persoana pers = new Persoana();
					String tmp_nume = nume.getText().trim();
					String tmp_prenume   = prenume.getText().trim();
					String tmp_cnp   = cnp.getText().trim();
					
					if(tmp_nume.length() < 1 || tmp_prenume.length() < 1 ){
						throw new Exception("Trebuie completate toate cele 3 input-uri");
					}
					if(tmp_cnp.length() != 13 ){
						throw new Exception("CNP-ul are 13 caractere");
					}
					if(tmp_nume.matches(".*\\d+.*") || tmp_prenume.matches(".*\\d+.*")) {
						throw new Exception("Nume si prenume nu trebuie sa contine cifre");
					}

					pers.setNume(tmp_nume);
					pers.setPrenume(tmp_prenume);
					pers.setCnp(tmp_cnp);
					
					 insertMADE = UtilityDB.insertPersoana(pers);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
					labERR.setForeground(Color.red);
					labERR.setText(e1.getMessage().toString());
				}catch (Exception e2) {
					System.out.println(e2.getMessage());
					labERR.setForeground(Color.red);
					labERR.setText(e2.getMessage());
				}
				
				System.out.println(insertMADE);
				if(insertMADE){
					labERR.setForeground(Color.GREEN);
					labERR.setText("Inserat cu succes ... ");
					panel.add(labERR, gbc);
				}

			}
			
		});
		
		gbc.gridwidth = 2;
		gbc.gridx = 0; // coloana 1
		gbc.gridy = 4; // rand 4
		labERR.setFont(new Font("Monospaced",12, 12));
		panel.add(labERR, gbc);
		
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new GridBagLayoutTutorial();
			}
		});
	}

}
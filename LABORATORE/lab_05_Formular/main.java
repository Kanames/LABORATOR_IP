package lab_05_Formular;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class main {

	private JFrame frame;
	private JTextField nume;
	private JTextField prenume;
	private JTextField cnp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
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
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 223, 289);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel Container = new JPanel();
		frame.getContentPane().add(Container, BorderLayout.CENTER);
		Container.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		Container.add(panel);
		
		JTextPane txtpnIntroducerePersoane = new JTextPane();
		txtpnIntroducerePersoane.setBackground(SystemColor.control);
		txtpnIntroducerePersoane.setForeground(Color.DARK_GRAY);
		txtpnIntroducerePersoane.setText("Inregistrare persoane");
		panel.add(txtpnIntroducerePersoane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 437, 30);
		Container.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("REGISTRARE PERSOANE");
		lblNewLabel_1.setLabelFor(frame);
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setBounds(40, 8, 150, 14);
		panel_1.add(lblNewLabel_1);
		
		nume = new JTextField();
		nume.setBounds(10, 67, 178, 20);
		Container.add(nume);
		nume.setColumns(10);
		
		prenume = new JTextField();
		prenume.setColumns(10);
		prenume.setBounds(11, 105, 178, 20);
		Container.add(prenume);
		
		cnp = new JTextField();
		cnp.setColumns(10);
		cnp.setBounds(47, 136, 141, 20);
		Container.add(cnp);
		
		JLabel lblNewLabel = new JLabel("Nume:");
		lblNewLabel.setBounds(10, 48, 82, 14);
		Container.add(lblNewLabel);
		
		JLabel lblPrenume = new JLabel("Prenume:");
		lblPrenume.setBounds(10, 88, 82, 14);
		Container.add(lblPrenume);
		
		JLabel lblCnp = new JLabel("CNP:");
		lblCnp.setBounds(13, 138, 82, 14);
		Container.add(lblCnp);
		
		JLabel eroare = new JLabel("");
		eroare.setBounds(10, 208, 187, 14);
		Container.add(eroare);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Persoana pers = new Persoana();
				pers.setNume(nume.getText());
				pers.setPrenume(prenume.getText());
				pers.setCnp(cnp.getText());
				
				try {
					UtilityDB.runQuery(dbHandler.insertPersoana(pers));
					nume.setText("");
					prenume.setText("");
					cnp.setText("");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					eroare.setText("Registrare failed !");
					e.printStackTrace();
				}
				
				eroare.setText("Registrare cu succes !");
			}
		});
		btnNewButton.setBounds(35, 174, 125, 23);
		Container.add(btnNewButton);
		
		
	}
}

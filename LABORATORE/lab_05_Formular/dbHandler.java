package lab_05_Formular;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class dbHandler {
	
	private static String strBuff;

	public static String insertPersoana(Persoana persObj) throws SQLException {
		String nume = persObj.getNume();
		String prenume = persObj.getPrenume();
		String cnp = persObj.getCnp();
		strBuff = "INSERT INTO world.ugal_persoane(PERS_NUME,PERS_PRENUME,PERS_CNP) VALUES('"+nume+"','"+prenume+"','"+cnp+"');";
		System.out.println(strBuff.toString());
		return strBuff;
	}
		
}

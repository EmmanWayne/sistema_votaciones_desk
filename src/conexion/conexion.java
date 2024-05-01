package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {

	private final String base = "sv_ipm_bd";
	private final String user = "ipm";
	private final String password = "IPM2024.";
	public static String urlGlobal = "192.168.1.123";
	private final String url = "jdbc:mysql://" + urlGlobal + "/" + base;
	private Connection con = null;

	public Connection conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(this.url, this.user, this.password);
		} catch (SQLException e) {
			System.err.println(e);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
		}
		return con;
	}

	public void desconectar() {
		con = null;
	}
}

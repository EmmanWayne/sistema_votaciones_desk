package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import clases.votantes;
import conexion.conexion;

public class consultas_votantes extends conexion {

	public boolean insertar(votantes votantes) {
		PreparedStatement ps = null;
		Connection con = conectar();

		String sql = "INSERT INTO votantes (nombre_votante, dni_votante, grado_votante, modalidad_votante, estado_votante) VALUES(?,?,?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, votantes.getNombre_votante());
			ps.setString(2, votantes.getDni_votante());
			ps.setString(3, votantes.getGrado_votante());
			ps.setString(4, votantes.getModalidad_votante());
			ps.setInt(5, votantes.getEstado_votante());
			ps.execute();
			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	public boolean actualizar(votantes votantes) {
		PreparedStatement ps = null;
		Connection con = conectar();

		String sql = "UPDATE votantes SET nombre_votante=?, dni_votante=? grado_votante=?, modalidad_votante=?, estado_votante=? WHERE id_votante=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, votantes.getNombre_votante());
			ps.setString(2, votantes.getDni_votante());
			ps.setString(3, votantes.getGrado_votante());
			ps.setString(4, votantes.getModalidad_votante());
			ps.setInt(5, votantes.getEstado_votante());
			ps.setInt(6, votantes.getId_votante());
			ps.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}


	public boolean buscarVotante(votantes votantes) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = conectar();

		String sql = "SELECT * FROM votantes WHERE dni_votante=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, votantes.getDni_votante());
			rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	public boolean actualizarEstado(votantes votantes) {
		PreparedStatement ps = null;
		Connection con = conectar();

		String sql = "UPDATE votantes SET estado_votante=? WHERE dni_votante=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, votantes.getEstado_votante());
			ps.setString(2, votantes.getDni_votante());
			ps.execute();

			return true;
		} catch (SQLException e) {
			System.err.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}

	}



}

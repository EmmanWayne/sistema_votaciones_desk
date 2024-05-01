package consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import clases.candidatos;
import conexion.conexion;

public class consultas_candidatos extends conexion {

	public boolean insertar(candidatos candidatos) {
		PreparedStatement ps = null;
		Connection con = conectar();
		String sql = "INSERT INTO candidatos (nombre_candidato, foto_candidato, votos_candidato) VALUES(?,?,?)";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, candidatos.getNombre_candidato());
			ps.setString(2, candidatos.getFoto_candidato());
			ps.setInt(3, candidatos.getVotos_candidato());
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

	public boolean actualizar(candidatos candidatos) {
		PreparedStatement ps = null;
		Connection con = conectar();

		String sql = "UPDATE candidatos SET nombre_candidato=?, foto_candidato=?, votos_candidato=? WHERE id_candidato=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, candidatos.getNombre_candidato());
			ps.setString(2, candidatos.getFoto_candidato());
			ps.setInt(3, candidatos.getVotos_candidato());
			ps.setInt(4, candidatos.getId_candidato());
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

	public boolean agregarVotos(candidatos candidatos) {
		PreparedStatement ps = null;
		Connection con = conectar();

		String sql = "UPDATE candidatos SET votos_candidato=? WHERE id_candidato=?";

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, candidatos.getVotos_candidato());
			ps.setInt(2, candidatos.getId_candidato());
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

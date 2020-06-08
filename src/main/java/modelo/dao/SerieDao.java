package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.pojo.Serie;
import modelo.conexion.ConnectionManager;

public class SerieDao {

	public static SerieDao INSTANCE = null;

	public SerieDao() {
		super();
	}

	public static synchronized SerieDao getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new SerieDao();
		}
		return INSTANCE;
	}

	public ArrayList<Serie> getAll() {
		ArrayList<Serie> registros = new ArrayList<Serie>();
		String sql = "SELECT id, nombre FROM serie ORDER BY id DESC; ";

		try (Connection con = ConnectionManager.getConnection(); PreparedStatement pst = con.prepareStatement(sql); ResultSet rs = pst.executeQuery();) {

			while (rs.next()) {

				// recuperar columnas del result set
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");

				// crear pojo con datos del result set
				Serie serie = new Serie();
				serie.setId(id);
				serie.setNombre(nombre);

				// guardar en ArrayList
				registros.add(serie);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return registros;
	}

}

package controller;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Artigo;
import model.ArtigoDAO;

public class ArtigoController {
	
	public void create(Artigo artigo) throws SQLException
	{
		ArtigoDAO model = new ArtigoDAO();
		model.create(artigo);
	}
	
	
	public List<Artigo> read() {
		List<Artigo> lista = new ArrayList<Artigo>();
		
		ArtigoDAO model = new ArtigoDAO();
		lista = model.read();
		return lista;
		
	}

	public void update(Artigo artigo) throws SQLException {
		ArtigoDAO model = new ArtigoDAO();
		model.update(artigo);
	}
	
	
	public void delete(Artigo artigo) throws SQLException {
		ArtigoDAO model = new ArtigoDAO();
		model.delete(artigo);
	}
	
}
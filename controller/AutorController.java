package controller;
import java.sql.SQLException;

import bo.Autor;
import model.AutorDAO;
import view.HomeView;

public class AutorController {
	
	public void create(Autor autor) throws SQLException {

			AutorDAO model = new AutorDAO();
			model.create(autor);

	}
	public void read() {}
	
	public void update(Autor autor) throws SQLException {

			AutorDAO model = new AutorDAO();
			model.update(autor);


	}
	public void delete(Autor autor) throws SQLException {
		Autor resposta = new Autor();
		AutorDAO model = new AutorDAO();
		resposta = model.login(autor);
		
		if (resposta.getCpf().equalsIgnoreCase(autor.getCpf()) && resposta.getSenha().equalsIgnoreCase(autor.getSenha())) {
			System.out.println("Informações Corretas !");
			model.delete(autor);
			}
		else {
			throw new RuntimeException("Informações Invalidas !");
	}
	}
	
	public void login(Autor autor) {

		Autor resposta = new Autor();
		AutorDAO model = new AutorDAO();
		resposta = model.login(autor);
		
		if (resposta.getCpf().equalsIgnoreCase(autor.getCpf()) && resposta.getSenha().equalsIgnoreCase(autor.getSenha())) {
			System.out.println("Acesso Permitido");
			new HomeView(autor.getCpf());}
		else {
			throw new RuntimeException("Acesso Não permitido!");
	}
	}
	
}

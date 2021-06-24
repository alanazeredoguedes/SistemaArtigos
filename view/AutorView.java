package view;

import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTextField;

import bo.Autor;
import controller.AutorController;

public class AutorView {
	
	public void Login(JTextField cpf , JTextField senha, JLabel resultado)
	{
		String cpf1 = cpf.getText().trim();
		String senha2 = senha.getText().trim();
		Autor autor = new Autor();
		autor.setCpf(cpf1);
		autor.setSenha(senha2);
		
		try {
			AutorController controller = new AutorController();
			controller.login(autor);
		}
		catch(Exception e)
		{
			resultado.setText("Sem Acesso");
			System.out.println(e);
		}
		
	}
	
	public void create(Autor autor,JLabel resultado) {
		try {
			AutorController controller = new AutorController();
			controller.create(autor);
			resultado.setText("Concluido !");
		}
		catch(SQLException e)
		{
			resultado.setText("Não possivel no Momento");
			System.out.println(e);
		}
	}
	
	public void update(Autor autor , JLabel resultado) {
		try {
			AutorController controller = new AutorController();
			controller.update(autor);
			resultado.setText("Autor Atualizada!");
		}
		catch(SQLException e)
		{
			resultado.setText("Tente Novamente");
			System.out.println(e);
		}
	}
	public void delete(Autor autor, JLabel resultado) {
		//Recebo CPF e Senha
		try {
		AutorController controller = new AutorController();
		controller.delete(autor);}
		catch(SQLException e)
		{
			resultado.setText("Tente Novamente");
			System.out.println(e);
		}
		
	}
}

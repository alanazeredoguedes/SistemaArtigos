package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import bo.Artigo;
import controller.ArtigoController;

public class ArtigoView {

	public void create(Artigo artigo, JLabel resultado) {
		try {
			ArtigoController controller = new ArtigoController();
			controller.create(artigo);
			resultado.setText("Artigo Criado com Sucesso !");
			//ArtigoController controller1 = new ArtigoController();
			//controller1.update(artigo);
			}
		catch(Exception e1) {
			resultado.setText("Tente Novamente!");
			System.out.println(e1);
		}
	}
	
	public List<Artigo> read(){
		List<Artigo> Lista = new ArrayList<Artigo>();
		try {
			ArtigoController controller = new ArtigoController();
			Lista = controller.read();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		return Lista;
	}

	public void delete(Artigo artigo, JLabel resultado) {
		try {
			ArtigoController controller = new ArtigoController();
			controller.delete(artigo);
			resultado.setText("Deletado com Sucesso !");
		}
		catch(Exception e) {
			System.out.println(e);
			resultado.setText("Tente Novamente");
		}

		//ArtigoController controller1 = new ArtigoController();
		//controller1.update(artigo);
		
	}
	
	public void update(Artigo artigo , JLabel resultado) {
		try {
			ArtigoController controller = new ArtigoController();
			controller.update(artigo);
			resultado.setText("Artigo Atualizado !");
		}
		catch(Exception e){
			System.out.println(e);
			resultado.setText("Tente novamente");
		}
	}
	
}

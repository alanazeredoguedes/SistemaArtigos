package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Artigo;
import jdbc.ConnectionFactory;

public class ArtigoDAO {

	public void create(Artigo artigo) throws SQLException {
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;
		
		String sql = "insert into artigo(dt_publicacao, titulo, texto, autor_cpf) values(?,?,?,?)";
		
		stmt = banco.prepareStatement(sql);
		stmt.setString(1, artigo.getDt_publicacao());
		stmt.setString(2, artigo.getTitulo());
		stmt.setString(3, artigo.getTexto());
		stmt.setString(4, artigo.getAutor_cpf());
		
		stmt.executeUpdate();
		
		ConnectionFactory.closeConnection(banco, stmt);
	}


	public List<Artigo> read() {
		List<Artigo> lista = new ArrayList<Artigo>();
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null ;
		ResultSet ar = null ;
		
		String sql = "select artigo.*, autor.nome from artigo,autor where autor.cpf = artigo.autor_cpf";
		
		try {
			stmt = banco.prepareStatement(sql);
			ar = stmt.executeQuery();
			
			while(ar.next()) {
				Artigo artigo = new Artigo();
				artigo.setCodigo(ar.getString("codigo"));
				artigo.setDt_publicacao(ar.getString("dt_publicacao"));
				artigo.setTitulo(ar.getString("titulo"));
				artigo.setTexto(ar.getString("texto"));
				artigo.setAutor_cpf(ar.getString("autor_cpf"));
				artigo.setNome(ar.getString("nome"));
				
				lista.add(artigo);
			}
		}
		catch (SQLException e) {
			System.out.println("Erro ao tentar ler Aluno...");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
		return lista;
	}


	public void delete(Artigo artigo) throws SQLException {
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;
		String sql = "delete from artigo where codigo = (?)";
		stmt = banco.prepareStatement(sql);
		stmt.setString(1, artigo.getCodigo());
		stmt.executeUpdate();
		ConnectionFactory.closeConnection(banco, stmt);
		
	}


	public void update(Artigo artigo) throws SQLException {
		Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null ;
		
		String sql = "update artigo set dt_publicacao = (?), titulo = (?) , texto = (?) where codigo = (?)";
		stmt = banco.prepareStatement(sql);
		stmt.setString(1, artigo.getDt_publicacao());
		stmt.setString(2, artigo.getTitulo());
		stmt.setString(3, artigo.getTexto());
		stmt.setString(4, artigo.getCodigo());
		
		stmt.executeUpdate();
		ConnectionFactory.closeConnection(banco, stmt);
		
	}


	}
	


package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bo.Autor;
import jdbc.ConnectionFactory;

public class AutorDAO {
	
	public Autor login(Autor autor) {
		
		Connection banco = ConnectionFactory.getConnection();
		
		PreparedStatement stmt = null ;
		ResultSet rs = null ;
		String sql = "select cpf,senha from autor where cpf = (?)";
		Autor autor1 = new Autor();
		try {
			stmt = banco.prepareStatement(sql);
			stmt.setString(1, autor.getCpf());
			rs = stmt.executeQuery();
			
			while(rs.next()) {

				autor1.setCpf(rs.getString("cpf"));
				autor1.setSenha(rs.getString("senha"));
			}
		}
		catch (SQLException e) {
			
			System.out.println("Erro ao tentar Acessar Autor...");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
		return autor1;
	}
	
		public void create(Autor autor) throws SQLException {
				Connection banco = ConnectionFactory.getConnection();
				PreparedStatement stmt = null;
				String sql = "insert into autor(cpf,nome,email,senha) values (?,?,?,?)";
				stmt = banco.prepareStatement(sql);
				
				stmt.setString(1,autor.getCpf());
				stmt.setString(2, autor.getNome());
				stmt.setString(3, autor.getEmail());
				stmt.setString(4, autor.getSenha());
				
				stmt.executeUpdate();
				
				System.out.println("Autor Criado !");

				ConnectionFactory.closeConnection(banco,stmt);
			}
			
		public void delete(Autor autor) throws SQLException {
			Connection banco = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			String sql = "delete from autor where cpf = (?)";
			stmt = banco.prepareStatement(sql);
			
			stmt.setString(1,autor.getCpf());
	
			
			stmt.executeUpdate();
			
			System.out.println("Conta Deletada !");
			ConnectionFactory.closeConnection(banco,stmt);
			System.exit(0);
		}
		
		public void update(Autor autor) throws SQLException {
				Connection banco = ConnectionFactory.getConnection();
				PreparedStatement stmt = null ; 
				String sql = "update autor set nome = (?) , email = (?) , senha = (?) where cpf = (?)" ; 
				stmt = banco.prepareStatement(sql);
				stmt.setString(1, autor.getNome());
				stmt.setString(2, autor.getEmail());
				stmt.setString(3, autor.getSenha());
				stmt.setString(4, autor.getCpf());
				
				stmt.executeUpdate();
				
				System.out.println("CPF : " + autor.getCpf() + " Atualizado");
				
				ConnectionFactory.closeConnection(banco, stmt);
		}
		
		}



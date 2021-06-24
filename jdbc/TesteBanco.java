package jdbc;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteBanco {

	public static void main(String[] args) {
		
		try {
			
			Connection banco = ConnectionFactory.getConnection();
			System.out.println("Conexao Funcionou");
			
			createNewTable(banco);
			readTableTest(banco);
		}
		catch(Exception e)
		{
			System.out.println("Erro ao se Conectar!");
			System.out.println(e);
		}

	}
	
	public static void createNewTable(Connection banco) {
		
		String sql1 = "CREATE TABLE IF NOT EXISTS autor (\n"
				+ "cpf varchar(10) NOT NULL , \n"
				+ "nome varchar(50) NOT NULL , \n"
				+ "email varchar(50) NOT NULL, \n"
				+ "senha varchar(50) NOT NULL, \n"
				+ "PRIMARY KEY (cpf) \n"
				+ ");";
		
		String sql2 = "CREATE TABLE IF NOT EXISTS artigo (\n"
				+ "codigo int NOT NULL AUTO_INCREMENT , \n"
				+ "dt_publicacao date NOT NULL , \n"
				+ "titulo varchar(100) NOT NULL, \n"
				+ "texto varchar(255) NOT NULL, \n"
				+ "autor_cpf varchar(10) NOT NULL, \n"
				+ "Primary Key(codigo) , \n"
				+ "Foreign Key(autor_cpf) references autor (cpf) \n"
				+ ");";
			try {
				Statement smt = banco.createStatement();
				smt.execute(sql1);
				smt.execute(sql2);
				System.out.println("Tabelas criada !!");
			}
			catch(Exception e) {
				System.out.println("Erro na Conexao");
				System.out.println(e);
			}
		}
	public static void readTableTest(Connection banco) {
		String sql = "select * from autor;";
		
		PreparedStatement stmt = null;
		ResultSet rs = null ;
		
		try {
			stmt = banco.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			if(rs.next())
				System.out.println("Com registro");
			else
				System.out.println("Sem registro");
		}
		catch (SQLException e) {
			System.out.println("<DAO> Erro lendo banco");
		}
		finally {
			ConnectionFactory.closeConnection(banco,stmt);
		}
	}

}
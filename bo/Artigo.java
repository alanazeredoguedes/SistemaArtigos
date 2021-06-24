package bo;

public class Artigo {

	private String codigo;
	private String dt_publicacao;
	private String titulo;
	private String texto;
	private String autor_cpf;
	private String nome;
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public String getNome() {
		return nome;
	}
	

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public String getDt_publicacao() {
		return dt_publicacao;
	}

	public void setDt_publicacao(String dt_publicacao) {
		this.dt_publicacao = dt_publicacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getAutor_cpf() {
		return autor_cpf;
	}

	public void setAutor_cpf(String autor_cpf) {
		this.autor_cpf = autor_cpf;
	}
	
	
}

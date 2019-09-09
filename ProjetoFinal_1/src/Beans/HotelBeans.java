package Beans;

public class HotelBeans {

	private String nome;
	private String descricao;
	private String nascimento;

	public HotelBeans() {
	}

	public HotelBeans(String nome, String descricao, String nascimento) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.nascimento = nascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	
}
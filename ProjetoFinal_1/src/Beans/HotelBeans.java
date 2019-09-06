package Beans;

public class HotelBeans {

	private String nome;
	private String descricao;
	private String nascimento;
	private String dataComeco;
	private String dataFinal;
	private String cuidador;

	public HotelBeans() {
	}

	public HotelBeans(String nome, String descricao, String nascimento, String cuidador, String dataComeco, String dataFinal) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.nascimento = nascimento;
		this.cuidador = cuidador;
		this.dataComeco = dataComeco;
		this.dataFinal = dataFinal;
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
	public String getDataComeco(){
		return dataComeco;
	}
	public void setDataComeco(String dataComeco){
		this.dataComeco = dataComeco;
	}
	public String getDataFinal(){
		return dataFinal;
	}
	public void setDataFinal(String dataFinal){
		this.dataFinal = dataFinal;
	}
	public String getCuidador(){
		return cuidador;
	}
	public void setCuidador(String cuidador){
		this.cuidador = cuidador;
	}
}

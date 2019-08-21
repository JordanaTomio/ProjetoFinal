package Beans;

public class Produto {

	private String nome;
	private String descricao;
	private double valor;
	private String unidade;
	private String validade;
	private int quantidadeEstoque;

	public Produto() {
	}

	public Produto(String nome, String descricao, double valor, String unidade, String validade,
			int quantidadeEstoque) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
		this.unidade = unidade;
		this.validade = validade;
		this.quantidadeEstoque = quantidadeEstoque;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}
}

package Beans;

public class Cliente {

	private int cdCodigo;
	private String email;
	private String senha;
	private String primeiroNome;
	private String ultimoNome;
	private String sexo;
	private String telefone;
	private String cpf_cnpj;
	private int adm;
	private String cep;
	private String pessoa;
	private String razao;
	
	public Cliente() {
	}

	public Cliente(String email, String senha, String primeiroNome, String ultimoNome, String sexo, String telefone,
			int adm, String cpf_cnpj, String cep, String pessoa, String razao) {
		super();
		this.email = email;
		this.senha = senha;
		this.primeiroNome = primeiroNome;
		this.ultimoNome = ultimoNome;
		this.sexo = sexo;
		this.telefone = telefone;
		this.adm = adm;
		this.cpf_cnpj = cpf_cnpj;
		this.cep = cep;
		this.pessoa = pessoa;
		this.razao = razao;
	}

	public int getCdCodigo() {
		return cdCodigo;
	}

	public void setCdCodigo(int cdCodigo) {
		this.cdCodigo = cdCodigo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getAdm() {
		return adm;
	}

	public void setAdm(int adm) {
		this.adm = adm;
	}
	public void setCPF(String cpf_cnpj){
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getCPF() {
		return cpf_cnpj;
	}
	public void setCEP(String cep){
		this.cep = cep;
	}
	public String getCEP() {
		return cep;
	}
	public void setPessoa(String pessoa){
		this.pessoa = pessoa;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setRazao(String razao){
		this.razao = razao;
	}
	public String getRazao() {
		return razao;
	}
}

package Beans;

public class Animal {
	int idAnimal;
	

	String nomeAnimal;
	String anoAnimal;
	String porteAnimal;
	String descAnimal;
	String racaAnimal;
	String tipoAnimal;
	String sexoAnimal;
	String vacinasAnimal;
	String castradoAnimal;
	
	public Animal() {
	}

	public Animal(String nome, String ano, String porte, String desc, String sexo, String raca,
			int id, String tipo, String vacina, String castrado) {
		super();
		this.nomeAnimal = nome;
		this.anoAnimal = ano;
		this.porteAnimal = porte;
		this.descAnimal = desc;
		this.sexoAnimal = sexo;
		this.vacinasAnimal = vacina;
		this.idAnimal = id;
		this.castradoAnimal = castrado;
		this.tipoAnimal = tipo;
		this.racaAnimal = raca;
	}
	public int getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}

	public String getAnoAnimal() {
		return anoAnimal;
	}

	public void setAnoAnimal(String anoAnimal) {
		this.anoAnimal = anoAnimal;
	}

	public String getPorteAnimal() {
		return porteAnimal;
	}

	public void setPorteAnimal(String porteAnimal) {
		this.porteAnimal = porteAnimal;
	}

	public String getDescAnimal() {
		return descAnimal;
	}

	public void setDescAnimal(String descAnimal) {
		this.descAnimal = descAnimal;
	}

	public String getRacaAnimal() {
		return racaAnimal;
	}

	public void setRacaAnimal(String racaAnimal) {
		this.racaAnimal = racaAnimal;
	}

	public String getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(String tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}

	public String getSexoAnimal() {
		return sexoAnimal;
	}

	public void setSexoAnimal(String sexoAnimal) {
		this.sexoAnimal = sexoAnimal;
	}

	public String getVacinasAnimal() {
		return vacinasAnimal;
	}

	public void setVacinasAnimal(String vacinasAnimal) {
		this.vacinasAnimal = vacinasAnimal;
	}

	public String getCastradoAnimal() {
		return castradoAnimal;
	}

	public void setCastradoAnimal(String castradoAnimal) {
		this.castradoAnimal = castradoAnimal;
	}
}

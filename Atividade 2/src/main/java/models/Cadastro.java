package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Cadastro {
	private String nome;
	private String idioma;
	private String[] habilidades;
	private LocalDate dataNascimento;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		if (nome == null || nome.equals("") || nome.startsWith(" ") || nome.matches("[0-9]")) {
			throw new IllegalArgumentException("O nome escrito não está adequado!");
		}
		
			this.nome = nome;
	}
	
	public String getIdioma() {
		return idioma;
	}
	
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	public String[] getHabilidades() {
		return habilidades;
	}
	
	public void setHabilidades(String[] habilidades) {
		if (habilidades == null || habilidades.length == 0) {
			throw new IllegalArgumentException("Habilidades não informados!");
		}
		
		this.habilidades = habilidades;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String data) {
		LocalDate dataNascimento = null;
		
		try {
			dataNascimento = this.dateStringToLocalDate(data);
		
		} catch (Exception e1) {
			throw new IllegalArgumentException("Data não informada ou formato incorreto!");
		}
		
		if(dataNascimento == null || dataNascimento.equals(LocalDate.now()) || dataNascimento.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("Data invalida!");
		}
		
		this.dataNascimento = dataNascimento;
	}
	
	public LocalDate dateStringToLocalDate(String data) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		LocalDate localDate = LocalDate.parse(data);
		
		return localDate;
	}
}

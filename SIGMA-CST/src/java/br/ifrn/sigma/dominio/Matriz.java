package br.ifrn.sigma.dominio;

import java.util.List;

public class Matriz {

	private int id;
	private String descricao;
	private boolean ativa;
	private Curso curso;
	private List<Diretoria> diretorias;
	private List<ComponenteCurricular> componentesCurriculares;

	public Matriz() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Diretoria> getDiretorias() {
		return diretorias;
	}

	public void setDiretorias(List<Diretoria> diretorias) {
		this.diretorias = diretorias;
	}

	public List<ComponenteCurricular> getComponentesCurriculares() {
		return componentesCurriculares;
	}

	public void setComponentesCurriculares(List<ComponenteCurricular> componentesCurriculares) {
		this.componentesCurriculares = componentesCurriculares;
	}
}

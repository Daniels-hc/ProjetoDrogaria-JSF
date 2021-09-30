package br.com.drogaria.domain;

import javax.persistence.*;

@Entity
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(nullable = false)
	private String descricao;
	
	public Fabricante() {
		
	}
	
	public Fabricante(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Long getCodigo() {
		return this.codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Fabricante [codigo=" + codigo + ", descricao=" + descricao + "]";
	}	
		
}

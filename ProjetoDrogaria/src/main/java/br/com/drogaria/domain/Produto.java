package br.com.drogaria.domain;

import javax.persistence.*;

@Entity
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Long quantidade;
	
	@Column(nullable = false)
	private Double preco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Fabricante fabricante = new Fabricante();
	
	
	public Produto() {
		
	}
	
	public Produto(String descricao, Long quantidade, Double preco, Fabricante fabricante) {
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.preco = preco;
		this.fabricante = fabricante;
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
	
	public Long getQuantidade() {
		return this.quantidade;
	}
	
	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double getPreco() {
		return this.preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	public Fabricante getFabricante() {
		return this.fabricante;
	}
	
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao 
				+ ", quantidade=" + quantidade + ", preco="
				+ preco + ", fabricante=" + fabricante + "]";
	}
	
}

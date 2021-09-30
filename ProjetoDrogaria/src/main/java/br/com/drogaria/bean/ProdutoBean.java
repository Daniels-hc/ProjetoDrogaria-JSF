package br.com.drogaria.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DAOException;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {
	private List<Produto> itens;
	private List<Produto> itensFiltrados;
	
	private Produto produto;
	private List<Fabricante> comboFabricantes;

	public List<Produto> getItens() {
		return itens;
	}

	public void setItens(List<Produto> itens) {
		this.itens = itens;
	}
	
	public List<Produto> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(List<Produto> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Fabricante> getComboFabricantes() {
		return comboFabricantes;
	}
	
	public void setComboFabricantes(List<Fabricante> comboFabricantes) {
		this.comboFabricantes = comboFabricantes;
	}
	
	public void carregarListagem() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			itens = dao.listar();
		} catch(Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararNovo() {
		try {
			produto = new Produto();
			
			FabricanteDAO dao = new FabricanteDAO();
			
			comboFabricantes = dao.listar();
		} catch(Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void novo() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.salvar(produto);
		
			itens = dao.listar();
		
			JSFUtil.adicionarMensagemSucesso("Produto salvo com sucesso.");
		} catch(DAOException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void excluir() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto.getCodigo());
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto removido com sucesso.");
		} catch(DAOException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void prepararEditar() throws DAOException {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			comboFabricantes = dao.listar();
			
		} catch(Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
	
	public void editar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();
			dao.editar(produto);
			
			itens = dao.listar();
			
			JSFUtil.adicionarMensagemSucesso("Produto editado com sucesso.");
		} catch(Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
}

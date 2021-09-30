package br.com.drogaria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.exception.DAOException;
import br.com.drogaria.util.JSFUtil;

@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {
	private Fabricante fabricante;
	private List<Fabricante> itens;
	private List<Fabricante> itensFiltrados;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getItens() {
		return itens;
	}
	
	public void setItens(List<Fabricante> itens) {
		this.itens = itens;
	}
	
	public List<Fabricante> getItensFiltrados() {
		return itensFiltrados;
	}
	
	public void setItensFiltrados(List<Fabricante> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	@PostConstruct
	public void prepararPesquisa() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			itens = dao.listar();
		} catch (Exception ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void prepararNovo() {
		fabricante = new Fabricante();
	}

	public void novo() {
		try {
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fabricante salvo com sucesso.");
		} catch (DAOException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}


	public void excluir() {
		FabricanteDAO dao = new FabricanteDAO();
		try {
			dao.excluir(fabricante.getCodigo());
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fabricante removido com sucesso.");
		} catch (DAOException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}

	public void editar() {
		FabricanteDAO dao = new FabricanteDAO();
		try {
			dao.atualizar(fabricante);
			itens = dao.listar();

			JSFUtil.adicionarMensagemSucesso("Fabricante editado com sucesso.");
		} catch (DAOException ex) {
			ex.printStackTrace();
			JSFUtil.adicionarMensagemErro(ex.getMessage());
		}
	}
}

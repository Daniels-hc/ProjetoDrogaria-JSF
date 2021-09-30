package br.com.drogaria.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DAOException;

public class ProdutoDAOTeste {
	
	@Test
	@Ignore
	public void salvar() throws DAOException {
		Produto p = new Produto();
		p.setDescricao("Novalgina com 10 comprimidos");
		p.setPreco(2.45);
		p.setQuantidade(13L);
		
		Fabricante f = new Fabricante();
		f.setCodigo(12L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.salvar(p);
	}
	
	@Test
	@Ignore
	public void listar() throws DAOException {
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> lista = dao.listar();
		
		for(Produto p : lista) {
			System.out.println("Código do Produto: " + p.getCodigo());
			System.out.println("Descrição do Produto: " + p.getDescricao());
			System.out.println("Preço: " + p.getPreco());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.println("Código do Fabricante: " + p.getFabricante().getCodigo());
			System.out.println("Descrição do Fabricante: " + p.getFabricante().getDescricao());
			System.out.println();
		}
	}
	
	@Test
	@Ignore
	public void excluir() throws DAOException {
		Produto p = new Produto();
		p.setCodigo(1L);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.excluir(p.getCodigo());
	}
	
	@Test
	public void editar() throws DAOException {
		Produto p = new Produto();
		
		p.setCodigo(2L);
		p.setDescricao("Cataflan Pomada com 60 Gramas");
		p.setPreco(15.30D);
		p.setQuantidade(7L);
		
		Fabricante f = new Fabricante();
		f.setCodigo(10L);
		
		p.setFabricante(f);
		
		ProdutoDAO dao = new ProdutoDAO();
		dao.editar(p);
	}

}

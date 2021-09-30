package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DAOException;
import br.com.drogaria.factory.ConnectionFactory;

public class ProdutoDAO {
	public void salvar(Produto p) throws DAOException {
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
			em.getTransaction().begin();
		        
		    em.persist(p);
		        
		    em.getTransaction().commit();
			
		    System.out.println("Salvo com sucesso");
		} catch(Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			System.out.println("Não foi possivel cadastrar");
			throw new DAOException("Erro ao cadastrar");
		} finally {
			em.close();
		}		
		
	}
	
	public List<Produto> listar(){
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
		String queryList = "SELECT p FROM Produto p INNER JOIN FETCH p.fabricante f";
		List<Produto> produtoList = em
				.createQuery(queryList, Produto.class)
				.getResultList();   
		
		return produtoList;
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao listar");
		} finally {
			em.close();
		}
		
		return null;
	}
	
	public void excluir(Long id) throws DAOException{
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em.remove(em.find(Produto.class, id));
			
			em.getTransaction().commit();
			System.out.println("Excluido com sucesso");
		} catch(Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			System.out.println("Não foi possivel excluir.");
			throw new DAOException("Erro ao remover.");
		} finally {
			em.close();
		}
	}
	
	public void editar(Produto p) throws DAOException {
		EntityManager em = ConnectionFactory.getEntityManager();
		try {
			em.getTransaction().begin();
			
			em.merge(p);
			
			em.getTransaction().commit();
			System.out.println("Atualizado com sucesso.");
		} catch(Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			System.out.println("Não foi possivel atualizar.");
			throw new DAOException("Erro ao atualizar");
		} finally {
			em.close();
		}
	}
	
	
}

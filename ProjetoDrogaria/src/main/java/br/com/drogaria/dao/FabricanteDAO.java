package br.com.drogaria.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.exception.DAOException;
import br.com.drogaria.factory.ConnectionFactory;

public class FabricanteDAO {
	
	public void salvar(Fabricante f) throws DAOException {
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
			em.getTransaction().begin();
		        
		    em.persist(f);
		        
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
	
	public void excluir(Long id) throws DAOException {
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em.remove(em.find(Fabricante.class, id));
			
			em.getTransaction().commit();
			System.out.println("Excluido com sucesso");
		} catch(Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			System.out.println("Não foi possivel excluir");
			throw new DAOException("Erro ao Remover");
		} finally {
			em.close();
		}
	}
	
	public void atualizar(Fabricante f) throws DAOException {
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
			em.getTransaction().begin();
			
			em.merge(f);
			
			em.getTransaction().commit();
			System.out.println("Atualizado com sucesso.");
		} catch(Exception ex) {
			em.getTransaction().rollback();
			ex.printStackTrace();
			System.out.println("Não foi possivel atualizar");
			throw new DAOException("Erro ao Atualizar");
		} finally {
			em.close();
		}
	}
	
	public Fabricante buscarPorID(Long id) {
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
		Fabricante f = em.find(Fabricante.class, id);
		return f;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro na pesquisa");
		} finally {
			em.close();
		}
		
		return null;
	}
	
	public List<Fabricante> listar(){
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
		String queryList = "SELECT f FROM Fabricante f ORDER BY descricao ASC";
		List<Fabricante> fabricanteList = em
				.createQuery(queryList, Fabricante.class)
				.getResultList();   
		
		return fabricanteList;
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro ao listar");
		} finally {
			em.close();
		}
		
		return null;
	}
	
	public List<Fabricante> buscarPorDesc(String desc){
		EntityManager em = ConnectionFactory.getEntityManager();
		
		try {
		String queryList = "SELECT f FROM Fabricante f WHERE f.descricao LIKE :descricao";
		List<Fabricante> fabricanteList = em
				.createQuery(queryList, Fabricante.class)
				.setParameter("descricao", "%" + desc + "%")
				.getResultList();
		
		return fabricanteList;
		
		} catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Erro na pesquisa");
		} finally {
			em.close();
		}
		return null;
	}

	
//	public static void main(String[] args) {
//		
//		  Fabricante f1 = new Fabricante(); 
//		  f1.setDescricao("Descricao 1"); 
//		  Fabricante f2 = new Fabricante(); 
//		  f2.setDescricao("Descricao 2");
//		  
//		  FabricanteDAO fdao = new FabricanteDAO();
//		  
//		  Produto p1 = new Produto("Pfaizer", 100L, 15.00, f1);
//		  
//		  fdao.salvar(f1); 
//		  fdao.salvar(f2);
		 
			/*
			 * Fabricante f3 = new Fabricante(); f3.setCodigo(1L);
			 * 
			 * Fabricante f4 = new Fabricante(); f4.setCodigo(2L);
			 * 
			 * FabricanteDAO fdao2 = new FabricanteDAO();
			 */
		
//		fdao.excluir(11L);
//		fdao.excluir(f2);
		  
//		  List<Fabricante> lt = fdao.listar();
//		  for(Fabricante f : lt) {
//			  System.out.println("Resultado: " + f);
//		  }
//		  
//		  Fabricante f3 = new Fabricante();
//		  f3.setDescricao("2");
//		  List<Fabricante> list = fdao.buscarPorDesc("2");
//		  
//		  for(Fabricante f : list) {
//			  System.out.println("Resultado: " + f);
//		  }
//	}

}

package br.com.drogaria.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ConexaoFactory {
	public static void main(String[] args) {

        // OBS: Esse codigo deve executar SEM ERROS com a implementacao JPA que foi definida no "persistence.xml".
        // Se estiver somente com o JPA baixado, o codigo NAO IRA funcionar.

        // O ideal é que nessa parte (Parte 2) o codigo EXECUTE SEM ERROS, pois aqui tera uma implementacao JPA sendo utilizada.

        // 1 - Passos iniciais para criar um gerenciadop de entidades com o banco de dados especificado no arquivo  "persistence.xml"
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("postgre-porjetoDrogaria");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
		
		 Fabricante fabricanteParaAdicionar = new Fabricante("Pfaizer"); 
		 Produto produtoParaAdicionar = new Produto("Vacina", 15l, 10.00, fabricanteParaAdicionar); 
//		 Produto produtoParaAdicionar2 = new Produto();
		 

        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
		
		  entityManager.getTransaction().begin();
		  
		  entityManager.persist(fabricanteParaAdicionar);
		  entityManager.persist(produtoParaAdicionar);
//		  entityManager.persist(produtoParaAdicionar2);s
		  
		  
		  entityManager.getTransaction().commit();
		 

        // 3 - Resgatar instâncias no banco de dados
		/*
		 * Estado estadoEncontrado = entityManager.find(Estado.class, 1); Aluno
		 * alunoEncontrado = entityManager.find(Aluno.class, 1);
		 * 
		 * System.out.println(estadoEncontrado); System.out.println("Antes de mudar " +
		 * alunoEncontrado);
		 */

        // 4 - Alterar uma entidade
		/*
		 * entityManager.getTransaction().begin();
		 * 
		 * alunoEncontrado.setNome("Karam"); alunoEncontrado.setIdade(20);
		 */

		/*
		 * entityManager.getTransaction().commit();
		 * 
		 * System.out.println("Depois de mudar " + alunoEncontrado);
		 */

        // 5 - Remover uma entidade
		/*
		 * entityManager.getTransaction().begin();
		 * 
		 * entityManager.remove(alunoEncontrado);
		 * 
		 * entityManager.getTransaction().commit();
		 */

        // 6 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();

    }

}

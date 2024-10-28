import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class EmailDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EmailDAO() {
      
        emf = Persistence.createEntityManagerFactory("emailPU");
      
        em = emf.createEntityManager();
    }

    public void salvar(Email email) {
        EntityTransaction tx = em.getTransaction();
        try {
     
            tx.begin();
       
            em.persist(email);
           
            tx.commit();
        } catch (Exception e) {
         
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void excluir(Email email) {
        EntityTransaction tx = em.getTransaction();
        try {
         
            tx.begin();
     
            em.remove(email);
         
            tx.commit();
        } catch (Exception e) {
          
            if (tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Email> listar() {
       
        Query query = em.createQuery("SELECT e FROM Email e");
       
        @SuppressWarnings("unchecked")
		List<Email> emails = query.getResultList();
        return emails;
    }

    public int contar() {
     
        Query query = em.createQuery("SELECT COUNT(e) FROM Email e");
        
        int count = ((Number) query.getSingleResult()).intValue();
        return count;
    }

    public void fecharConexao() {
       
        if (em != null && em.isOpen()) {
            em.close();
        }
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

	 public void atualizar(Email email) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmailPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.merge(email); // 
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;
        } finally {
            em.close();
            emf.close();
        }
    }

	  public static void remover(Email email) {
	        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmailPU");
	        EntityManager em = emf.createEntityManager();

	        try {
	            em.getTransaction().begin();
	            Email emailExcluir = em.find(Email.class, email.getId()); 
	            em.remove(emailExcluir); 
	            em.getTransaction().commit();
	        } catch (Exception ex) {
	            em.getTransaction().rollback();
	            throw ex;
	        } finally {
	            em.close();
	            emf.close();
	        }
	    }
	}

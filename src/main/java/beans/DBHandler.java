package beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

//@Stateless
public class DBHandler {
/*    @PersistenceContext
    protected EntityManager em;*/

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    @Transactional
    public Shot create(Shot shot) {
/*        Shot newShot = new Shot(shot);
        em.persist(newShot);
        return newShot;*/


/*        em.getTransaction().begin();
        em.persist(shot);
        em.getTransaction().commit();*/

        //  работает
        em.getTransaction().begin();
        em.persist(shot);
        em.getTransaction().commit();
        return shot;
    }
}

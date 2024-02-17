package beans;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

public class DBHandler {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    @Transactional
    public Shot create(Shot shot) {
        em.getTransaction().begin();
        em.persist(shot);
        em.getTransaction().commit();
        return shot;
    }

    @Transactional
    public void resetTable() {
        em.getTransaction().begin();
        Query query = em.createQuery(
                "DELETE FROM Shot"
        );
        System.out.println("Удалено строк: " + query.executeUpdate());
        em.getTransaction().commit();
    }
}

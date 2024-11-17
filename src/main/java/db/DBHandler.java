package db;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import entity.Shot;

public class DBHandler {

    public DBHandler() {
        System.out.println("DBHandler initialized");
    }

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private final EntityManager em = emf.createEntityManager();

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
        System.out.println("Deleted " + query.executeUpdate() + " rows");
        em.getTransaction().commit();
    }
}

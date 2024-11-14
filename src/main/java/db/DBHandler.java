package db;

import jakarta.faces.bean.ManagedBean;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import entity.Shot;

@ManagedBean(eager = true)
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
        System.out.println("Удалено строк: " + query.executeUpdate());
        em.getTransaction().commit();
    }
}

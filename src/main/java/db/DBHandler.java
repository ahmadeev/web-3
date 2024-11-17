package db;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import entity.Shot;

@Stateless
public class DBHandler {
    @PersistenceContext
    protected EntityManager em;

    public void create(Shot shot) {
        em.persist(shot);
    }

    public void clear() {
        Query query = em.createQuery(
                "DELETE FROM Shot"
        );
        System.out.println("Deleted " + query.executeUpdate() + " rows");
    }
}

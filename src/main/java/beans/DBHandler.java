package beans;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class DBHandler {
    @PersistenceContext
    protected EntityManager em;

    public Shot create(Shot shot) {
        Shot newShot = new Shot(shot);
        em.persist(newShot);
        return newShot;
    }
}

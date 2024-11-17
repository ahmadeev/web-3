public class Notes {
    /*

    КОНФИГУРАЦИЯ МБИНОВ C ПОМОЩЬЮ АННОТАЦИЙ

    @ManagedBean(name = "pageError", eager = true)

    //  dbHandler
    @ManagedBean(eager = true)
    @ApplicationScoped

    //  shotResults
    @ManagedBean(name = "shotResults", eager = true)
    @ApplicationScoped

    @Inject
    private DBHandler dbHandler;

    //  shotController
    @ManagedBean(name="shotController")
    @RequestScoped

    //  инъекция с помощью средств jsf, чтобы избежать повторных инициализаций (возможно баг)
    @Getter @Setter
    @ManagedProperty(value = "#{dbHandler}")
    private DBHandler dbHandler;

    @Getter @Setter
    @ManagedProperty(value = "#{shotResults}")
    private ShotResults shotResults;

     */

    /*

    КОНФИГУРАЦИЯ БД С ПОМОЩЬЮ ECLIPSELINK

    //  pom.xml
    <dependency>
      <groupId>org.eclipse.persistence</groupId>
      <artifactId>org.eclipse.persistence.jpa</artifactId>
      <version>3.0.2</version>
    </dependency>

    //  persistence.xml
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?>
    <persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">
    <persistence-unit name="default">
        <provider>org.eclipse.persistence.jpa.PersistenceProvider</provider>
        <jta-data-source>java:/PostgresDS</jta-data-source>
        <!-- Add the following to work around exception issue -->
        <class>entity.Shot</class>
        <exclude-unlisted-classes>false</exclude-unlisted-classes>
        <properties>
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="jakarta.persistence.jdbc.user" value="s367839"/>
            <property name="jakarta.persistence.jdbc.password" value="6t7nOCeWvCLDBTZ2"/>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/studs"/>
            <property name="eclipselink.ddl-generation" value="drop-and-create-tables"/>
        </properties>
    </persistence-unit>
    </persistence>

    //  DBHandler.java
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

     */
}


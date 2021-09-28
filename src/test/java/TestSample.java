import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.*;

public class TestSample {
    private static SessionFactory sessionFactory;
    private static Session session;


    @BeforeAll
    public static void setup() {
        sessionFactory = HibernateUtil.buildSessionFactory();
        System.out.println("Session factory is created.");
    }

    @BeforeEach
    public void openSession() {
        session.beginTransaction();
    }

    @AfterEach
    public void closeSession() {
        session.getTransaction().rollback();
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("Session factory is closed.");
    }


    @Test
    public void testInsert() {

    }
    @Test
    public void testUpdate() {



    }
    @Test
    public void testFindAll() {

    }
    @Test
    public void testFindById() {

    }
    @Test
    public void testDelete() {

    }

}

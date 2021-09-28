package edu.fa.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Objects;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory buildSessionFactory() {
        if (Objects.isNull(sessionFactory)) {
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            sessionFactory = cfg.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session getCurrentSession() {
        if (Objects.isNull(sessionFactory)) {
            // 1. Khởi tạo biến Configuration
            Configuration cfg = new Configuration();
            // 2. Load config từ file xml đưa vào biến
            cfg.configure("hibernate.cfg.xml");
            // 3. Tạo SessionFactory từ config đã lấy được
            sessionFactory = cfg.buildSessionFactory();
        }
        return sessionFactory.getCurrentSession();
    }



}

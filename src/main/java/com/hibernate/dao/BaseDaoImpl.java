package com.hibernate.dao;

import com.hibernate.util.HibernateUtil;
import javassist.NotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T> {
    public final Class<T> type;
    private Session session;

    public BaseDaoImpl(Class<T> type) {
        this.type = type;
    }


    @Override
    public void save(T t) {
        session = HibernateUtil.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(t);
            session.flush();
            transaction.commit();
        } catch(Exception e){
            System.out.println("****Could not save " + type.getName());
            System.out.println(e);
            transaction.rollback();
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public void update(T t) {
        session = HibernateUtil.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(t);
            session.flush();
            transaction.commit();
        } catch(Exception e){
            System.out.println("****Could not update!");
            System.out.println(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public T findById(Object id) {
        session = HibernateUtil.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            T object = null;
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = criteriaBuilder.createQuery(this.type);
            Root<T> root = query.from(this.type);
            Predicate condition  = criteriaBuilder.equal(root.get("id"),id);
            query.select(root).where(condition);
            List<T> list = session.createQuery(query).getResultList();
            if(list.size()>0){
                object = list.get(0);
            }else{
                throw new NotFoundException("Entity is not found");
            }
            return object;
        }catch(Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
            return null;
        }finally {
            if(session!=null){
                session.close();
            }
        }
    }

    @Override
    public List<T> findAll() {
        session = HibernateUtil.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<T> query = criteriaBuilder.createQuery(this.type);
            Root<T> root = query.from(this.type);
            query.select(root);
            return session.createQuery(query).getResultList();
        }catch(Exception e){
            e.printStackTrace();
            if(transaction!=null){
                transaction.rollback();
            }
            return null;
        }finally {
            if(session!=null){
                session.close();
            }
        }


    }

    @Override
    public void delete(T t) {
        session = HibernateUtil.buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(t);
            session.flush();
            transaction.commit();
        } catch(Exception e){
            System.out.println("****Could not delete!");
            System.out.println(e);
            if(transaction!=null){
                transaction.rollback();
            }
        }finally {
            if(session!=null){
                session.close();
            }
        }

    }
}

package com.wipro.HibernateMovieApp.repo;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.wipro.HibernateMovieApp.entity.Movie1;
import com.wipro.HibernateMovieApp.util.HibernateUtil;

public class MovieRepo {

    public static void createMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie name:");
        String name = sc.nextLine();
        System.out.println("Enter language:");
        String lang = sc.nextLine();
        System.out.println("Enter IMDb rating:");
        double rating = sc.nextDouble();

        Movie1 m = new Movie1(name, lang, rating);
        save(m);
    }

    public static void updateMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ID to update:");
        int id = sc.nextInt();
        sc.nextLine();
        Movie1 existing = findById(id);
        if (existing == null) {
            System.out.println("Movie not found.");
            return;
        }

        System.out.println("Enter new name:");
        String name = sc.nextLine();
        System.out.println("Enter new language:");
        String lang = sc.nextLine();
        System.out.println("Enter new IMDb rating:");
        double rating = sc.nextDouble();

        existing.setMovieName(name);
        existing.setMovieLanguage(lang);
        existing.setImdbRating(rating);
        save(existing);
    }

    public static void save(Movie1 m) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.saveOrUpdate(m);
        tx.commit();
    }

    public static Movie1 findById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Movie1 m = session.get(Movie1.class, id);
        tx.commit();
        return m;
    }

    public static void deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Movie1 m = session.get(Movie1.class, id);
        if (m != null) session.delete(m);
        tx.commit();
    }

    public static List<Movie1> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Movie1> list = session.createQuery("from Movie1", Movie1.class).list();
        tx.commit();
        return list;
    }

    public static List<String> findAllMovieNames() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<String> list = session.createQuery("select movieName from Movie1", String.class).list();
        tx.commit();
        return list;
    }

    public static List<Movie1> findByMovieLanguages(String lang) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query<Movie1> q = session.createQuery("from Movie1 where movieLanguage = :lang", Movie1.class);
        q.setParameter("lang", lang);
        List<Movie1> list = q.list();
        tx.commit();
        return list;
    }
}

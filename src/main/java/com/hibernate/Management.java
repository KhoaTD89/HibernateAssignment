package com.hibernate;

import com.hibernate.entity.Movie;
import com.hibernate.util.HibernateUtil;

import java.util.Scanner;

public class Management {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HibernateUtil.buildSessionFactory();
        Management management = new Management();
        Movie movie = new Movie();
        management.handleCinemaRoom();


    }
    public void handleCinemaRoom(){

    }
}




















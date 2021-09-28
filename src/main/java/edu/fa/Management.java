package edu.fa;

import edu.fa.util.HibernateUtil;

import java.util.Scanner;

public class Management {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HibernateUtil.buildSessionFactory();
        Management management = new Management();

        management.handleCinemaRoom();


    }
    public void handleCinemaRoom(){

    }
}




















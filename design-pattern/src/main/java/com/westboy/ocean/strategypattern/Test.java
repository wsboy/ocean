package com.westboy.ocean.strategypattern;

public class Test {

    public static void main(String[] args) {
        MovieTicket movieTicket = new MovieTicket();
        movieTicket.setPrice(100);
        movieTicket.setDiscount(new ChildrenDiscount());
        System.out.println(movieTicket.getPrice());
        movieTicket.setDiscount(new StudentDiscount());
        System.out.println(movieTicket.getPrice());
        movieTicket.setDiscount(new VIPDiscount());
        System.out.println(movieTicket.getPrice());
    }
}

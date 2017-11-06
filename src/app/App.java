package app;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Carlos
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Account acc = new Account(2000, 5000);
        Person person1 = new Person(acc, "Person 1");
        Person person2 = new Person(acc, "Person 2");
        Person person3 = new Person(acc, "Person 3");
        Person person4 = new Person(acc, "Person 4");

    }

}

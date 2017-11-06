/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Person extends Thread {

    private AtomicBoolean error = new AtomicBoolean(false);
    private Account acc;

    public Person(Account acc, String name) {
        super(name);
        this.acc = acc;
        this.start();
    }

    public void run() {

        try {

            while (!error.get()) {

                if (!acc.makeDeposit((1 + (float) (Math.random() * 500)))) {
                    error.set(true);
                } else {
                    Thread.sleep(500);
                    if (!acc.makeWithdrawal((1 + (float) (Math.random() * 500)))) {
                        error.set(true);
                    }
                    Thread.sleep(500);
                }

            }
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Thread " + super.getName() + " ended.");
            this.interrupt();

        } catch (InterruptedException ex) {
            Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

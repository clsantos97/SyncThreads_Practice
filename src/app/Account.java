/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Account {
    private float balance;
    private float maxval;
    
    public Account(float balance, float maxval){
        this.balance=balance;
        this.maxval=maxval;
    }

    public synchronized boolean makeDeposit(float value){
        if((balance+value)<=maxval){
            balance+=value;
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Transaction successfull. New balance: " + balance);
            return true;
        }else{
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Transaction rejected. Account max balance reached.");
            return false;
        }
    }
    
    public synchronized boolean makeWithdrawal(float value){
        if((balance-value)>=0){
            balance-=value;
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Transaction successfull. New balance: "+balance);
            return true;
        }else{
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Transaction rejected. Insufficient funds.");
            return false;
        }
    }
    
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getMaxval() {
        return maxval;
    }

    public void setMaxval(float maxval) {
        this.maxval = maxval;
    }
    
    

}

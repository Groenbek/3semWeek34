/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.BankCustomer;

/**
 *
 * @author groen
 */
public class CustomerDTO {

    private Long customerID;
    private String fullName;
    private String accountNumber;

    public Long getCustomerID() {
        return customerID;
    }

    public CustomerDTO() {
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    private double balance;

    public CustomerDTO(BankCustomer bc) {
        customerID = bc.getId();
        fullName = bc.getFirstName() + ", " + bc.getLastName();
        accountNumber = bc.getAccountNumber();
        balance = bc.getBalance();
    }

}

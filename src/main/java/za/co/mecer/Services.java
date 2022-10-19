/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mecer;

import java.sql.Connection;

/**
 *
 * @author TRAIN 11
 */
public interface Services {
    void addBook(Book b);
    void deleteBookr(String b);
    void updateBook(Book b);
    void readBook(String str);
    
    void addClient(Client a);
    void deleteClient(int id);
    void updateClient(Client a);
    void readClient(int a);
    
    void addLoan(Loan a);
    void updateLoan(Loan a);
    void readLoan(int a);
    
    void addPayment(Payment a);
    void updatePayment(Payment a);
    void readAuthor(String str);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mecer;

/**
 *
 * @author TRAIN 11
 */
public class Book implements BookInterface{
    boolean accessible;
    String title;
    int isbNo;

    public Book( int isbNo, String title, boolean accessible) {
        this.accessible = accessible;
        this.title = title;
        this.isbNo = isbNo;
    }

  

    @Override
    public void addBook(Book a) {
       
    }

    @Override
    public void deleteBookr(Book b) {
       
    }

    @Override
    public void updateBook(Book c) {
       
    }

    public boolean isAccessble() {
        return accessible;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public void readBook(String title) {
        
    }

    public int getIsbNo() {
        return isbNo;
    }
    
    
    
}

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
public class Author implements AuthorInterface{
    int authorId;
    String name;
    String country;

    public Author(int authorId, String name, String country) {
        this.authorId = authorId;
        this.name = name;
        this.country = country;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public void addAuthor(Author a) {
       
    }

    @Override
    public void deleteAuthor(Author b) {
        
    }

    @Override
    public void updateAuthor(Author c) {
      
    }

    @Override
    public void readAuthor(Author d) {
      
    }
    
    
    
}

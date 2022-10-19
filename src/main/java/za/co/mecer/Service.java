/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.mecer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TRAIN 11
 */
public class Service implements Services{
    Connection con;

    public Service(Connection con) {
        this.con = con;
    }

    
    
    
    @Override
    public void addBook(Book b) {
        PreparedStatement ps;
        try {
        
            
        ps = con.prepareStatement("INSERT INTO book VALUES(? , ?, ?)");
        ps.setInt(1, b.getIsbNo());
        ps.setString(2, b.getTitle());
        ps.setBoolean(3, b.isAccessble());
      
        ps.executeUpdate();
            System.out.println("Successfully added the Book");
        
        } catch (SQLException ex) {
            System.out.println("Error : "+ex.getMessage());
        }
       
    }

    @Override
    public void deleteBookr(String a) {
       
        try {
           PreparedStatement ps =  con.prepareStatement("DELETE FROM book WHERE firstName =  ?");
           ps.setString(2,a );
           ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateBook(Book b) {
    
       
               
        try {
          con.prepareStatement("UPDATE book SET BookId = b.getBookId() , ISBNo =  b.getIsbNo(),Title = b.getTitle()  WHERE BookId =b.getBookId() ").executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addClient(Client a) {
       PreparedStatement ps;
       
        try {  
           ps  =  con.prepareStatement("INSERT INTO client VALUES( iDNumber = ?,FirstName = ?,lastName=?,ClientAddress=?,telWork=?,telHome=?)");
           ps.setInt(1, a.getiDNumber());
           ps.setString(2, a.getFirstName());
           ps.setString(3,a.getLastName() );
           ps.setString(4, a.getClientAddress());
           ps.setInt(5,a.getTelHome() );
           ps.setInt(6,a.getTelWork());
           ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deleteClient(int id) {
       PreparedStatement ps;
        try {
           ps = con.prepareStatement("DELETE FROM book WHERE iDNumber =?");
           ps.setInt(1, id);
           ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateClient(Client a) {
      PreparedStatement ps;
      
   
        try {  
            ps =con.prepareStatement("UPDATE client SET FirstName = ? , LastName =  ?,ClientAdress = ?,   WHERE iDNumber =  ? ");
            ps.setString(1, a.getFirstName());
            ps.setString(2, a.getLastName());
            ps.setString(3, a.getClientAddress());
            ps.setInt(4, a.getiDNumber());
            ps.executeUpdate();
            System.out.println("Successfully updated");
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void readClient(int b) {
       ResultSet rs = null;
       PreparedStatement ps ;
        try {
            ps = con.prepareStatement("SELECT * FROM client WHERE iDNumber = ? ");
            ps.setInt(1, b);
            ps.executeUpdate();
              while(rs.next())
            {
             int iDNum = rs.getInt("iDNumber");
            String firstName = rs.getString("firstName");
            String lastName = rs.getString("lastName");
            int tel1  = rs.getInt("telWork");
            int tel2 = rs.getInt("telHome");
                System.out.println(iDNum+" "+firstName+" " +lastName+" "+ tel1 +" "+tel2 +" ");
        } 
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addLoan(Loan a) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO loan VALUES(?)");
            ps.setInt(1, a.getLoanId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateLoan(Loan a) {
        
        try {   
            con.prepareStatement("UPDATE loan SET LoanId  ").executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void readLoan(int loanId) {
        ResultSet rs = null;
        PreparedStatement ps;
        try {   
            ps = con.prepareStatement("SELECT * FROM loan WHERE loanID = ? ");
            ps.setInt(1, loanId);
            ps.executeUpdate();
            rs = ps.executeQuery();
            
              while(rs.next())
            {
             int iD = rs.getInt("LoanID");
          
                System.out.println(iD);
        } 
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addPayment(Payment a) {
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("INSERT INTO payment VALUES( ?)");
            ps.setInt(1,a.getPaymentId() );
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    @Override
    public void updatePayment(Payment a) {
        
   //  con.prepareStatement("UPDATE payment SET BookId = b.getBookId() , ISBNo =  b.getIsbNo(),Title = b.getTitle()  WHERE BookId =b.getBookId() ").executeUpdate();  
    }

    @Override
    public void readAuthor(String name) {
     
        ResultSet rs = null;
        PreparedStatement ps;    
                
        try {   
           ps = con.prepareStatement("SELECT * FROM loan WHERE authorID =  ? ");
           ps.setString(2, name);
           ps.executeUpdate();
           rs = ps.executeQuery();
            while (rs.next()) {      
            
            
            
         }
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void readBook(String str) {
        ResultSet rs;// = null;
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("SELECT * FROM book WHERE Title = ? " );
            ps.setString(1, str);
            rs = ps.executeQuery();
            while (rs.next()) { 
                System.out.println("in while\n");
            String title = rs.getString("Title");
            
            
            if(str.equals(title))
            {
                System.out.println(title + " "+rs.getInt("ISBN_No")+" "+rs.getString("Title"));
                System.out.println("Found");
                break;
            }else
            {
                System.out.println("Book not found");
            
            }
            
            
         }
            System.out.println("Okay123");
        } catch (SQLException ex) {
            System.out.println("Error: 4 " + ex.getMessage());
        }
        
        
        
        
    }
    
    
}

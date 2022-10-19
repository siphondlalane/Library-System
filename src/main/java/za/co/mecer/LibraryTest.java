package za.co.mecer;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import za.co.mecer.DB.connector.*;


public class LibraryTest 
{
    
    public static void main(String[] args) 
    {
        Database_con db = new Database_con();
        Connection conn = db.getConn();   
        new LibraryTest().createDataBase(conn);
        new LibraryTest().DisplayMenu(conn);
     
    }
    
    public void createDataBase(Connection conn)
    {
        try
        {
            conn.prepareStatement("CREATE DATABASE library").executeUpdate();
            conn.prepareStatement("USE library").executeUpdate();
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS client(iDNumber INT(13),FirstName VARCHAR(20),lastName VARCHAR(20),clientAddress VARCHAR(20),telWork INT (10),telHome INT (10),telMobile INT (10),PRIMARY KEY(iDNumber))").executeUpdate();
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS book( Title VARCHAR(20) ,BookId INT(20),IsbNo INT(20),PRIMARY KEY(IsbNo))").executeUpdate();
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS loan( LoanId INT(20),ClientId INT(20),PRIMARY KEY(LoanId),FOREIGN KEY(ClientId) REFERENCES client(iDNumber))").executeUpdate();
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS payment( PaymentId INT (20),LoanId INT (20),PRIMARY KEY(PaymentId),FOREIGN KEY (LoanId) REFERENCES loan(LoanId))").executeUpdate();
            conn.prepareStatement("CREATE TABLE IF NOT EXISTS author( AuthorId VARCHAR(20) ,Name VARCHAR(20),Country VARCHAR(20),BookId INT(20),PRIMARY KEY(AuthorId),FOREIGN KEY(BookId) REFERENCES book(BookId))").executeUpdate();
            System.out.println("DataBase Created!!!");
        }
        catch(SQLException ex)
        {
            System.out.println("Error "+ ex.getMessage());
        }
    } 
     private void DisplayMenu(Connection conn)
     {
         Scanner obj = new Scanner(System.in);
         int option = 1;
         System.out.println("Welcome to Mecer inter-ed Library");
         String[] options = {"1-Book Menu",
                            "2- Client Menu",
                            "3- Loan Menu",
                            "4- Author Menu",
                            "5- Exit"};
        
             for(String b:options)
             {
                 System.out.println(b);
             }
             
            while(option!=5)
            {
                System.out.println("Option: ");
                option = obj.nextInt();
                switch (option)
                {
                    case 1: bookMenu(conn);
                        break;
                    case 2: ;
                        break;
                    case 3: ; 
                        break;
                    case 4: System.exit(0);
                        break;
                    default:System.out.println("Wrong Option");
                }
            }
    }
    private void bookMenu(Connection conn)
    {
        int option = 1;
        Scanner ss = new Scanner(System.in);
        System.out.println("1- Get a Book\n"
                            +"2- Update a Book\n"
                            +"3- Delete a Book\n"
                            +"4- Exit");
         
        while(option!=5)
        {
            option = ss.nextInt();
            switch (option)
            {
                case 1: addBookMenu(conn); 
                    break;
                case 2: addABook(conn);
                    break;
                case 3: ;   
                    break;
                case 4: System.exit(0);
                    break;
            }
     
        }
     
     }
     
     private void addBookMenu(Connection conn)
     {
         Scanner obj = new Scanner(System.in);
         Service ss = new Service(conn);
         
         System.out.println("Enter the Title  of the book");
         String nameBook = obj.nextLine();
         ss.readBook(nameBook);
         
        //ss.readClient(a);
     }
     private void addABook(Connection conn)
     {
         Scanner obj = new Scanner(System.in);
         Service ss = new Service(conn);
         System.out.println("Enter the Book Title");
         String title  = obj.nextLine();
         System.out.println("Enter the ISBN Number");
         int isbn  = obj.nextInt();
         System.out.println("Is i accessible");
         boolean ans = obj.nextBoolean();
         Book b = new Book(isbn, title, ans);
         ss.addBook(b);
         System.out.println("Added successfully");
     
     }
    
}

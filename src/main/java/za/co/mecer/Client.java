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
public class Client implements ClientInterface{
 int iDNumber;
 String firstName;
 String lastName;
 String clientAddress;
 int telWork;
 int telHome;
 int telMobile;   

    public Client(int iDNumber, String firstName, String lastName, String clientAddress, int telWork, int telHome, int telMobile) 
    {
        this.iDNumber = iDNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientAddress = clientAddress;
        this.telWork = telWork;
        this.telHome = telHome;
        this.telMobile = telMobile;
    }

    public int getiDNumber() {
        return iDNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public int getTelWork() {
        return telWork;
    }

    public int getTelHome() {
        return telHome;
    }

    @Override
    public void addClient(Client a) {
       
    }

    @Override
    public void deleteClient(Client b) {
        
    }

    @Override
    public void updateClient(Client c) {
        
    }

    @Override
    public void readClient(Client d) {
       
    }
    
    
 

    
    
}

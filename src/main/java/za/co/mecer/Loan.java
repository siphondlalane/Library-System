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
public class Loan implements LoanInterface{
    int loanId;

    public Loan(int loanId) {
        this.loanId = loanId;
    }

    public int getLoanId() {
        return loanId;
    }

   

    @Override
    public void addLoan(Loan a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateLoan(Loan c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readLoan(Loan d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}

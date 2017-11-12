/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package onlineauctionsystemclient;

import ejb.session.stateless.AddressEntityControllerRemote;
import ejb.session.stateless.AuctionListingEntityControllerRemote;
import ejb.session.stateless.CreditPackageEntityControllerRemote;
import ejb.session.stateless.CustomerEntityControllerRemote;
import ejb.session.stateless.StaffEntityControllerRemote;
import entity.CustomerEntity;
import entity.StaffEntity;
import java.util.Scanner;
import util.exception.CustomerNotFoundException;
import util.exception.InvalidLoginCredentialException;
import util.exception.StaffNotFoundException;

/**
 *
 * @author Shuxuan
 */
public class MainApp {

    private CustomerEntityControllerRemote customerEntityControllerRemote;
    private StaffEntity currentStaffEntity;
    private CustomerEntity currentCustomerEntity;
    private StaffEntityControllerRemote staffEntityControllerRemote;
    private AddressEntityControllerRemote addressEntityControllerRemote;
    private CreditPackageEntityControllerRemote creditPackageEntityControllerRemote;
    private AuctionListingEntityControllerRemote auctionListingEntityControllerRemote;
    private CreditTransactionEntityControllerRemote creditTransactionEntityControllerRemote;


    public MainApp() {
    }
    
     
    public MainApp(CustomerEntityControllerRemote customerEntityControllerRemote) {
        this.customerEntityControllerRemote = customerEntityControllerRemote;
    }
    
    public void runApp() throws CustomerNotFoundException{
        Scanner scanner = new Scanner(System.in);
        Integer response = 0;
        
        while(true){
            System.out.println("*** Welcome to Crazy Auctions ***\n");
            System.out.println("1: Staff");
            System.out.println("2: Customer");
            System.out.println("3: Exit\n");
            response = 0;
            
            while ( response < 1 || response > 3 ) {
                System.out.print(">");
                response = scanner.nextInt();
                if ( response == 1 ) {
                    try {
                        doCustomerLogin();
                    } 
                    catch(InvalidLoginCredentialException ex) 
                    {
                    }
                    
                } else if ( response == 2 ) {
                    try {
                        doStaffLogin();
                    } 
                    catch(InvalidLoginCredentialException ex ) 
                    {
                    }
                } else if ( response == 3 ) {
                    break;
                } else {
                    System.out.println("Invalid option, please try again!\n");
                }
            }
            if ( response == 3 ) {
                break;
            }
        }
    }   
    
    private void doStaffLogin() throws InvalidLoginCredentialException {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        
        System.out.println("*** Online Auction System :: Staff Login ***\n");
        System.out.print("Enter username> ");
        username = scanner.nextLine().trim();
        System.out.print("Enter password> ");
        password = scanner.nextLine().trim();
        
        if ( username.length() > 0 && password.length() > 0 ) {
            try {
                currentStaffEntity = staffEntityControllerRemote.staffLogin(username, password);
                System.out.println("Login successful!\n");
            } catch (InvalidLoginCredentialException ex) {
                System.out.println("Invalid login credential: " + ex.getMessage() + "\n");
                
                throw new InvalidLoginCredentialException();
            } catch (StaffNotFoundException staffEx) {
                
            }
        } else {
            System.out.println("Invalid login credential!");
        }

    }
    
    private void doCustomerLogin() throws InvalidLoginCredentialException, CustomerNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String username = "";
        String password = "";
        
        System.out.println("*** Online Auction System :: Customer Login ***\n");
        System.out.print("Enter username> ");
        username = scanner.nextLine().trim();
        System.out.print("Enter password> ");
        password = scanner.nextLine().trim();
    
    if ( username.length() > 0 && password.length() > 0 ) {
            try {
                currentCustomerEntity = customerEntityControllerRemote.customerLogin(username, password);
                System.out.println("Login successful!\n");
            } catch (InvalidLoginCredentialException ex) {
                System.out.println("Invalid login credential: " + ex.getMessage() + "\n");
                
                throw new InvalidLoginCredentialException();
            
            }
        } else {
            System.out.println("Invalid login credential!");
        }
    }
        
}

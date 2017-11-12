/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.CustomerEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.CustomerNotFoundException;
import util.exception.InvalidLoginCredentialException;

@Stateless
@Local(CustomerEntityControllerLocal.class)
@Remote(CustomerEntityControllerRemote.class)
public class CustomerEntityController implements CustomerEntityControllerRemote, CustomerEntityControllerLocal {

    @PersistenceContext(unitName = "OnlineAuctionSystem-ejbPU")
    private EntityManager em;
    
    @Override
    public CustomerEntity createNewCustomerEntity(CustomerEntity customerEntity)
    {
        em.persist(customerEntity);
        em.flush();
        em.refresh(customerEntity);
        
        return customerEntity;
    }
    
    @Override
    public List<CustomerEntity> retrieveAllCustomers()
    {
        Query query = em.createQuery("SELECT c FROM CustomerEntity c");
        
        return query.getResultList();
    }
    
    @Override
    public CustomerEntity retrieveCustomerByCustomerId(Long customerId) throws CustomerNotFoundException
    {
        CustomerEntity customerEntity = em.find(CustomerEntity.class, customerId);
        
        if(customerEntity != null)
        {
            return customerEntity;
        }
        else
        {
            throw new CustomerNotFoundException("Customer ID " + customerId + " does not exist!");
        }
    }
    
    @Override
    public CustomerEntity retrieveCustomerByUsername(String customerUsername) throws CustomerNotFoundException
    {
        CustomerEntity customerEntity = em.find(CustomerEntity.class, customerUsername);
        
        if(customerEntity != null)
        {
            return customerEntity;
        }
        else
        {
            throw new CustomerNotFoundException("Customer Username " + customerUsername + " does not exist!");
        }
    }
    
    @Override
    public CustomerEntity customerLogin(String customerUsername, String customerPassword) throws InvalidLoginCredentialException, CustomerNotFoundException
    {
        try
        {
            CustomerEntity customerEntity = retrieveCustomerByUsername(customerUsername);
            
            if(customerEntity.getCustomerPassword().equals(customerPassword))
            {
                return customerEntity;
            }
            else
            {
                throw new InvalidLoginCredentialException("Username does not exist or invalid password!");
            }
        }
        catch(CustomerNotFoundException ex)
        {
            throw new InvalidLoginCredentialException("Username does not exist or invalid password!");
        }
    }
    
    @Override
    public void updateCustomerEntity(CustomerEntity customerEntity)
    {
        em.merge(customerEntity);
    }
    
    @Override
    public void deleteCustomer(Long customerId) throws CustomerNotFoundException
    {
        try 
        {
        CustomerEntity customerEntityToRemove = retrieveCustomerByCustomerId(customerId);
        em.remove(customerEntityToRemove);
        }
        catch(CustomerNotFoundException ex)
        {
            System.out.print("An error has occured while deleting the customer: " + ex.getMessage());
        }
        
    }
}

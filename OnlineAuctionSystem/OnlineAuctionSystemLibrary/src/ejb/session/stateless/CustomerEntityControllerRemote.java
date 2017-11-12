/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.CustomerEntity;
import java.util.List;
import util.exception.CustomerNotFoundException;
import util.exception.InvalidLoginCredentialException;

public interface CustomerEntityControllerRemote {
      
    public CustomerEntity createNewCustomerEntity(CustomerEntity customerEntity);
    public List<CustomerEntity> retrieveAllCustomers();
    public CustomerEntity retrieveCustomerByCustomerId(Long customerId) throws CustomerNotFoundException;
    public CustomerEntity retrieveCustomerByUsername(String customerUsername) throws CustomerNotFoundException;
    public CustomerEntity customerLogin(String customerUsername, String customerPassword) throws InvalidLoginCredentialException, CustomerNotFoundException;
    public void updateCustomerEntity(CustomerEntity customerEntity);
    public void deleteCustomer(Long customerId) throws CustomerNotFoundException;
}

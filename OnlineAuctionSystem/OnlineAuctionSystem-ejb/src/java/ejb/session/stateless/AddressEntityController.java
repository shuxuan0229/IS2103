/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AddressEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.AddressNotFoundException;

@Stateless
@Local(AddressEntityControllerLocal.class)
@Remote(AddressEntityControllerRemote.class)
public class AddressEntityController implements AddressEntityControllerRemote, AddressEntityControllerLocal {

    @PersistenceContext(unitName = "OnlineAuctionSystem-ejbPU")
    private EntityManager em;

    public AddressEntityController() {
    }

    @Override
    public AddressEntity createNewAddress(AddressEntity newAddressEntity)
    {
        em.persist(newAddressEntity);
        em.flush();
        
        return newAddressEntity;
    }
    
    
    
    @Override
    public List<AddressEntity> retrieveAllAddress()
    {
        Query query = em.createQuery("SELECT a FROM AddressEntity a");
        
        return query.getResultList();
    }
    
    
    
    @Override
    public AddressEntity retrieveAddressById(Long addressID) throws AddressNotFoundException
    {
        AddressEntity addressEntity = em.find(AddressEntity.class, addressID);
        
        if(addressEntity != null)
        {
            return addressEntity;
        }
        else
        {
            throw new AddressNotFoundException("Address ID " + addressID + " does not exist!");
        }
    }
    
     @Override
    public void updateAddress(AddressEntity addressEntity)
    {
        em.merge(addressEntity);
    }
    
    
    
    @Override
    public void deleteAddress(Long addressID) throws AddressNotFoundException
    {
        AddressEntity addressEntityToRemove = retrieveAddressById(addressID);
        em.remove(addressEntityToRemove);
    }

}

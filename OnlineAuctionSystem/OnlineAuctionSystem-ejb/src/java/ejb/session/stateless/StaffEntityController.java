/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.StaffEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.InvalidLoginCredentialException;
import util.exception.StaffNotFoundException;

@Stateless
@Local(StaffEntityControllerLocal.class)
@Remote(StaffEntityControllerRemote.class)
public class StaffEntityController implements StaffEntityControllerRemote, StaffEntityControllerLocal {

    @PersistenceContext(unitName = "OnlineAuctionSystem-ejbPU")
    private EntityManager em;

    public StaffEntityController() {
    }
    
    @Override
    public StaffEntity createNewStaff(StaffEntity newStaffEntity)
    {
        em.persist(newStaffEntity);
        em.flush();
        
        return newStaffEntity;
    }
    
    
    
    @Override
    public List<StaffEntity> retrieveAllStaff()
    {
        Query query = em.createQuery("SELECT s FROM StaffEntity s");
        
        return query.getResultList();
    }
    
    
    
    @Override
    public StaffEntity retrieveStaffById(Long staffID) throws StaffNotFoundException
    {
        StaffEntity staffEntity = em.find(StaffEntity.class, staffID);
        
        if(staffEntity != null)
        {
            return staffEntity;
        }
        else
        {
            throw new StaffNotFoundException("Staff ID " + staffID + " does not exist!");
        }
    }
    
     @Override
    public void updateStaff(StaffEntity staffEntity)
    {
        em.merge(staffEntity);
    }
    
    
    
    @Override
    public void deleteStaff(Long staffID) throws StaffNotFoundException
    {
        StaffEntity staffEntityToRemove = retrieveStaffById(staffID);
        em.remove(staffEntityToRemove);
    }
    
    @Override
    public StaffEntity staffLogin(String staffUsername, String staffPassword) throws InvalidLoginCredentialException, StaffNotFoundException {
        
        try
        {
            StaffEntity staffEntity = retrieveStaffByUsername(staffUsername);
            
            if(staffEntity.getStaffPassword().equals(staffPassword))
            {
                return staffEntity;
            }
            else 
            {
                throw new InvalidLoginCredentialException("Username does not exist or invalid password!");
            }
        } 
        catch(StaffNotFoundException ex)
        {
            throw new InvalidLoginCredentialException("Username does not exist or invalid password!");
        }
        
    }

    @Override
    public StaffEntity retrieveStaffByUsername(String staffUsername) throws StaffNotFoundException
    {
        Query query = em.createQuery("SELECT s FROM StaffEntity s WHERE s.staffUsername = :inUsername");
        query.setParameter("inUsername", staffUsername);
        
        try
        {
            return (StaffEntity)query.getSingleResult();
        }
        catch(NoResultException | NonUniqueResultException ex)
        {
            throw new StaffNotFoundException("Staff Username " + staffUsername + " does not exist!");
        }
    }

    
}

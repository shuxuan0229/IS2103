/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.CreditPackageEntity;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.CreditPackageNotFoundException;

@Stateless
@Local(CreditPackageEntityControllerLocal.class)
@Remote(CreditPackageEntityControllerRemote.class)

public class CreditPackageEntityController implements CreditPackageEntityControllerRemote, CreditPackageEntityControllerLocal {

    @PersistenceContext(unitName = "OnlineAuctionSystem-ejbPU")
    private EntityManager em;

    public CreditPackageEntityController() {
    }

    @Override
    public CreditPackageEntity createNewCreditPackage(CreditPackageEntity newCreditPackageEntity)
    {
        em.persist(newCreditPackageEntity);
        em.flush();
        
        return newCreditPackageEntity;
    }
    
    
    
    @Override
    public List<CreditPackageEntity> retrieveAllCreditPackages()
    {
        Query query = em.createQuery("SELECT cp FROM CreditPackageEntity cp");
        
        return query.getResultList();
    }
    
    
    
    @Override
    public CreditPackageEntity retrieveCreditPackageById(Long creditPackageID) throws CreditPackageNotFoundException
    {
        CreditPackageEntity creditPackageEntity = em.find(CreditPackageEntity.class, creditPackageID);
        
        if(creditPackageEntity != null)
        {
            return creditPackageEntity;
        }
        else
        {
            throw new CreditPackageNotFoundException("Credit Package ID " + creditPackageID + " does not exist!");
        }
    }
    
     @Override
    public void updateCreditPackage(CreditPackageEntity creditPackageEntity)
    {
        em.merge(creditPackageEntity);
    }
    
    
    
    @Override
    public void deleteCreditPackage(Long creditPackageID) throws CreditPackageNotFoundException
    {
        CreditPackageEntity creditPackageEntityToRemove = retrieveCreditPackageById(creditPackageID);
        em.remove(creditPackageEntityToRemove);
    }

}

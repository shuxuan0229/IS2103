/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AuctionListingEntity;
import entity.CustomerEntity;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import util.exception.AuctionListingNotFoundException;

@Stateless
@Local(AuctionListingEntityControllerLocal.class)
@Remote(AuctionListingEntityControllerRemote.class)
public class AuctionListingEntityController implements AuctionListingEntityControllerRemote, AuctionListingEntityControllerLocal {

    @PersistenceContext(unitName = "OnlineAuctionSystem-ejbPU")
    private EntityManager em;

    public AuctionListingEntityController() {
    }
    @EJB
    private AuctionListingEntityControllerLocal auctionListingEntityControllerLocal; 

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public AuctionListingEntity createNewAuctionListingEntity(AuctionListingEntity auctionListingEntity)
    {
        em.persist(auctionListingEntity);
        em.flush();
        em.refresh(auctionListingEntity);
        
        return auctionListingEntity;
    }
    
    @Override
    public AuctionListingEntity retrieveAuctionListingByID(Long auctionListingID) throws AuctionListingNotFoundException {
        
        AuctionListingEntity auctionListingEntity = em.find(AuctionListingEntity.class, auctionListingID);
        
        if(auctionListingEntity != null)
        {
            return auctionListingEntity;
        }
        else
        {
            throw new AuctionListingNotFoundException("Auction Listing ID " + auctionListingID + " does not exist!");
        }      
    }
    
    @Override
    public List<AuctionListingEntity> retrieveAllAuctionListings()
    {
        Query query = em.createQuery("SELECT al FROM AuctionListingEntity al");
        
        return query.getResultList();
        
    }

    @Override
    public void updateAuctionListing(AuctionListingEntity auctionListingEntity)
    {
        em.merge(auctionListingEntity);
    }
    
    
    
    @Override
    public void deleteAuctionListing(Long auctionListingID) throws AuctionListingNotFoundException
    {
        AuctionListingEntity auctionListingEntityToRemove = retrieveAuctionListingByID(auctionListingID);
        em.remove(auctionListingEntityToRemove);
    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AuctionListingEntity;
import java.util.List;
import util.exception.AuctionListingNotFoundException;

public interface AuctionListingEntityControllerLocal {

    public AuctionListingEntity createNewAuctionListingEntity(AuctionListingEntity auctionListingEntity);

    public List<AuctionListingEntity> retrieveAllAuctionListings();

    public AuctionListingEntity retrieveAuctionListingByID(Long auctionListingID) throws AuctionListingNotFoundException;

    public void deleteAuctionListing(Long auctionListingID) throws AuctionListingNotFoundException;

    public void updateAuctionListing(AuctionListingEntity auctionListingEntity);
    
}

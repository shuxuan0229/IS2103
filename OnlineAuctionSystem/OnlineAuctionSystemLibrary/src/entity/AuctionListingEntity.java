/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import util.enumeration.AuctionStatusEnum;

@Entity
public class AuctionListingEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionListingID;
    @Column(length = 64, nullable = false, unique = true) 
    private String auctionListingName;
    @Column(length = 64, nullable = false) 
    private String productName;    
    @Column(length = 64, nullable = false) 
    private String productDescription;   
    @Column(length = 32, nullable = false)
    private String category;
    @Column(precision = 11, scale = 2)
    private BigDecimal unitPrice; 
    @Column(precision = 11, scale = 2)
    private BigDecimal reservePrice;  
    @Column(precision = 11, scale = 2)
    private BigDecimal currentHighestBid;
    @Column(nullable = false) 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar startDate;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar endDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AuctionStatusEnum status;
    
    @ManyToOne
    @JoinColumn
    private CustomerEntity winningCustomer;
    @OneToMany(mappedBy = "auctionListingEntity")
    private List<AuctionBidTransactionEntity> auctionBidTransactionEntities;
    
    public AuctionListingEntity() {
        auctionBidTransactionEntities = new ArrayList();
    }

    public AuctionListingEntity(String auctionListingName, String productName, String productDescription, String category, BigDecimal unitPrice, BigDecimal reservePrice, BigDecimal currentHighestBid, Calendar startDate, Calendar endDate, AuctionStatusEnum status, CustomerEntity winningCustomer) {
        this();
        
        this.auctionListingName = auctionListingName;
        this.productName = productName;
        this.productDescription = productDescription;
        this.category = category;
        this.unitPrice = unitPrice;
        this.reservePrice = reservePrice;
        this.currentHighestBid = currentHighestBid;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.winningCustomer = winningCustomer;
    }
    
    public Long getAuctionListingID() {
        return auctionListingID;
    }

    public void setAuctionListingID(Long auctionListingID) {
        this.auctionListingID = auctionListingID;
    }
    
    public String getAuctionListingName() {
        return auctionListingName;
    }

    public void setAuctionListingName(String auctionListingName) {
        this.auctionListingName = auctionListingName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getReservePrice() {
        return reservePrice;
    }

    public void setReservePrice(BigDecimal reservePrice) {
        this.reservePrice = reservePrice;
    }
    
    public BigDecimal getCurrentHighestBid() {
        return currentHighestBid;
    }

    public void setCurrentHighestBid(BigDecimal currentHighestBid) {
        this.currentHighestBid = currentHighestBid;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public AuctionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AuctionStatusEnum status) {
        this.status = status;
    }

    public CustomerEntity getWinningCustomer() {
        return winningCustomer;
    }

    public void setWinningCustomer(CustomerEntity winningCustomer) {
        this.winningCustomer = winningCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auctionListingID != null ? auctionListingID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuctionListingEntity)) {
            return false;
        }
        AuctionListingEntity other = (AuctionListingEntity) object;
        if ((this.auctionListingID == null && other.auctionListingID != null) || (this.auctionListingID != null && !this.auctionListingID.equals(other.auctionListingID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AuctionListingEntity[ auctionListingID=" + auctionListingID + " ]";
    }
    
}

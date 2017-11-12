package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import util.enumeration.AuctionBidTransactionStatusEnum;

@Entity
public class AuctionBidTransactionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auctionBidTransactionID;
    @Column(nullable = false) 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar auctionBidTransactionDateTime;
    @Column(nullable = false, precision = 11, scale = 2) 
    private BigDecimal auctionBidTransactionAmount;
    @Column(nullable = false) 
    @Enumerated(EnumType.STRING)
    private AuctionBidTransactionStatusEnum auctionBidTransactionStatus;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private CustomerEntity customerEntity;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private AuctionListingEntity auctionListingEntity;
    @OneToOne(mappedBy = "auctionBidTransactionEntity", optional = false)
    private CreditTransactionEntity creditTransactionEntity;
    @OneToOne
    private CreditTransactionEntity refundedCreditTransactionEntity; 
    
    public AuctionBidTransactionEntity() {
    }

    public AuctionBidTransactionEntity(Calendar auctionBidTransactionDateTime, BigDecimal auctionBidTransactionAmount, AuctionBidTransactionStatusEnum auctionBidTransactionStatus) {
        this.auctionBidTransactionDateTime = auctionBidTransactionDateTime;
        this.auctionBidTransactionAmount = auctionBidTransactionAmount;
        this.auctionBidTransactionStatus = auctionBidTransactionStatus;
    }
    
    public Calendar getAuctionBidTransactionDateTime() {
        return auctionBidTransactionDateTime;
    }

    /**
     * @param auctionBidTransactionDateTime the auctionBidTransactionDateTime to set
     */
    public void setAuctionBidTransactionDateTime(Calendar auctionBidTransactionDateTime) {
        this.auctionBidTransactionDateTime = auctionBidTransactionDateTime;
    }

    /**
     * @return the auctionBidTransactionAmount
     */
    public BigDecimal getAuctionBidTransactionAmount() {
        return auctionBidTransactionAmount;
    }

    /**
     * @param auctionBidTransactionAmount the auctionBidTransactionAmount to set
     */
    public void setAuctionBidTransactionAmount(BigDecimal auctionBidTransactionAmount) {
        this.auctionBidTransactionAmount = auctionBidTransactionAmount;
    }

    /**
     * @return the auctionBidTransactionStatus
     */
    public AuctionBidTransactionStatusEnum getAuctionBidTransactionStatus() {
        return auctionBidTransactionStatus;
    }

    /**
     * @param auctionBidTransactionStatus the auctionBidTransactionStatus to set
     */
    public void setAuctionBidTransactionStatus(AuctionBidTransactionStatusEnum auctionBidTransactionStatus) {
        this.auctionBidTransactionStatus = auctionBidTransactionStatus;
    }

    public Long getAuctionBidTransactionID() {
        return auctionBidTransactionID;
    }

    public void setAuctionBidTransactionID(Long auctionBidTransactionID) {
        this.auctionBidTransactionID = auctionBidTransactionID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auctionBidTransactionID != null ? auctionBidTransactionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuctionBidTransactionEntity)) {
            return false;
        }
        AuctionBidTransactionEntity other = (AuctionBidTransactionEntity) object;
        if ((this.auctionBidTransactionID == null && other.auctionBidTransactionID != null) || (this.auctionBidTransactionID != null && !this.auctionBidTransactionID.equals(other.auctionBidTransactionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AuctionBidTransaction[ auctionBidTransactionID=" + auctionBidTransactionID + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import util.enumeration.CreditTransactionStatusEnum;
import util.enumeration.CreditTransactionTypeEnum;

@Entity
public class CreditTransactionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long creditTransactionId;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar creditTransactionTimeDate;
    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal creditTransactionAmount;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditTransactionStatusEnum creditTransactionStatus;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditTransactionTypeEnum creditTransactionType;
    @Column(length = 3, nullable = false)
    private String creditTransactionCode;
    @Column(length = 16, nullable = false, unique = true)
    private String creditTransactionReference;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private CustomerEntity customerEntity;
    @OneToOne
    private AuctionBidTransactionEntity auctionBidTransactionEntity;
    @OneToOne(mappedBy = "refundedCreditTransactionEntity", optional = false)
    private AuctionBidTransactionEntity refundedAuctionBidTransactionEntity;
    @ManyToOne
    @JoinColumn
    private CreditPackageEntity creditPackageEntity;
    
    public CreditTransactionEntity() {
    }

    public CreditTransactionEntity(Calendar creditTransactionTimeDate, BigDecimal creditTransactionAmount, CreditTransactionStatusEnum creditTransactionStatus, CreditTransactionTypeEnum creditTransactionType, String creditTransactionCode, String creditTransactionReference) {
        this.creditTransactionTimeDate = creditTransactionTimeDate;
        this.creditTransactionAmount = creditTransactionAmount;
        this.creditTransactionStatus = creditTransactionStatus;
        this.creditTransactionType = creditTransactionType;
        this.creditTransactionCode = creditTransactionCode;
        this.creditTransactionReference = creditTransactionReference;
    }
    
    /**
     * @return the creditTransactionTimeDate
     */
    public Calendar getCreditTransactionTimeDate() {
        return creditTransactionTimeDate;
    }

    /**
     * @param creditTransactionTimeDate the creditTransactionTimeDate to set
     */
    public void setCreditTransactionTimeDate(Calendar creditTransactionTimeDate) {
        this.creditTransactionTimeDate = creditTransactionTimeDate;
    }

    /**
     * @return the creditTransactionAmount
     */
    public BigDecimal getCreditTransactionAmount() {
        return creditTransactionAmount;
    }

    /**
     * @param creditTransactionAmount the creditTransactionAmount to set
     */
    public void setCreditTransactionAmount(BigDecimal creditTransactionAmount) {
        this.creditTransactionAmount = creditTransactionAmount;
    }

    /**
     * @return the creditTransactionStatus
     */
    public CreditTransactionStatusEnum getCreditTransactionStatus() {
        return creditTransactionStatus;
    }

    /**
     * @param creditTransactionStatus the creditTransactionStatus to set
     */
    public void setCreditTransactionStatus(CreditTransactionStatusEnum creditTransactionStatus) {
        this.creditTransactionStatus = creditTransactionStatus;
    }

    /**
     * @return the creditTransactionType
     */
    public CreditTransactionTypeEnum getCreditTransactionType() {
        return creditTransactionType;
    }

    /**
     * @param creditTransactionType the creditTransactionType to set
     */
    public void setCreditTransactionType(CreditTransactionTypeEnum creditTransactionType) {
        this.creditTransactionType = creditTransactionType;
    }

    /**
     * @return the creditTransactionCode
     */
    public String getCreditTransactionCode() {
        return creditTransactionCode;
    }

    /**
     * @param creditTransactionCode the creditTransactionCode to set
     */
    public void setCreditTransactionCode(String creditTransactionCode) {
        this.creditTransactionCode = creditTransactionCode;
    }

    /**
     * @return the creditTransactionReference
     */
    public String getCreditTransactionReference() {
        return creditTransactionReference;
    }

    /**
     * @param creditTransactionReference the creditTransactionReference to set
     */
    public void setCreditTransactionReference(String creditTransactionReference) {
        this.creditTransactionReference = creditTransactionReference;
    }

    public Long getCreditTransactionId() {
        return creditTransactionId;
    }

    public void setCreditTransactionId(Long creditTransactionId) {
        this.creditTransactionId = creditTransactionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditTransactionId != null ? creditTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditTransactionEntity)) {
            return false;
        }
        CreditTransactionEntity other = (CreditTransactionEntity) object;
        if ((this.creditTransactionId == null && other.creditTransactionId != null) || (this.creditTransactionId != null && !this.creditTransactionId.equals(other.creditTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CreditTransaction[ creditTransactionId=" + creditTransactionId + " ]";
    }
    
}

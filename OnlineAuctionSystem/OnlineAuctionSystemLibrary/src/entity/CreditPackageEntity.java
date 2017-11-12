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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity
public class CreditPackageEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long creditPackageID;
    @Column(length = 64, nullable = false, unique = true) 
    private String creditPackageName;
    @Column(length = 64, nullable = false) 
    private String creditPackageDescription;
    @Column(precision = 11, scale = 2)
    private BigDecimal creditPackagePrice; 
    @Column(nullable = false) 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar creditPackageStartDate;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar creditPackageEndDate;
    
    @OneToMany(mappedBy = "creditPackageEntity")
    private List<CreditTransactionEntity> creditTransactionEntities;
    
    public CreditPackageEntity() {
        creditTransactionEntities = new ArrayList();
    }

    public CreditPackageEntity(String creditPackageName, String creditPackageDescription, BigDecimal creditPackagePrice, Calendar creditPackageStartDate, Calendar creditPackageEndDate) {
        this();
        
        this.creditPackageName = creditPackageName;
        this.creditPackageDescription = creditPackageDescription;
        this.creditPackagePrice = creditPackagePrice;
        this.creditPackageStartDate = creditPackageStartDate;
        this.creditPackageEndDate = creditPackageEndDate;
    }
    
    public String getCreditPackageName() {
        return creditPackageName;
    }

    public void setCreditPackageName(String creditPackageName) {
        this.creditPackageName = creditPackageName;
    }

    public String getCreditPackageDescription() {
        return creditPackageDescription;
    }

    /**
     * @param creditPackageDescription the creditPackageDescription to set
     */
    public void setCreditPackageDescription(String creditPackageDescription) {
        this.creditPackageDescription = creditPackageDescription;
    }

    /**
     * @return the creditPackagePrice
     */
    public BigDecimal getCreditPackagePrice() {
        return creditPackagePrice;
    }

    /**
     * @param creditPackagePrice the creditPackagePrice to set
     */
    public void setCreditPackagePrice(BigDecimal creditPackagePrice) {
        this.creditPackagePrice = creditPackagePrice;
    }

    /**
     * @return the creditPackageStartDate
     */
    public Calendar getCreditPackageStartDate() {
        return creditPackageStartDate;
    }

    /**
     * @param creditPackageStartDate the creditPackageStartDate to set
     */
    public void setCreditPackageStartDate(Calendar creditPackageStartDate) {
        this.creditPackageStartDate = creditPackageStartDate;
    }

    /**
     * @return the creditPackageEndDate
     */
    public Calendar getCreditPackageEndDate() {
        return creditPackageEndDate;
    }

    /**
     * @param creditPackageEndDate the creditPackageEndDate to set
     */
    public void setCreditPackageEndDate(Calendar creditPackageEndDate) {
        this.creditPackageEndDate = creditPackageEndDate;
    }

    public Long getCreditPackageID() {
        return creditPackageID;
    }

    public void setCreditPackageID(Long creditPackageID) {
        this.creditPackageID = creditPackageID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (creditPackageID != null ? creditPackageID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditPackageEntity)) {
            return false;
        }
        CreditPackageEntity other = (CreditPackageEntity) object;
        if ((this.creditPackageID == null && other.creditPackageID != null) || (this.creditPackageID != null && !this.creditPackageID.equals(other.creditPackageID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CreditPackageEntity[ creditPackageID=" + creditPackageID + " ]";
    }
    
}

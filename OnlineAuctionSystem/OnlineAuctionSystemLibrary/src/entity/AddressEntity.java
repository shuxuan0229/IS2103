/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import util.enumeration.AddressStatusEnum;

/**
 *
 * @author Katrina
 */
@Entity
public class AddressEntity implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressID;
    private AddressStatusEnum addressStatus;
    private String addressLine1;
    private String addressLine2;
    private String postalCode;

    @ManyToMany(mappedBy = "addressEntities")
    private List<CustomerEntity> customerEntities;
    
    public AddressEntity() {
        customerEntities = new ArrayList();
    }

    public AddressEntity(AddressStatusEnum addressStatus, String addressLine1, String addressLine2, String postalCode) {
        this();
        
        this.addressStatus = addressStatus;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.postalCode = postalCode;
    }
    
    /**
     * @return the addressID
     */
    public Long getAddressID() {
        return addressID;
    }

    /**
     * @param addressID the addressID to set
     */
    public void setAddressID(Long addressID) {
        this.addressID = addressID;
    }

    /**
     * @return the addressStatus
     */
    public AddressStatusEnum getAddressStatus() {
        return addressStatus;
    }

    /**
     * @param addressStatus the addressStatus to set
     */
    public void setAddressStatus(AddressStatusEnum addressStatus) {
        this.addressStatus = addressStatus;
    }

    /**
     * @return the addressLine1
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * @param addressLine1 the addressLine1 to set
     */
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * @return the addressLine2
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * @param addressLine2 the addressLine2 to set
     */
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * @return the postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * @param postalCode the postalCode to set
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getAddressID() != null ? getAddressID().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AddressEntity)) {
            return false;
        }
        AddressEntity other = (AddressEntity) object;
        if ((this.getAddressID() == null && other.getAddressID() != null) || (this.getAddressID() != null && !this.addressID.equals(other.addressID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.AddressEntity[ addressID=" + getAddressID() + " ]";
    }

    /**
     * @return the customerEntities
     */
    public List<CustomerEntity> getCustomerEntities() {
        return customerEntities;
    }

    /**
     * @param customerEntities the customerEntities to set
     */
    public void setCustomerEntities(List<CustomerEntity> customerEntities) {
        this.customerEntities = customerEntities;
    }
    
}

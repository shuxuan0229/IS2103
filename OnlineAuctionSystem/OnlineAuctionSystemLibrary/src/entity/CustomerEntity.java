/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import util.enumeration.CustomerAccountTypeEnum;
import util.enumeration.GenderEnum;


@Entity
public class CustomerEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerID;
    @Column(length = 32, nullable = false)
    private String firstName;
    @Column(length = 32, nullable = false)
    private String lastName;
    @Column(length = 32, nullable = false, unique = true)
    private String customerUsername;
    @Column(length = 32, nullable = false)
    private String customerPassword;
    @Column(length = 9, nullable = false, unique = true)
    private String identificationNumber;
    @Column(length = 32, nullable = false)
    private String contactNumber;
    @Column(length = 64, nullable = false)
    private String addressLine1;
    @Column(length = 64)
    private String addressLine2;
    @Column(length = 6, nullable = false)
    private String postalCode;
    @Column(length = 64, nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthday;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CustomerAccountTypeEnum accountType;
    @Column(nullable = false, precision = 18, scale = 4)
    private BigDecimal creditBalance;
    @Column(nullable = false)
    private Boolean enabled;
    
    @OneToMany(mappedBy = "winningCustomer")
    @JoinColumn (nullable = false)
    private List<AuctionListingEntity> auctionListingEntities;
    @OneToMany(mappedBy = "customerEntity")
    private List<AuctionBidTransactionEntity> auctionBidTransactionEntities;
    @OneToMany(mappedBy = "customerEntity")
    private List<CreditTransactionEntity> creditTransactionEntities;
    @ManyToMany
    @JoinColumn ( nullable = false )
    private List<AddressEntity> addressEntities;

    public CustomerEntity() {
        auctionListingEntities = new ArrayList();
        auctionBidTransactionEntities = new ArrayList();
        creditTransactionEntities = new ArrayList();
        addressEntities = new ArrayList();
    }

    public CustomerEntity(String firstName, String lastName, String identificationNumber, String contactNumber, String addressLine1, String addressLine2, String postalCode, String email, GenderEnum gender, Date birthday, CustomerAccountTypeEnum accountType, BigDecimal creditBalance, Boolean enabled) {
        this();
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.contactNumber = contactNumber;
        this.email = email;
        this.gender = gender;
        this.birthday = birthday;
        this.accountType = accountType;
        this.creditBalance = creditBalance;
        this.enabled = enabled;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderEnum getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public CustomerAccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(CustomerAccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(BigDecimal creditBalance) {
        this.creditBalance = creditBalance;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
    

    public Long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Long customerID) {
        this.customerID = customerID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerID != null ? customerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerEntity)) {
            return false;
        }
        CustomerEntity other = (CustomerEntity) object;
        if ((this.customerID == null && other.customerID != null) || (this.customerID != null && !this.customerID.equals(other.customerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CustomerEntity[ id=" + customerID + " ]";
    }

    /**
     * @return the addressEntities
     */
    public List<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    /**
     * @param addressEntities the addressEntities to set
     */
    public void setAddressEntities(List<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
    }

    /**
     * @return the auctionBidTransactionEntities
     */
    public List<AuctionBidTransactionEntity> getAuctionBidTransactionEntities() {
        return auctionBidTransactionEntities;
    }

    /**
     * @param auctionBidTransactionEntities the auctionBidTransactionEntities to set
     */
    public void setAuctionBidTransactionEntities(List<AuctionBidTransactionEntity> auctionBidTransactionEntities) {
        this.auctionBidTransactionEntities = auctionBidTransactionEntities;
    }

    /**
     * @return the creditTransactionEntities
     */
    public List<CreditTransactionEntity> getCreditTransactionEntities() {
        return creditTransactionEntities;
    }

    /**
     * @param creditTransactionEntities the creditTransactionEntities to set
     */
    public void setCreditTransactionEntities(List<CreditTransactionEntity> creditTransactionEntities) {
        this.creditTransactionEntities = creditTransactionEntities;
    }

    /**
     * @return the customerUsername
     */
    public String getCustomerUsername() {
        return customerUsername;
    }

    /**
     * @param customerUsername the customerUsername to set
     */
    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    /**
     * @return the customerPassword
     */
    public String getCustomerPassword() {
        return customerPassword;
    }

    /**
     * @param customerPassword the customerPassword to set
     */
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
    
}

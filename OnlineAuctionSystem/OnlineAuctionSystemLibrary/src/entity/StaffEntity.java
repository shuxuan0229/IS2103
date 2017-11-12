/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import util.enumeration.StaffAccessRightEnum;

@Entity
public class StaffEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffID; 
    @Column(length = 32, nullable = false)
    private String firstName;
    @Column(length = 32, nullable = false)
    private String lastName;
    @Column(length = 32, nullable = false, unique = true)
    private String staffUsername;
    @Column(length = 32, nullable = false)
    private String staffPassword;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StaffAccessRightEnum accessRight;
    
    public StaffEntity() {
    }

    public StaffEntity(String firstName, String lastName, String username, String password, StaffAccessRightEnum accessRight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.staffUsername = username;
        this.staffPassword = password;
        this.accessRight = accessRight;
    }

    /**
     * @return the staffID
     */
    public Long getStaffID() {
        return staffID;
    }

    /**
     * @param staffID the staffID to set
     */
    public void setStaffID(Long staffID) {
        this.staffID = staffID;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the username
     */

    /**
     * @return the accessRight
     */
    public StaffAccessRightEnum getAccessRight() {
        return accessRight;
    }

    /**
     * @param accessRight the accessRight to set
     */
    public void setAccessRight(StaffAccessRightEnum accessRight) {
        this.accessRight = accessRight;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getStaffID() != null ? getStaffID().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StaffEntity)) {
            return false;
        }
        StaffEntity other = (StaffEntity) object;
        if ((this.getStaffID() == null && other.getStaffID() != null) || (this.getStaffID() != null && !this.staffID.equals(other.staffID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.StaffEntity[ staffID=" + getStaffID() + " ]";
    }

    /**
     * @return the staffUsername
     */
    public String getStaffUsername() {
        return staffUsername;
    }

    /**
     * @param staffUsername the staffUsername to set
     */
    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    /**
     * @return the staffPassword
     */
    public String getStaffPassword() {
        return staffPassword;
    }

    /**
     * @param staffPassword the staffPassword to set
     */
    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }
    
}

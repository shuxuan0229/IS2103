/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.StaffEntity;
import java.util.List;
import util.exception.InvalidLoginCredentialException;
import util.exception.StaffNotFoundException;

public interface StaffEntityControllerRemote {
    public StaffEntity createNewStaff(StaffEntity newStaffEntity);

    public List<StaffEntity> retrieveAllStaff();

    public StaffEntity retrieveStaffById(Long staffID) throws StaffNotFoundException;

    public void updateStaff(StaffEntity staffEntity);

    public void deleteStaff(Long staffID) throws StaffNotFoundException;
    
    public StaffEntity retrieveStaffByUsername(String staffUsername) throws StaffNotFoundException;
      
    public StaffEntity staffLogin(String staffUsername, String staffPassword) throws InvalidLoginCredentialException, StaffNotFoundException;
}

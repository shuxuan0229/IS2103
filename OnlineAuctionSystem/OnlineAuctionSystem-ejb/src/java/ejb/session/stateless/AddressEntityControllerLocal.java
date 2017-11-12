/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.AddressEntity;
import java.util.List;
import util.exception.AddressNotFoundException;

public interface AddressEntityControllerLocal {

    public AddressEntity createNewAddress(AddressEntity newAddressEntity);

    public List<AddressEntity> retrieveAllAddress();

    public AddressEntity retrieveAddressById(Long addressID) throws AddressNotFoundException;

    public void updateAddress(AddressEntity addressEntity);

    public void deleteAddress(Long addressID) throws AddressNotFoundException;
    
}

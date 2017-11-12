/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.session.stateless;

import entity.CreditPackageEntity;
import java.util.List;
import util.exception.CreditPackageNotFoundException;

public interface CreditPackageEntityControllerRemote {
    public CreditPackageEntity createNewCreditPackage(CreditPackageEntity newCreditPackageEntity);

    public List<CreditPackageEntity> retrieveAllCreditPackages();

    public CreditPackageEntity retrieveCreditPackageById(Long creditPackageID) throws CreditPackageNotFoundException;

    public void updateCreditPackage(CreditPackageEntity creditPackageEntity);

    public void deleteCreditPackage(Long creditPackageID) throws CreditPackageNotFoundException;
    
}

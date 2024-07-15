package com.nahom.chackduplicatecutomermain.services;




import java.util.Collection;

import com.nahom.chackduplicatecutomermain.entity.TblSanctionCustomer;

public interface TblSanctionCustomerService {
      Collection<TblSanctionCustomer> findDeliquentByFullName(String fullName);

      Collection<TblSanctionCustomer> findSanctionByPhone(String name);
}

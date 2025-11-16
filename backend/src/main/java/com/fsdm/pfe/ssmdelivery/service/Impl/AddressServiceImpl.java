
/*
 * **
 *  * @project : SSMDelivery
 *  * @created : 27/04/2024, 15:27
 *  * @modified : 27/04/2024, 15:27
 *  * @description : This file is part of the SSMDelivery project.
 *  * @license : MIT License
 * **
 */

package com.fsdm.pfe.ssmdelivery.service.Impl;

import com.fsdm.pfe.ssmdelivery.entity.Address;
import com.fsdm.pfe.ssmdelivery.repository.AddressRepo;
import com.fsdm.pfe.ssmdelivery.service.AddressService;
import com.fsdm.pfe.ssmdelivery.service.Impl.location.AreaServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;

    private final AreaServiceImpl areaService;

    public AddressServiceImpl(AddressRepo addressRepo, AreaServiceImpl areaService) {
        this.addressRepo = addressRepo;
        this.areaService = areaService;
    }

    @Override
    public Address updateAddress(Address address) {
        return addressRepo.save(address);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepo.deleteById(id);
    }

    @Override
    public Address loadAddressById(Long id) {
        return addressRepo.findById(id).orElse(null);
    }

    @Override
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }


}




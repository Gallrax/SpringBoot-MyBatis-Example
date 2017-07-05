package com.sm.service.impl;

import com.sm.dao.AddressDao;
import com.sm.entity.Address;
import com.sm.service.AddressSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Service
@Transactional
public class AddressSerImpl implements AddressSer{

    @Autowired
    private AddressDao addressDao;


    @Override
    public List<Address> findAll() {
        return addressDao.findAll();
    }

    @Override
    public Address findById(Integer id) {
        return addressDao.findById(id);
    }

    @Override
    public void addAddress(Address address) {
        addressDao.addAddress(address);
    }

    @Override
    public void updateAddress(Address address) {
        addressDao.updateAddress(address);
    }

    @Override
    public void deleteAddress(Integer id) {
        addressDao.deleteAddress(id);
    }
}

package com.sm.service;

import com.sm.entity.Address;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
public interface AddressSer {

    List<Address> findAll();

    List<Address> findByUserId(Integer userId);

    Address findById(Integer id);

    void addAddress(Address address);

    void updateAddress(Address address);

    void deleteAddress(Integer id);
}

package com.sm.dao;

import com.sm.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Gallrax on 2017/7/5.
 */
public interface AddressDao {

    List<Address> findAll();

    List<Address> findByUserId(@Param("userId") Integer userId);

    Address findById(@Param("id") Integer id);

    void addAddress(@Param("address") Address address);

    void updateAddress(@Param("address") Address address);

    void deleteAddress(@Param("id") Integer id);
}

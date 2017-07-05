package com.sm.controller;

import com.sm.entity.Address;
import com.sm.service.AddressSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class AddressController {

    @Autowired
    private AddressSer addressSer;

    @RequestMapping("/addressManage")
    public String index() {
        List<Address> addresses = addressSer.findAll();
        return "addressManage";
    }

    @RequestMapping("/addAddress")
    public String addAddress(Address address) {
        addressSer.addAddress(address);
        return "addressManage";
    }
}

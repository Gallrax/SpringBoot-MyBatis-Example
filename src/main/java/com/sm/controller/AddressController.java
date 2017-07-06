package com.sm.controller;

import com.sm.entity.Address;
import com.sm.service.AddressSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class AddressController {

    @Autowired
    private AddressSer addressSer;

    @RequestMapping("/addressManage")
    public String addressManage() {
        List<Address> addresses = addressSer.findAll();
        return "addressManage";
    }

    @RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
    public String findAddressById(@PathVariable Integer id, Model model) {
        Address address = addressSer.findById(id);
        model.addAttribute("address", address);
        return "addressManage";
    }

    @RequestMapping("/addAddress")
    public String addAddress(Address address) {
        addressSer.addAddress(address);
        return "addressManage";
    }

    @RequestMapping("/updateAddress")
    public String updateAddress(Address address) {
        addressSer.updateAddress(address);
        return "redirect:/addressManage";
    }

    @RequestMapping(value = "/deleteAddress/{id}", method = RequestMethod.GET)
    public String deleteAddress(@PathVariable Integer id) {
        addressSer.deleteAddress(id);
        return "redirect:/addressManage";
    }
}

package com.sm.controller;

import com.sm.entity.Address;
import com.sm.service.AddressSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class AddressController {

    @Autowired
    private AddressSer addressSer;

    @RequestMapping(value = "/addressManage/{userId}", method = RequestMethod.GET)
    public String addressManage(@PathVariable Integer userId, Model model) {
        List<Address> addresses = addressSer.findByUserId(userId);
        model.addAttribute("addresses", addresses);
        model.addAttribute("userId", userId);
        return "addressManage";
    }

    @RequestMapping(value = "/address/{userId}/{id}", method = RequestMethod.GET)
    public String findAddressById(@PathVariable Integer userId, @PathVariable Integer id, Model model) {
        model.addAttribute("userId", userId);
        if (id == 0) return "addAndUpdateAddress";
        Address address = addressSer.findById(id);
        if (address.getUser().getId() != userId) throw new RuntimeException("该用户与地址不匹配");
        model.addAttribute("address", address);
        return "addAndUpdateAddress";
    }

    @RequestMapping("/addAddress")
    public String addAddress(Address address, RedirectAttributes ra) {
        if(address.getName() == null || address.getName().isEmpty()) throw new RuntimeException("没有地址名");
        if (address.getId() != null) {
            addressSer.updateAddress(address);
        } else {
            addressSer.addAddress(address);
        }
        //RedirectAddtibutes带参数 http://localhost:8080/addressManage?userId=2,不适合restful风格
        //ra.addAttribute("userId", address.getUser().getId());

        return "redirect:/addressManage/"+ address.getUser().getId();
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

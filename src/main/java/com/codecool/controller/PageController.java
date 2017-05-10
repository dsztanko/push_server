package com.codecool.controller;

import com.codecool.model.Device;
import com.codecool.repository.DeviceRepository;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Device> saveAppIdOfDevice(@RequestBody JSONObject json) {
        Device device = new Device((String) json.get("token"));
        deviceRepository.save(device);
        return new ResponseEntity<>(device, HttpStatus.OK);
    }
}

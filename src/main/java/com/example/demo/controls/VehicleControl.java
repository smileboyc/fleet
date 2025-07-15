package com.example.demo.controls;

import com.example.demo.entity.Vehicle;
import com.example.demo.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin//跨域注解
public class VehicleControl {
    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/VehicleAdd")
    public  int addStudent(@RequestBody Vehicle vehicle){
        return  vehicleService.addVehicle(vehicle);
    }
}

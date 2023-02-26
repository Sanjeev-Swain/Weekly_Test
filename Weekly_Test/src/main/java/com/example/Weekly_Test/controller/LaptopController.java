package com.example.Weekly_Test.controller;

import com.example.Weekly_Test.model.Laptop;
import com.example.Weekly_Test.model.Student;
import com.example.Weekly_Test.service.LaptopService;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/laptop")
public class LaptopController {

    @Autowired
    LaptopService service;

    @PostMapping("/save-laptop")
    public ResponseEntity saveLaptop(@RequestBody String laptopData)
    {
        Laptop laptop = setLaptop(laptopData);
        int laptopId = service.saveLaptop(laptop);
        return new ResponseEntity("laptop saved with id - "+laptopId , HttpStatus.CREATED);
    }


    @GetMapping("/get-laptop")
    public ResponseEntity getLaptop(@Nullable @RequestParam String laptopId)
    {
        JSONArray laptopDetails = service.getLaptop(laptopId);
        return new ResponseEntity(laptopDetails,HttpStatus.OK);
    }

    @PutMapping(value = "/laptop/{laptop_id}")
    public ResponseEntity<String> updateLaptop(@PathVariable String laptopId,@RequestBody String laptopData)
    {
        Laptop laptop = setLaptop(laptopData);
        service.updateLaptop(laptop,laptopId);
        return new ResponseEntity("laptop updated", HttpStatus.CREATED);
    }

    private Laptop setLaptop(String laptopData)
    {
        JSONObject jsonObject =new JSONObject(laptopData);
        Laptop laptop =new Laptop();
        laptop.setLaptopName(jsonObject.getString("laptop_name"));
        laptop.setLaptopBrand(jsonObject.getString("laptop_brand"));
        laptop.setLaptopPrice(jsonObject.getInt("laptop_price"));
        return laptop;
    }


}

package com.example.Weekly_Test.service;

import com.example.Weekly_Test.model.Laptop;
import com.example.Weekly_Test.model.Student;
import com.example.Weekly_Test.repository.LaptopRepository;
import com.example.Weekly_Test.repository.StudentRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    LaptopRepository laptopRepository;

    public int saveLaptop(Laptop laptop) {
        Laptop laptopObj = laptopRepository.save(laptop);
        return laptopObj.getLaptopId();
    }

    public JSONArray getLaptop(String laptopId) {
        JSONArray laptopArray = new JSONArray();
        if (null != laptopId && laptopRepository.findById(Integer.valueOf(laptopId)).isPresent()) {
            Laptop laptop = laptopRepository.findById(Integer.valueOf(laptopId)).get();
            JSONObject userObj = setLaptop(laptop);
            laptopArray.put(userObj);
        } else {
            List<Laptop> laptopList = laptopRepository.findAll();
            for (Laptop laptop : laptopList) {
                JSONObject laptopObj = setLaptop(laptop);
                laptopArray.put(laptopObj);
            }
        }
        return laptopArray;
    }

    private JSONObject setLaptop(Laptop laptop) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("laptopId", laptop.getLaptopId());
        jsonObject.put("laptop_name", laptop.getLaptopName());
        jsonObject.put("laptop_brand", laptop.getLaptopBrand());
        jsonObject.put("laptop_price", laptop.getLaptopPrice());

        return jsonObject;
    }

    public void updateLaptop(Laptop newLaptop, String laptopId) {
        if (laptopRepository.findById(Integer.valueOf(laptopId)).isPresent()) {
            Laptop laptop = laptopRepository.findById(Integer.valueOf(laptopId)).get();
            laptop.setLaptopName(newLaptop.getLaptopName());
            laptop.setLaptopBrand(newLaptop.getLaptopBrand());
            laptop.setLaptopPrice(newLaptop.getLaptopPrice());

            laptopRepository.save(laptop);
        }


    }
}

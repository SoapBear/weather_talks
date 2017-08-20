package ru.soapbear.weathertalks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.soapbear.weathertalks.dao.TestDAO;
import ru.soapbear.weathertalks.entity.City;
import ru.soapbear.weathertalks.util.ResponseUtil;

@Controller
public class HomeController {

    @Autowired
    private TestDAO testDAO;

    @RequestMapping(value = "/addCity", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public City addCity(@RequestBody City city) {
        testDAO.saveCity(city);
        return city;
    }

    @RequestMapping(value = "/getCity/{cityId}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public ResponseEntity<City> getCityById(@PathVariable(name="cityId") int cityId) {
        return ResponseUtil.createResponseWithDefaultHeaders(testDAO.getCityById(cityId));
    }

}

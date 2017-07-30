package ru.soapbear.weathertalks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.soapbear.weathertalks.dao.TestDAO;
import ru.soapbear.weathertalks.entity.TestEntity;

@Controller
public class HomeController {

    @Autowired
    TestDAO testDAO;

    @RequestMapping(value = "/testPage", method = RequestMethod.GET)
    public String getTestPage() {
        return "index.html";
    }

    @RequestMapping(value = "/testPage", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public TestEntity testPage(@RequestBody TestEntity entity) {
        testDAO.testQuery(entity);
        return entity;
    }
}

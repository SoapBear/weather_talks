package ru.soapbear.weathertalks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.soapbear.weathertalks.entity.TestEntity;

@Controller
public class HomeController {

    @RequestMapping(value = "/testPage", method = RequestMethod.POST, produces = {"application/json"})
    @ResponseBody
    public TestEntity testPage() {
        TestEntity testEntity = new TestEntity();
        testEntity.setString("test string");
        return testEntity;
    }
}

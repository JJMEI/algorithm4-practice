package cn.meijunjie.web.controller;

import cn.meijunjie.web.service.SpitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class HomeController {

    private static final int DEFAULT_SPITTLE_PER_PAGE  = 25;

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = "/home")
    public String showHomePage(Map<String,Object> model)
    {
        model.put("spittles",spitterService.getRecentSpittles(DEFAULT_SPITTLE_PER_PAGE));
        return "home";
    }


}

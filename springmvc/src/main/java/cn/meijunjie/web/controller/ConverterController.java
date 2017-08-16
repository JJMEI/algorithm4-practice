package cn.meijunjie.web.controller;

import cn.meijunjie.dao.ConverterBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class ConverterController {

    @RequestMapping(value = "/showConverter.html")
    public String testConverter(@RequestParam("converter") ConverterBean converterBean, ModelMap modelMap)
    {
        modelMap.put("person",converterBean);
        return "showPerson";

    }
}

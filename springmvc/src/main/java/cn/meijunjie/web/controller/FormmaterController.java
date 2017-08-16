package cn.meijunjie.web.controller;

import cn.meijunjie.dao.ConverterBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class FormmaterController {

    @RequestMapping(value = "/testFormmater.html")
    public String testFormatter(@ModelAttribute("person")ConverterBean converterBean)
    {
        return "registerBean";
    }

    @RequestMapping(value = "/registerBean.html",method = RequestMethod.POST)
    public ModelAndView testFormmater1(@ModelAttribute("person")ConverterBean converterBean, BindingResult bindingResult)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pserson",bindingResult.getModel().get("person"));
        log.info("数据是不是格式化了。。"+ bindingResult.getModel().get("person").toString());
        modelAndView.setViewName("showPerson");
       return modelAndView;
    }
}

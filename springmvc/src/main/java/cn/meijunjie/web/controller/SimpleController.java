package cn.meijunjie.web.controller;

import cn.meijunjie.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleController {


    @RequestMapping(value = "/index.html")
    public String testIndex()
    {
        return "index";
    }

    @RequestMapping(value = "register_.html")
    public String register()
    {
        return "register";
    }

    @RequestMapping(value = "/createUser.html",method = RequestMethod.POST)
    public ModelAndView createUser(@ModelAttribute("user") User user)
    {

//        new UserService().createUser(user);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("createSuccess");
        return modelAndView;
    }

    @RequestMapping(value = "/pathvariable/{pathVariable}.html")
    public void diaplayPathVariable(@PathVariable("pathVariable") String pathVariable)
    {
        System.out.println(pathVariable);
    }
}

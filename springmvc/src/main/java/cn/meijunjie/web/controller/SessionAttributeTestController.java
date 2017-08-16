package cn.meijunjie.web.controller;

import cn.meijunjie.dao.Person1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Slf4j
@Controller
@SessionAttributes(value = "person1")
public class SessionAttributeTestController {

    @ModelAttribute(value = "person1")
    public Person1 getPersonq()
    {
        Person1 person1 = new Person1();
        person1.setName("Hello");
        return person1;
    }

    @RequestMapping(value = "/testSession.html")
    public String testSessionAttrbute(@ModelAttribute("person1") Person1 person1)
    {
        person1.setName("dsds");
        log.info("重定向至testSession2.html,等于重新发起了一次http请求.....");
        return "redirect:/testSession2.html";
    }

    @RequestMapping(value = "/testSession2.html")
    public String testSessionAttributes2(ModelMap modelMap, SessionStatus sessionStatus)
    {
        log.info("从modelMap中获取Person1d对象 {}",(Person1)modelMap.get("person1"));
        Person1 person1 = (Person1) modelMap.get("person1");
        if(person1 != null)
        {
            person1.setName("hello sessionAttribute!....");
            sessionStatus.setComplete();
        }
        return "showPerson";
    }
}

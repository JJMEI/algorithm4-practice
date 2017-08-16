package cn.meijunjie.web.controller;




import cn.meijunjie.dao.Person1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MapModelTestController {

    @ModelAttribute("person")
    public Person1 getPerson(Person1 person)
    {
        log.info("处理方法执行之前，会首先调用该方法，并将该方法的返回值写入到数据模型中");
        person.setName("MEIJUNJIE");
        log.info("设置属性成功...{}",person.getName());
        return person;
    }

    @RequestMapping(value = "/MapModel.html")
    public String showModelMap(ModelMap modelMap)
    {
        modelMap.addAttribute("testArr","value1");
        log.info("获取modelMap数据"+modelMap.toString());
        Person1 person = (Person1) modelMap.get("person");
        return "showPerson";
    }
}

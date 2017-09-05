package com.example.thymeleaddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by meijunjie on 2017/9/3.
 */
@Controller
public class Demo {

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String index(Model model)
    {
        Person single = new Person("aa",11);
        List<Person> people = new ArrayList<>();
        Person person1 = new Person("sdawe",11);
        Person person2 = new Person("sdawewe",22);
        Person person3 = new Person("sdaewwe",33);
        Person person4 = new Person("sdaewwe",44);
        Person person5 = new Person("sdewawe",55);

        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);

        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);

        return "index";
    }


}

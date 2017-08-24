package cn.meijunjie.web.controller;

import cn.meijunjie.web.dao.Spitter;
import cn.meijunjie.web.dao.Spittle;
import cn.meijunjie.web.service.SpitterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(value = "/spitters")
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = "/spittles/{spitter}")
    public @ResponseBody String  listSpittlesForSpitter(@PathVariable("spitter") String username, Model model)
    {
        Spitter spitter = spitterService.findSpitter(username);
        model.addAttribute("spitter",spitter);
        model.addAttribute("spittles",spitterService.getSpittlesForSpitter(username));
        return "list";
    }


    @RequestMapping(value = "/register")
    public String createNewSpitter(Model model)
    {
        model.addAttribute("spitter",new Spitter());
        return "spitters/register";
    }

    @RequestMapping(value = "/createSpitter",method = RequestMethod.POST)
    public String addSpitterToDataBase(@Valid Spitter spitter, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return "spitters/register";
        }
        spitterService.registerSpitter(spitter);
        return "redirect:/spitters/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}")
    public String showSpitterProfile(@PathVariable("username") String username, Model model)
    {
        List<Spittle> spittles = spitterService.getSpittlesForSpitter(username);
        model.addAttribute("spittles",spittles);

        model.addAttribute("spitter",spitterService.findSpitter(username));

        return "spitters/views";
    }
}

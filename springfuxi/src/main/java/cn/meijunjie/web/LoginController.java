package cn.meijunjie.web;

import cn.meijunjie.po.User;
import cn.meijunjie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login.html")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping(value = "/loginCheck.html")
    public ModelAndView loginCheck(final HttpServletRequest httpServletRequest, final LoginCommand loginCommand)
    {
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUserName(), loginCommand.getPassword());

        if(!isValidUser)
        {
            return  new ModelAndView("login", "error", "用户名或密码错误");
        }else
        {
            User user = userService.findUserByUserName(loginCommand.getUserName());

            user.setLastIp(httpServletRequest.getRemoteAddr());
            user.setLastVisit(new Date());

            userService.loginSuccess(user);

            httpServletRequest.getSession().setAttribute("user", user);
            HttpSession session = httpServletRequest.getSession();

            session.setAttribute("user", user);

            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("main");
//            modelAndView.addObject("user", user);

//            return new ModelAndView("main");
            return modelAndView;
        }
    }
}

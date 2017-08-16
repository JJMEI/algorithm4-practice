//package cn.meijunjie.web.controller;
//
//import cn.meijunjie.dao.User;
//import org.springframework.http.HttpEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.util.WebUtils;
//
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Date;
//
//@Controller
//public class SimpleController {
//
//
//    @RequestMapping(value = "/index.html")
//    public String testIndex()
//    {
//        return "index";
//    }
//
//    @RequestMapping(value = "/register_.html")
//    public String register()
//    {
//        return "register";
//    }
//
//    @RequestMapping(value = "/createUser.html",method = RequestMethod.POST)
//    public ModelAndView createUser(@ModelAttribute("user") User user)
//    {
//
////        new UserService().createUser(user);
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("user",user);
//        modelAndView.setViewName("createSuccess");
//        return modelAndView;
//    }
//
//    @RequestMapping(value = "/pathvariable/{pathVariable}.html")
//    public void diaplayPathVariable(@PathVariable("pathVariable") String pathVariable)
//    {
//        System.out.println(pathVariable);
//    }
//
//    @RequestMapping(value = "/requestParam.html")
//    public String requestParamExample(@RequestParam(name = "userName",required = false,defaultValue = "meijunjie") String userName)
//    {
//        System.out.println("Start Time： " + new Date() + "  " + userName);
//
//        return "index";
//    }
//
//    @RequestMapping(value = "/cookieValue.html")
//    public String cookieValueExample(@CookieValue(name = "JSESSIONID") String JSESSIONID)
//    {
//        System.out.println(JSESSIONID);
//        return "index";
//    }
//
//    @RequestMapping(value = "/requestHeader.html")
//    public String requestHandlerExample(@RequestHeader(name = "Accept-Encoding") String encoding)
//    {
//        System.out.println(encoding);
//        return "index";
//    }
//
//    //从Servlet中获取参数
//
//
//    @RequestMapping(value = "/getParam.html")
//    public void getParamFromServlet(HttpServletRequest request, HttpServletResponse response)
//    {
//        String userName = WebUtils.findParameterValue(request,"userName");
//        System.out.println(userName);
//        response.addCookie(new Cookie("userName",userName));
//    }
//
//    @RequestMapping(value = "/Request.html", method = RequestMethod.POST)
//    public  String requestBodyExample(@RequestBody String requestBody)
//    {
//        System.out.println(requestBody);
//        return "index";
//    }
//
//    @RequestMapping(value = "/httpentity.html")
//    public String httpEntity(HttpEntity<String> httpEntity)
//    {
//        long content = httpEntity.getHeaders().getContentLength();
//        System.out.println(httpEntity.getBody() + " 长度是： "+content);
//        return "index";
//    }
//
//
//    @ModelAttribute("user")
//    public User getUser()
//    {
//        User user = new User();
//        user.setUserName("Meijunjie");
//
//        return user;
//    }
//
//    @RequestMapping(value = "showUser.html")
//    public String exampleModelMap(ModelMap modelMap)
//    {
//        User user = (User) modelMap.get("user");
//
//        return "createSuccess";
//    }
//
//
//    //数据类型转换example
//
//    @RequestMapping(value = "/convert.html")
//    public String convertExample(@RequestParam("user") User user, ModelMap modelMap)
//    {
//        modelMap.put("user",user);
//        return "createSuccess";
//    }
//
//}

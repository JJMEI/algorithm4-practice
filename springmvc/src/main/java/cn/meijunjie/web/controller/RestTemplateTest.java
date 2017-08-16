//package cn.meijunjie.web.controller;
//
//import org.junit.Test;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//public class RestTemplateTest {
//
//    @Test
//    public void testRequestBody()
//    {
//        RestTemplate restTemplate = new RestTemplate();
//
//        MultiValueMap<String,String> form = new LinkedMultiValueMap<String, String>();
//        form.add("userName","PeterMei");
//        form.add("password","meijunjie123");
//        form.add("email","mmeijunjie@163.com");
//
//        restTemplate.postForLocation("http://localhost:8080/springmvc/Request.html",form);
//    }
//}

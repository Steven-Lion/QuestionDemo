package com.newcoder.questionDemo.controller;

import com.sun.javafx.collections.MappingChange;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.util.*;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Response;

/**
 * Created by Steven on 11/07/2017.
 */
@Controller
public class indexController {
    @RequestMapping(path= {"/"},method = {RequestMethod.GET})
    @ResponseBody
    public String index(HttpSession session){
        return "hello i am index" +session.getAttribute("msg");
    }

    @RequestMapping(path= {"/profile/{groudId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("userId") int userId ,
                          @PathVariable("groudId")String groudId ,
                          @RequestParam(value = "type" , defaultValue = "1") int type,
                          @RequestParam(value = "key",defaultValue = "s1" , required = false) String key){
        return String.format("Porfile Page %s of %d t:%d k:%s" , groudId ,userId ,type,key);

        }

        @RequestMapping(path= {"/home11"},method={RequestMethod.GET})

        public String template(Model model)
        {
           model.addAttribute("vlaue1","vvevev") ;
            return "01.ftl";
        }

    @RequestMapping(path= {"/home"},method={RequestMethod.GET})

        public String template1(Model model)
    {
        List<String> colors = Arrays.asList(new String[]{"RED","BULE","YELLOW"});
        model.addAttribute("colors",colors);

        model.addAttribute("user","honey");

        Map<String,String> map = new HashMap<>();
        for(int i =0 ; i<5;i++){
            map.put(String.valueOf(i),String.valueOf(i*i));
        }
        model.addAttribute("map",map);

        return "home";
    }
    @RequestMapping(path={"/redirect/{code}"},method = {RequestMethod.GET})

    public RedirectView redirect(@PathVariable("code")  int code , HttpSession session){
        session.setAttribute("msg","Jump from redirect");
        RedirectView red = new RedirectView("/",true);
        if(code == 301){
            red.setStatusCode(HttpStatus.MOVED_PERMANENTLY);
        }
        return red;

    }
    @RequestMapping(path={"/admin"},method = {RequestMethod.GET})
    @ResponseBody
    public String admin(@RequestParam("key") String key){
        if ("admin".equals(key)){
           return "hello Adminstration" ;
        }
        throw new IllegalArgumentException("参数不对.");
    }
    @ExceptionHandler()
    @ResponseBody
    public String error(Exception e){
        return "Error:"+e.getMessage();
    }

}

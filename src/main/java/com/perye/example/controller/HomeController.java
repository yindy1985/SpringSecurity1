package com.perye.example.controller;

import com.perye.example.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Perye
 * @create: 2018-10-23 22:21
 **/
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试", "测试", "flag{4654654-13131-16546}");
        model.addAttribute("msg", msg);
        return "home";
    }
}

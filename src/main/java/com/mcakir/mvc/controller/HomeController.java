package com.mcakir.mvc.controller;

import com.mcakir.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController extends BaseController {

    public HomeController(){
        super("dashboard");
    }

    public String index(){

        return render("index");
    }

}

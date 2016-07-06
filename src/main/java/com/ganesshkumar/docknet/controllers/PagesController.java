package com.ganesshkumar.docknet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by ganessh on 06/07/16.
 */
@Controller
public class PagesController {
    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }
}

package org.foobarspam.fpInformatica.forum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("login")
    public String displayLogin() {
        return "login";
    }
}
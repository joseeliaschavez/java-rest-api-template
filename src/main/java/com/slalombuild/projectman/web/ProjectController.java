package com.slalombuild.projectman.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    
    @GetMapping("/project")
    public void getProjects() {

    }
}

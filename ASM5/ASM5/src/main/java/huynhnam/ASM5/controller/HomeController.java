package huynhnam.ASM5.controller;

import huynhnam.ASM5.model.Course;
import huynhnam.ASM5.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private CourseService courseService;




    @GetMapping
    public String index(Model model, String keyword){
        if(keyword!=null){
            List<Course> listCourse = courseService.getbyName(keyword);
            model.addAttribute("course", listCourse);
        }
        else{
            List<Course> listCourse = courseService.getAll();
            model.addAttribute("course", listCourse);
        }

        return "home";
    }/*
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("course", courseService.getAll());
        return "home";
    }*/

}

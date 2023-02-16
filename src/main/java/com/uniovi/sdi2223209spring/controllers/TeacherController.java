package com.uniovi.sdi2223209spring.controllers;

import com.uniovi.sdi2223209spring.entities.Teacher;
import com.uniovi.sdi2223209spring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacher/list")
    public String getList(Model model){
        //return teacherService.getTeachers().toString();
        model.addAttribute("teacherList", teacherService.getTeachers());
        return "teacher/list";
    }

    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String setTeacher(@ModelAttribute Teacher teacher){
        teacherService.addTeacher(teacher);
        return "redirect:/teacher/list";
    }

    @RequestMapping(value = "teacher/add")
    public String getTeacher(){
        return "teacher/add";
    }

    @RequestMapping("/teacher/details/{dni}")
    public String getDetail(Model model, @PathVariable String dni){
        //return teacherService.getTeacher(dni).toString();
        model.addAttribute("teacher", teacherService.getTeacher(dni));
        return "teacher/details";
    }

    @RequestMapping("/teacher/delete/{dni}")
    public String deleteTeacher(@PathVariable String dni){
        teacherService.deleteTeacher(dni);
        return "redirect:/teacher/list";
    }


}

package com.uniovi.sdi2223209spring.controllers;

import com.uniovi.sdi2223209spring.entities.Teacher;
import com.uniovi.sdi2223209spring.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/teacher/list")
    public String getList(){
        return teacherService.getTeachers().toString();
    }

    @RequestMapping("/teacher/add")
    public String setTeacher(@ModelAttribute Teacher teacher){
        teacherService.addTeacher(teacher);
        return "added";
    }

    @RequestMapping("/teacher/details/{dni}")
    public String getDetail(@PathVariable String dni){
        return teacherService.getTeacher(dni).toString();
    }

    @RequestMapping("/teacher/delete/{dni}")
    public String deleteTeacher(@PathVariable String dni){
        teacherService.deleteTeacher(dni);
        return "deleted";
    }


}

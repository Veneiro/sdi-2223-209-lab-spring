package com.uniovi.sdi2223209spring.controllers;

import com.uniovi.sdi2223209spring.entities.Mark;
import com.uniovi.sdi2223209spring.entities.Teacher;
import com.uniovi.sdi2223209spring.services.TeacherService;
import com.uniovi.sdi2223209spring.validators.TeacherValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private TeacherValidator teacherValidator;

    @RequestMapping("/teacher/list")
    public String getList(Model model){
        //return teacherService.getTeachers().toString();
        model.addAttribute("teacherList", teacherService.getTeachers());
        return "teacher/list";
    }

    //@RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    //public String setTeacher(@ModelAttribute Teacher teacher){
    //    teacherService.addTeacher(teacher);
    //    return "redirect:/teacher/list";
    //}

    @RequestMapping(value = "/teacher/add", method = RequestMethod.GET)
    public String setTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        model.addAttribute("usersList", teacherService.getTeachers());
        return "teacher/add";
    }

    @RequestMapping(value= "/teacher/add", method = RequestMethod.POST)
    public String setTeacher(Model model, @Validated Teacher professor, BindingResult result) {
        model.addAttribute("teacher", professor);
        model.addAttribute("usersList", teacherService.getTeachers());
        teacherValidator.validate(professor, result);
        if(result.hasErrors()){
            return "teacher/add";
        }
        teacherService.addTeacher(professor);
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

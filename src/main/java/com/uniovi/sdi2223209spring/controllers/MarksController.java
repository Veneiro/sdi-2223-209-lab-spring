package com.uniovi.sdi2223209spring.controllers;

import com.uniovi.sdi2223209spring.services.MarksService;
import com.uniovi.sdi2223209spring.entities.Mark;
import com.uniovi.sdi2223209spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MarksController {

    @Autowired //Inyectar el servicio
    private MarksService marksService;

    @Autowired
    private UsersService usersService;

    @RequestMapping("/mark/list")
    public String getList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list";
        //return "Getting List";
        //return marksService.getMarks().toString();
    }

    @RequestMapping
    public String updateList(Model model){
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list :: tableMarks";
    }

    /**
     * @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
     * public String setMark(@RequestParam String description, @RequestParam String score) {
     * return "Adding Mark" + description + "with score: " + score;
     * }
     */

    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        //return "added: " + mark.getDescription() + " with score : " + mark.getScore() + " id: " + mark.getId();
        marksService.addMark(mark);
        //return "Ok";
        return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/add")
    public String getMark(Model model) {
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/add";
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        //return "Getting Details =>" + id;
        //return marksService.getMark(id).toString();
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id){
        marksService.deleteMark(id);
        //return "Ok";
        return "redirect:/mark/list";
    }

    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/edit";
    }

    @RequestMapping(value = "/mark/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark, @PathVariable Long id) {
        Mark originalMark = marksService.getMark(id);
        //modificar solo score y descripción
        originalMark.setScore(mark.getScore());
        originalMark.setDescription(mark.getDescription());
        //mark.setId(id);
        marksService.addMark(originalMark);
        return "redirect:/mark/details/" + id;
    }
}

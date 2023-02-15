package com.uniovi.sdi2223209spring.controllers;

import com.uniovi.sdi2223209spring.services.MarksService;
import com.uniovi.sdi2223209spring.entities.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {

    @Autowired //Inyectar el servicio
    private MarksService marksService;

    @RequestMapping("/mark/list")
    public String getList() {
        //return "Getting List";
        return marksService.getMarks().toString();
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
        return "Ok";
    }

    @RequestMapping("/mark/details/{id}")
    public String getDetail(@PathVariable Long id) {
        //return "Getting Details =>" + id;
        return marksService.getMark(id).toString();
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id){
        marksService.deleteMark(id);
        return "Ok";
    }
}

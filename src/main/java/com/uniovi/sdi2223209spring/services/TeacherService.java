package com.uniovi.sdi2223209spring.services;

import com.uniovi.sdi2223209spring.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.uniovi.sdi2223209spring.entities.Teacher;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class TeacherService {

    private List<Teacher> teacherList = new LinkedList<>();
    //@Autowired
    //private TeacherRepository teacherRepository;

    @PostConstruct
    public void init(){
        teacherList.add(new Teacher("27483658Y", "Pepe", "Rodríguez", "Ciencias"));
    }
    public List<Teacher> getTeachers(){
        //List<Teacher> teachers = new ArrayList<>();
        //teacherRepository.findAll().forEach(teachers::add);
        //return teachers;
        return teacherList;
    }

    public Teacher getTeacher(String dni){
        //return teacherRepository.findById(dni).get();
        return teacherList.stream().filter(teacher -> teacher.getDni().equals(dni)).findFirst().get();
    }

    public void addTeacher(Teacher teacher){
        //teacherRepository.save(teacher);
        if(teacher.getDni() == null){
            teacher.setDni(teacherList.get(teacherList.size()-1).getDni()+1);
        }
        teacherList.add(teacher);
    }

    public void deleteTeacher(String dni){
        //teacherRepository.deleteById(dni);
        teacherList.removeIf(teacher -> teacher.getDni().equals(dni));
    }


}

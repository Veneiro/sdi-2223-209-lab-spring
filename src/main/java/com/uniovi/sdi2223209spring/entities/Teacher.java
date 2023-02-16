package com.uniovi.sdi2223209spring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private String dni;

    private String name;

    private String surname;

    private String category;

    public Teacher(){}

    public Teacher(String dni, String name, String surname, String category){
        this.dni = dni;
        this.name = name;
        this.surname = surname;
        this.category = category;
    }

    public String getDni(){
        return this.dni;
    }

    public void setDni(String dni){
        this.dni = dni;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public String getCategory(){
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }
    @Override
    public String toString() {
        return this.dni + " " + this.name + " " + this.surname + " " + this.category;
    }
}

package com.uniovi.sdi2223209spring.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_LoginView extends PO_NavView{
    static public void fillLoginForm(WebDriver driver, String dnip, String passwordp) {
        WebElement dni = driver.findElement(By.name("username"));
        dni.click();
        dni.clear();
        dni.sendKeys(dnip);
        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys(passwordp);
        By boton = By.className("btn");
        driver.findElement(boton).click();
    }

    public static void checkLogout(WebDriver driver, int language) {
        String loginText = getP().getString("signup.message", language);
        clickOption(driver, "logout", "text", loginText);
    }


    public static void checkLogin(WebDriver driver, String dni, String password, String textToCheck) {
        clickOption(driver, "login", "class", "btn btn-primary");
        fillLoginForm(driver, dni, password);
        checkElementBy(driver, "text", textToCheck);
    }
}

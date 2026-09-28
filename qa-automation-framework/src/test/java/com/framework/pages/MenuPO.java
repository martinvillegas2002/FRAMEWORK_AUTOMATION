package com.framework.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MenuPO {

    WebDriver driver;

    @FindBy(xpath = "//button[normalize-space()='+ Agregar transacción']")
    private WebElement btnAgregar;

    MenuPO(WebDriver driver){
        this.driver = driver;
    }

}

package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPO {

    WebDriver driver;

    @FindBy(xpath = "//label[normalize-space()='Correo']/following-sibling::input")
    private WebElement labelInputCorreo;

    @FindBy(xpath = "//label[normalize-space()='Contraseña']/following-sibling::input")
    private WebElement labelInputContraseña;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    private WebElement buttonIngresar;

    public LoginPO(WebDriver driver) {
        this.driver = driver;

        // ¡CRÍTICO! Esto activa todos los @FindBy de esta clase
        PageFactory.initElements(driver, this);
    }

    public void ingresarUsuario(String usuario){
        this.labelInputCorreo.sendKeys(usuario);
    }

    public void ingresarContraseña(String contraseña){
        this.labelInputContraseña.sendKeys(contraseña);
    }

    public void clickBtnIngresar(){
        this.buttonIngresar.click();
    }


}

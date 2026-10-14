package com.framework.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPO {

    WebDriver driver;

    // Espera explícita: reintenta hasta 10s antes de fallar (la app tarda en pintar el formulario)
    WebDriverWait wait;

    @FindBy(xpath = "//label[normalize-space()='Correo']/following-sibling::input")
    private WebElement labelInputCorreo;

    @FindBy(xpath = "//label[normalize-space()='Contraseña']/following-sibling::input")
    private WebElement labelInputContraseña;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]")
    private WebElement buttonIngresar;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // ¡CRÍTICO! Esto activa todos los @FindBy de esta clase
        PageFactory.initElements(driver, this);
    }

    public void ingresarUsuario(String usuario){
        wait.until(ExpectedConditions.visibilityOf(this.labelInputCorreo)).sendKeys(usuario);
    }

    public void ingresarContraseña(String contraseña){
        wait.until(ExpectedConditions.visibilityOf(this.labelInputContraseña)).sendKeys(contraseña);
    }

    public void clickBtnIngresar(){
        wait.until(ExpectedConditions.elementToBeClickable(this.buttonIngresar)).click();
    }


}

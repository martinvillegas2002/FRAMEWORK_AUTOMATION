package com.framework.steps;


import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.framework.pages.LoginPO;

public class LoginSteps {

    //el web driver para navegar
    WebDriver driver;

    LoginPO loginPO;



    // Fíjate en el {string}: así es como Cucumber atrapa el <usuario> de tus Examples
    @Given("el usuario ingresa a la pagina con el usuario {string}")
    public void elUsuarioIngresaAlaPaginaConElUsuario(String usuario) {
        System.out.println("El usuario que ingresó desde Gherkin es: " + usuario);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("[http://host.docker.internal:5173/login](http://host.docker.internal:5173/login)");

        loginPO = new LoginPO(driver);
        // Aquí luego agregaremos el código Selenium para escribir ese 'usuario' en la caja de texto
        loginPO.ingresarUsuario(usuario);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @And("ingresa la contraseña {string}")
    public void ingresaLaContraseña(String contraseña) {


        // Aquí luego agregaremos el código Selenium para escribir ese 'usuario' en la caja de texto
        loginPO.ingresarContraseña(contraseña);

        loginPO.clickBtnIngresar();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Then("el titulo de la pestaña debe mostrar el texto esperado")
    public void elTituloDeLaPestañaDebeMostrarElTextoEsperado() {

    }



}

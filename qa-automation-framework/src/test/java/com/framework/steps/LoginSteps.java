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


        // Configuramos las opciones para poder correr en Jenkins/Docker
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        String isHeadless = System.getProperty("headless", "false");

        // Imprimimos en consola para auditar
        System.out.println(">>> MODO HEADLESS ACTIVO: " + isHeadless);

        if (isHeadless.equals("true")) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            // Le damos una resolución virtual en lugar de "maximizar"
            options.addArguments("--window-size=1920,1080");
            options.setBinary("/usr/bin/chromium");

        }

        driver = new ChromeDriver(options);
        driver.get("http://host.docker.internal:5173/login");

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

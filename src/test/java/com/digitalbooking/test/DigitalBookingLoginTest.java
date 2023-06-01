package com.digitalbooking.test;

import com.digitalbooking.pages.LoginPage;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DigitalBookingLoginTest {

    private static LoginPage loginPage;

    @BeforeClass
    public static void setUp(){
    loginPage = LoginPage.createLoginPage();
    }

    @Test
    public void negativeLoginTest(){
        loginPage.open();
        loginPage.maximizePage();
        loginPage.enterTextInInput("admin@gmail.com", loginPage.getEmailInput());
        loginPage.enterTextInInput("password", loginPage.getPassInput());
        loginPage.clickSendBtn();

    loginPage.waitVisibilityBy(By.className("form-feedback"));
    WebElement resultElement = loginPage.getWebElementBY(By.className("form-feedback"));

    String expectedText = "Sus credenciales son inválidas. Por favor, vuelva a intentarlo";
    loginPage.waitTextToBePresentInElement(expectedText, resultElement);

    assertTrue(loginPage.isTextPresentInElement(expectedText, resultElement));
    System.out.println("Result form text: " + resultElement.getText());
    }

    @AfterClass
    public static void finishTest(){
        loginPage.close();
    }

}

package com.digitalbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private By emailInput = By.name("email");
    private By passInput = By.xpath("//input[@name='password']");
    private By sendBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver, String URL) {
        super(driver, URL);
    }

    public static LoginPage createLoginPage(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver= new ChromeDriver();
        URL = "http://testing.ctd.academy/login";
        LoginPage loginPage = new LoginPage(driver, URL);
        return loginPage;
    }


    public By getEmailInput() {
        return emailInput;
    }

    public By getPassInput() {
        return passInput;
    }

    public void enterTextInInput(String text, By input) {
        wait.until(ExpectedConditions.visibilityOf(getWebElementBY(input)));
        WebElement inputEl = getWebElementBY(input);
        inputEl.click();
        inputEl.clear();
        inputEl.sendKeys(text);
    }

    public void clickSendBtn() {
        wait.until(ExpectedConditions.visibilityOf(getWebElementBY(sendBtn)));
        WebElement sendButton = getWebElementBY(sendBtn);
        sendButton.click();
    }



}

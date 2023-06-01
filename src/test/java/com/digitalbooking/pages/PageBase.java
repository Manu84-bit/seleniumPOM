package com.digitalbooking.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PageBase {
    protected static String URL;
    protected static WebDriver driver;
    protected Duration d = Duration.ofSeconds(30);
    protected WebDriverWait wait;

    public PageBase(WebDriver driver, String URL){
        this.driver = driver;
        this.URL = URL;
        wait =  new WebDriverWait(driver, d);
    }

    public void open(){
        driver.get(URL);
    }

    public void maximizePage(){
        driver.manage().window().maximize();
    }

    public void close(){
        driver.close();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public WebElement getWebElementBY(By attribute){
       return driver.findElement(attribute);

    }

    public boolean isTextPresentInElement(String text, WebElement e){
        return e.getText().contains(text);
    }

    public void waitVisibilityBy(By attribute){
       wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(attribute));
    }

    public void waitTextToBePresentInElement( String expectedText, WebElement resultElement){
        wait.until(ExpectedConditions.textToBePresentInElement(resultElement, expectedText));
    }
}

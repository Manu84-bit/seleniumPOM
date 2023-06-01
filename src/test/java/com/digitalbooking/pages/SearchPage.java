package com.digitalbooking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchPage extends BasePage {

    private By searchBox = By.id("ciudad");
    private By searcBtn = By.id("btn-buscador");

    public SearchPage(WebDriver driver, String URL) {
        super(driver, URL);
    }

    public static SearchPage createSearchPage(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver= new ChromeDriver();
        URL = "http://testing.ctd.academy/";
        SearchPage searchPage = new SearchPage(driver, URL);
        return searchPage;
    }

    public By getSearchBox() {
        return searchBox;
    }

    public By getSearcBtn() {
        return searcBtn;
    }

    public void searchCity(String cityText) {
        wait.until(ExpectedConditions.visibilityOf(getWebElementBY(searchBox)));
        WebElement searchBoxEl = getWebElementBY(searchBox);
        searchBoxEl.click();
        searchBoxEl.clear();
        searchBoxEl.sendKeys(cityText);
		searchBoxEl.sendKeys(Keys.ENTER);
    }

    public void clickSearchBtn() {
        wait.until(ExpectedConditions.visibilityOf(getWebElementBY(searcBtn)));
        WebElement searchBtnEl = getWebElementBY(searcBtn);
        searchBtnEl.click();
    }

}

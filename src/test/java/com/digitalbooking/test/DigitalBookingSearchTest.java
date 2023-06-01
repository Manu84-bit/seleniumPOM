package com.digitalbooking.test;

import com.digitalbooking.pages.SearchPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class DigitalBookingSearchTest {
	
	private static SearchPage searchPage;

	@BeforeAll
	public static void setUp(){
		searchPage = SearchPage.createSearchPage();
	}

	@Test
	public void testSearch() {
		searchPage.open();
		searchPage.maximizePage();
		searchPage.searchCity("punta del este");
		searchPage.clickSearchBtn();

		searchPage.waitVisibilityBy(By.className("card-list"));
		WebElement resultElement = searchPage.getWebElementBY(By.className("card-list"));
		String expectedText = "Villa Kantounes Studio Ostria";

		searchPage.waitTextToBePresentInElement(expectedText, resultElement);
		assertTrue(searchPage.isTextPresentInElement(expectedText, resultElement));
		System.out.println("Resultado Card value: " + resultElement.getText());
	}

	@AfterAll
	public static void finishTest(){
		searchPage.close();
	}
}

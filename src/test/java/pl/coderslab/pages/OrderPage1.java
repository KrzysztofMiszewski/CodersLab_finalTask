package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage1 {

    private final WebElement addressContinue;

    public OrderPage1(WebDriver driver) {
        this.addressContinue = driver.findElement(By.cssSelector(".btn"));
    }

    public void clickAddressContinue() {
        addressContinue.click();
    }

}

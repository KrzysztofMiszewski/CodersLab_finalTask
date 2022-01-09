package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage2 {

    private final WebElement shippingContinue;

    public OrderPage2(WebDriver driver) {
        this.shippingContinue = driver.findElement(By.cssSelector(("button.continue:nth-child(2)")));
    }

    public void clickShippingContinue() {
        shippingContinue.click();
    }

}

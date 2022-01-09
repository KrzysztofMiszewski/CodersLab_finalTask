package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private final WebElement proceedToCheckout;

    public CartPage(WebDriver driver) {
        this.proceedToCheckout = driver.findElement(By.cssSelector("a.btn"));
    }

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }
}

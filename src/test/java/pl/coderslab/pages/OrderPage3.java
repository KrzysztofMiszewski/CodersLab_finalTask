package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage3 {

    WebElement pbcBtn;
    WebElement termsBtn;
    WebElement orderBtn;

    public OrderPage3(WebDriver driver) {
        this.pbcBtn = driver.findElement(By.cssSelector("#payment-option-1"));
        this.termsBtn = driver.findElement(By.cssSelector("#conditions_to_approve\\[terms-and-conditions\\]"));
        this.orderBtn = driver.findElement(By.cssSelector("div.ps-shown-by-js > button:nth-child(1)"));
    }

    public void clickPBC() {
        pbcBtn.click();
    }

    public void clickTerms() {
        termsBtn.click();
    }

    public void clickOrderBtn() {
        orderBtn.click();
    }
}

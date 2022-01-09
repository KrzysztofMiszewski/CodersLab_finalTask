package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OrderHistoryPage {

    private final WebElement orderReference;
    private final WebElement totalPrice;
    private final WebElement status;

    public OrderHistoryPage(WebDriver driver) {

        this.orderReference = driver.findElement(By.cssSelector(".table > tbody:nth-child(2) > tr:nth-child(1) > th:nth-child(1)"));
        this.totalPrice = driver.findElement(By.cssSelector(".table > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(3)"));
        this.status = driver.findElement(By.cssSelector(".table > tbody:nth-child(2) > tr:nth-child(1) > td:nth-child(5) > span:nth-child(1)"));
    }

    public String getOrderReference() {
        return orderReference.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getStatus() {
        return status.getText();
    }
}

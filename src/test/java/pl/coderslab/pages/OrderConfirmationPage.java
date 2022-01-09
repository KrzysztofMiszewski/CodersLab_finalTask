package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderConfirmationPage {

    private WebElement reference;
    private WebElement totalPrice;
    private WebElement myAccount;

    public OrderConfirmationPage(WebDriver driver) {
        this.reference = driver.findElement(By.cssSelector("#order-details > ul > li:nth-child(1)"));
        this.totalPrice = driver.findElement(By.cssSelector("#order-items > div > table > tbody > tr.font-weight-bold > td:nth-child(2)"));
        this.myAccount = driver.findElement(By.cssSelector("#_desktop_user_info > div > a.account"));
    }

    public String getReferenceNumber() {
        String[] temp = reference.getText().split(" ");
        return temp[2];
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public void clickMyAccount() {
        myAccount.click();
    }
}

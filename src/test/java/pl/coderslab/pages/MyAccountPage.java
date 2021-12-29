package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

    private final WebElement addressButon;


    public MyAccountPage(WebDriver driver) {

        this.addressButon = driver.findElement(By.id("address-link"));
    }

    public void ClickAddressButton() {
        addressButon.click();
    }
}

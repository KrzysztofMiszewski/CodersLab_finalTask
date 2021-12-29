package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddressesPage {

    WebElement aliasText;
    WebElement addressBody;
    WebElement deleteButton;

    public AddressesPage(WebDriver driver) {

        this.aliasText = driver.findElement(By.cssSelector(".address-body > h4:nth-child(1)"));
        this.addressBody = driver.findElement(By.cssSelector(".address-body > address:nth-child(2)"));
        this.deleteButton = driver.findElement(By.cssSelector(".address-footer > a:nth-child(2) > span:nth-child(2)"));

    }
}

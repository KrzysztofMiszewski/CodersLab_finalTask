package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class AddressesPage {

    private final WebElement aliasText;
    private final WebElement addressBody;
    private final WebElement deleteButton;

    public AddressesPage(WebDriver driver) {

        this.aliasText = driver.findElement(By.cssSelector(".address-body > h4:nth-child(1)"));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        this.addressBody = driver.findElement(By.cssSelector(".address-body > address:nth-child(2)"));
        this.deleteButton = driver.findElement(By.cssSelector(".address-footer > a:nth-child(2) > span:nth-child(2)"));

    }

    public String getAliasText(){
        return aliasText.getText();
    }

    public String getAddressBody(){
        return addressBody.getText();
    }

    public void deleteAddress(){
        deleteButton.click();
    }
}

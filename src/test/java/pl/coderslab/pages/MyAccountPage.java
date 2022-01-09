package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

    private final WebElement addressButon;
    private final WebElement logo;
    private final WebElement history;


    public MyAccountPage(WebDriver driver) {

        this.addressButon = driver.findElement(By.xpath("/html/body/main/section/div/div/section/section/div/div/a[2]"));
        this.logo = driver.findElement(By.cssSelector("#_desktop_logo > a:nth-child(1)"));
        this.history = driver.findElement(By.cssSelector("#history-link"));
    }

    public void clickAddressButton() {
        addressButon.click();
    }

    public void clickLogo() {
        logo.click();
    }

    public void clickHistory() {
        history.click();
    }
}

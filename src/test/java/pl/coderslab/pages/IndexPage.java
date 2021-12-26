package pl.coderslab.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexPage {

    private final WebElement signIn;


    public IndexPage(WebDriver driver) {

        this.signIn = driver.findElement(By.cssSelector(".user-info > a:nth-child(1)"));

    }

    public void ClickSignIn(){
        signIn.click();
    }
}

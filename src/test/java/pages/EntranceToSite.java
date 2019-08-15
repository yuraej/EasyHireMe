package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntranceToSite {
    WebDriver driver;
    By inputLogin = By.name("email");
    By inputPassword = By.name("password");
    By entrance = By.cssSelector("button[type='submit']");

    public EntranceToSite(WebDriver driver) {
        this.driver = driver;
    }

    public void entranceToSite() {
        driver.findElement(inputLogin).sendKeys("tms1@mailinator.com");
        driver.findElement(inputPassword).sendKeys("Password01");
        driver.findElement(entrance).click();
    }
}

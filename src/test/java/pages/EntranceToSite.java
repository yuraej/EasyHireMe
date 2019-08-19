package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class EntranceToSite {
    WebDriver driver;
    By inputLogin = By.name("email");
    By inputPassword = By.name("password");
    By entrance = By.cssSelector("button[type='submit']");

    public EntranceToSite(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void entranceToSite() {
        driver.get("https://automation.easyhire.me");
        driver.findElement(inputLogin).sendKeys("tms1@mailinator.com");
        driver.findElement(inputPassword).sendKeys("Password01");
        driver.findElement(entrance).click();
    }
}

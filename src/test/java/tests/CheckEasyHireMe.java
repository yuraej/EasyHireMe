package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EntranceToSite;

import java.util.concurrent.TimeUnit;

public class CheckEasyHireMe {
    WebDriver driver;

    @BeforeClass
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automation.easyhire.me");
        driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
        EntranceToSite entrance = new EntranceToSite(driver);
        entrance.entranceToSite();
    }

    @Test
    public void checkCreateQuestionSet() {

    }
}

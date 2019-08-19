package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EntranceToSite;
import pages.QuestionSet;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CheckQuestionSet {
    WebDriver driver;

    @BeforeClass
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        EntranceToSite entrance = new EntranceToSite(driver);
        entrance.entranceToSite();
    }

    @Test
    public void checkQuestionSet() {
        QuestionSet questionSet = new QuestionSet(driver);
        questionSet.openQuestionPage();
        questionSet.createQuestionSet("New questions");
        assertEquals("Name of question set must be unique", questionSet.checkQuestionSet());
        driver.findElement(By.xpath("//span[text()='Cancel']")).click();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

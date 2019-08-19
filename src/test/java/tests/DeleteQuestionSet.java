package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.EntranceToSite;
import pages.QuestionSet;

import java.util.concurrent.TimeUnit;

public class DeleteQuestionSet {
    WebDriver driver;

    @BeforeClass
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        EntranceToSite entrance = new EntranceToSite(driver);
        entrance.entranceToSite();
    }

    @Test
    public void deleteQuestionSet() {
        QuestionSet questionSet = new QuestionSet(driver);
        questionSet.openQuestionPage();
        //questionSet.inputQuestionSetName();
        questionSet.deleteQuestionSet();

    }

  /*  @AfterClass
    public void closeBrowser() {
        driver.quit();
    }*/

}

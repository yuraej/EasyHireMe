package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.EntranceToSite;
import pages.LoginPageFactory;
import pages.QuestionSet;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class CreateQuestionSet {
    WebDriver driver;

    @BeforeClass
    public void startTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LoginPageFactory openSite = new LoginPageFactory(driver);
        openSite.openLoginPage();
        openSite.login("tms1@mailinator.com", "Password01");

       /* EntranceToSite entrance = new EntranceToSite(driver);
        entrance.entranceToSite();*/
    }

    @Test
    public void createQuestionSet() {
        QuestionSet questionSet = new QuestionSet(driver);
        questionSet.openQuestionPage();
        questionSet.createQuestionSet("New questions");
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }
}

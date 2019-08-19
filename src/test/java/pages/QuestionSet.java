package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

import java.util.concurrent.TimeUnit;

public class QuestionSet {
    WebDriver driver;
    WebDriverWait wait;

    public QuestionSet(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    By pageQuestions = By.cssSelector("a[href='/home/questions']");
    By questionSet = By.cssSelector("a[title='Create question set']");
    By popUpUniqueMessage = By.id("message-id");
    By editQuestionSet = By.cssSelector("a[title='Edit question set'");
    By questionSetArea = By.cssSelector("input[type='text']");

    public void openQuestionPage() {
        wait.until(ExpectedConditions.elementToBeClickable(pageQuestions)).click();
    }

    public void createQuestionSet(String nameQuestionSet) {
        wait.until(ExpectedConditions.elementToBeClickable(questionSet)).click();
        driver.findElement(By.name("name")).sendKeys(nameQuestionSet);
        driver.findElement(By.xpath("//span[text()='Save']")).click();
    }

    public String checkQuestionSet() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpUniqueMessage));
        return driver.findElement(popUpUniqueMessage).getText();
    }

    public void inputQuestionSetName() {
        driver.findElement(questionSetArea).sendKeys(Keys.BACK_SPACE);
        driver.findElement(questionSetArea).sendKeys(Keys.BACK_SPACE);
        driver.findElement(questionSetArea).sendKeys(Keys.BACK_SPACE);
        driver.findElement(questionSetArea).sendKeys(Keys.BACK_SPACE);
        driver.findElement(questionSetArea).sendKeys(Keys.BACK_SPACE);
        driver.findElement(questionSetArea).sendKeys(Keys.BACK_SPACE);
    }

    public void deleteQuestionSet() {
        wait.until(ExpectedConditions.elementToBeClickable(editQuestionSet)).click();
        driver.findElement(By.xpath("//span[text]()='Delete'")).click();
    }

}


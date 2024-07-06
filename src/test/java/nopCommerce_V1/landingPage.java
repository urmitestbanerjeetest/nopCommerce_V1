package nopCommerce_V1;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class landingPage {
    static Logger log = Logger.getLogger(landingPage.class.getName());

    public static WebDriver driver;

    public landingPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFeaturedProductsText(){
        WebElement featuredProductsElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[1]/strong"));
        return featuredProductsElement.getText();
    }
    public String getWelcomeToStoreText() throws InterruptedException {

        WebElement welcomeElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[2]/div[1]/h2"));
        return welcomeElement.getText();


    }
    public cellphonesPage clickCellPhones () throws InterruptedException {
        By electronics = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[2]/a");
        By cellphones = By.xpath("/html[1]/body[1]/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]");
        WebElement electronicsElement = driver.findElement(electronics);
        WebElement cellphonesElement = driver.findElement(cellphones);
        Actions action = new Actions(driver);

        Actions x = action.moveToElement(electronicsElement).pause(Duration.ofSeconds(5)).moveToElement(cellphonesElement).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        x.perform();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        return new cellphonesPage(driver);
    }


    public String validateCellPhonePage() throws InterruptedException {
        WebElement cellphonesTitleElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
        Assert.assertNotNull(cellphonesTitleElement, "cellphones page 'Cell phones' text not displayed test 2 FAILED!");
        log.info(cellphonesTitleElement.getText());
        log.info("Cell phones page " + cellphonesTitleElement.getText() + " text is displayed test 2 Passed!");
        log.info("Cell phones page is successfully launched!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        return cellphonesTitleElement.getText();
    }
}



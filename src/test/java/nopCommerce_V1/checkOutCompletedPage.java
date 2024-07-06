package nopCommerce_V1;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkOutCompletedPage {
    public static WebDriver driver;
    By nopCommerceIcon = By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img");

    ////img[@alt='nopCommerce demo store'] relative x path
    static Logger log = Logger.getLogger(cellphonesPage.class.getName());
    public checkOutCompletedPage(WebDriver driver){
        this.driver = driver;
    }

    public String getThankYouText(){
        WebElement thankYouText = driver.findElement(By.xpath("//h1[normalize-space()='Thank you']"));
        return thankYouText.getText();

    }
    public void clickNopCommerceIcon() throws InterruptedException {
        driver.findElement(nopCommerceIcon).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }
}

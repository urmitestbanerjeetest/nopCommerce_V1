package nopCommerce_V1;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class checkOutConfirmOrderPage {
    public static WebDriver driver;
  //  By billingAddressText = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[1]/div/div/div/div/div[1]/div[1]/div/strong");
      By clickConfirm = By.xpath("/html[1]/body[1]/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[2]/button[1]");
    static Logger log = Logger.getLogger(cellphonesPage.class.getName());

    public checkOutConfirmOrderPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getBillingAddressText(){
        WebElement billingAddressText = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[1]/div/div/div/div/div[1]/div[1]/div/strong"));
        return billingAddressText.getText();
    }
    public String getTotal2(){
        WebElement total2 = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/ol/li[6]/div[2]/div[1]/div/div/div/form/div[3]/div/div/table/tbody/tr[4]/td[2]/span/strong"));
        return total2.getText();
    }

    public checkOutCompletedPage clickConfirmAndReturnCheckOutCompletedPage(){
        driver.findElement( clickConfirm).click();
        return new checkOutCompletedPage(driver);
    }
}
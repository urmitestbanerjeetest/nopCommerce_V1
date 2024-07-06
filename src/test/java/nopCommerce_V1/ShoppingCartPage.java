package nopCommerce_V1;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
    public static WebDriver driver;
    static Logger log = Logger.getLogger(cellphonesPage.class.getName());
    By iAgreeCheckBox = By.xpath(
            "/html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[3]/input");

    //  By iAgreeCheckBox = By.xpath("//input[@id='termsofservice']");
    By checkOutBtn = By.xpath("//button[@id='checkout']");

    public ShoppingCartPage(WebDriver driver) {
        ShoppingCartPage.driver = driver;
    }

    public String getShoppingCartText() {
        WebElement shoppingCartText = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[1]/h1"));
        return shoppingCartText.getText();
    }
  //  /html/body/div[6]/div[3]/div/div/div/div[2]/div/form/div[3]/div[2]/div[1]/table/tbody/tr[4]/td[2]/span/strong
    public String getTotal() {
        WebElement total1 = driver.findElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$694.00')]"));
        return total1.getText();
    }

    public checkOutasGuestPage clickIAgreeAndCheckoutBox() throws InterruptedException {
        driver.findElement(iAgreeCheckBox).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        driver.findElement(checkOutBtn).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        return new checkOutasGuestPage(driver);
    }
}

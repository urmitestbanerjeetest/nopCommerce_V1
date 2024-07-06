package nopCommerce_V1;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class cellphonesPage {
    static Logger log = Logger.getLogger(cellphonesPage.class.getName());

    public static WebDriver driver;
    By product1LollipopElement = By.xpath("//div[@class='item-grid']//div[1]//div[1]//div[2]//div[3]//div[2]//button[1]");
    By product1AddedNote = By.xpath("/html/body/div[5]/div/p");
    By product2MiniBlueElement = By.xpath("//div[@class='products-wrapper']//div[2]//div[1]//div[2]//div[3]//div[2]//button[1]");
    By product2AddedNote = By.xpath("/html/body/div[5]/div/p");
    By product3NokiaLumia = By.xpath("//div[@class='center-2']//div[3]//div[1]//div[2]//div[3]//div[2]//button[1]");
    By product3AddedNote = By.xpath("/html/body/div[5]/div/p");
    By shoppingcartbtn = By.xpath("//span[@class='cart-label']");
    public cellphonesPage(WebDriver driver){
        this.driver = driver;

    }
    public String getCellPhonesText() throws InterruptedException {
        WebElement cellphonesTitleElement = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
        return  cellphonesTitleElement.getText();

    }
    public String addToCart() throws InterruptedException {
       driver.findElement(product1LollipopElement).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        WebElement product1AddedNote = driver.findElement(By.xpath("/html/body/div[5]/div/p"));
        return product1AddedNote.getText();

    }
    public String addToCart2() throws InterruptedException {
        driver.findElement(product2MiniBlueElement).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        WebElement product2AddedNote = driver.findElement(By.xpath("/html/body/div[5]/div/p"));
        return product2AddedNote.getText();
    }
    public String addToCart3() throws InterruptedException {
        driver.findElement(product3NokiaLumia).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        WebElement product3AddedNote = driver.findElement(By.xpath("/html/body/div[5]/div/p"));
        return product3AddedNote.getText();
    }
    public ShoppingCartPage clickShoppingCartBtn() throws InterruptedException {
        driver.findElement(shoppingcartbtn).click();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        return new ShoppingCartPage(driver);
    }

}


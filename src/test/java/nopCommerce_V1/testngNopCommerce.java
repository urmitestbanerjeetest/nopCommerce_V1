package nopCommerce_V1;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testngNopCommerce extends base {
    Logger log = Logger.getLogger(testngNopCommerce.class.getName());
    WebDriver driver;
    landingPage lp;
    cellphonesPage cpp;
    ShoppingCartPage scp;
    checkOutasGuestPage cogp;
    checkOutBillingPage cobp;
    checkOutShippingMethodPage cosp;
    checkOutPaymentMethodPage copp;
    checkOutPaymentInfoPage copi;
    checkOutConfirmOrderPage cocop;
    checkOutCompletedPage cocp;
    String cppURL = "https://demo.nopcommerce.com/cell-phones";
    String scpURL = "https://demo.nopcommerce.com/cart";
    String checkOutasGuestpURL = "https://demo.nopcommerce.com/login/checkoutasguest?returnUrl=%2Fcart";
    String checkoutBillingPageURL = "https://demo.nopcommerce.com/onepagecheckout#opc-billing";
    String checkOutShippingMethodPageUrl = "https://demo.nopcommerce.com/onepagecheckout#opc-shipping_method";
    String checkOutPaymentMethodPageURL = "https://demo.nopcommerce.com/onepagecheckout#opc-payment_method";
    String checkOutPaymentInfoPageURL = "https://demo.nopcommerce.com/onepagecheckout#opc-payment_info";
    String checkOutConfirmOrderPageURL = "https://demo.nopcommerce.com/onepagecheckout#opc-confirm_order";
    String checkOutCompletedPageURL = "https://demo.nopcommerce.com/checkout/completed";

    @BeforeClass
    public void initNopCommerce() {
        driver = base.initEnvironment("chrome");
        log.info("Chrome browser is open!");
        driver.manage().window().maximize();
        lp = new landingPage(driver);
    }

    @Test(priority = 0)
    public void testValidateLandingPage() throws InterruptedException {
        String productText = lp.getFeaturedProductsText();
        Assert.assertTrue(productText.contains("Featured products"));
        log.info(productText);
        log.info("Landing page" + productText + " text is displayed test 1 passed!");
        log.info("Landing page is successfully launched!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 1)
    public void validateWelcomeToStoreText() throws InterruptedException {
        String text = lp.getWelcomeToStoreText();

//        Assert.assertNotNull(welcomeElement, "Landing page 'Welcome to the store' text not displayed test 1 FAILED!");
        Assert.assertEquals(text, "Welcome to our store");
        log.info(text);
        log.info("Landing page " + text + " text is displayed test 2 Passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);

        //  log.info("Landing page is successfully launched");
    }

    @Test(priority = 2)
    public void validateCellPhonePage() throws InterruptedException {
        //     cpp = new cellphonesPage(driver);
        cpp = lp.clickCellPhones();
        String actual = cellphonesPage.driver.getCurrentUrl();
        String expected = cppURL;

        if (actual.equals(expected))
            log.info("Cell phones page test 3 Passed!");
        else
            log.error("Cell Phones page test 3 Failed!");

        Assert.assertEquals(cellphonesPage.driver.getCurrentUrl(), cppURL);
        log.info("Cell phones page is successfully displayed test 3 passed!");
        String cellPhonesText = cpp.getCellPhonesText();
        Assert.assertEquals(cellPhonesText, "Cell phones");
        log.info(cellPhonesText);
        log.info("Cell phones page " + cellPhonesText + " text is displayed test 4 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 3)
    public void testAddToCart() throws InterruptedException {
        String product1added = cpp.addToCart();
        Assert.assertEquals(product1added, "The product has been added to your shopping cart");
        log.info(product1added);
        log.info("cell phones page " + product1added + " text is displayed test 5 Passed!");
        log.info("Item 1 HTC One M8 Android L 5.0 Lollipop  has been added to the cart");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 4)
    public void testAddToCart2() throws InterruptedException {
        String product2added = cpp.addToCart2();
        Assert.assertEquals(product2added, "The product has been added to your shopping cart");
        log.info(product2added);
        log.info("cell phones page " + product2added + " text is displayed test6 passed!");
        log.info("Item 2 HTC One Mini Blue has been added to the cart");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 5)
    public void testAddToCart3() throws InterruptedException {
        String product3added = cpp.addToCart3();
        Assert.assertEquals(product3added, "The product has been added to your shopping cart");
        log.info(product3added);
        log.info("cell phones page " + product3added + " text is displayed test 6 passed!");
        log.info("Item 3 Nokia Lumia 1020 has been added to the cart");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 6)
    public void validateShoppingCartPage() throws InterruptedException {
        scp = cpp.clickShoppingCartBtn();
        String actual = ShoppingCartPage.driver.getCurrentUrl();
        String expected = scpURL;
        if (actual.equals(expected))
            log.info("Shopping cart page  url test 7 Passed!");
        else
            log.error("Shopping cart  page  test 7 Failed!");

        Assert.assertEquals(ShoppingCartPage.driver.getCurrentUrl(), scpURL);
        log.info("Shopping cart page is successfully displayed test 7 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);

    }

    @Test(priority = 7)
    public void validateShoppingCartText() throws InterruptedException {
        String shoppingCartText = scp.getShoppingCartText();
        Assert.assertEquals(shoppingCartText, "Shopping cart");
        log.info(shoppingCartText);
        log.info("Cell phones page " + shoppingCartText + " text is displayed test 8 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 8)
    public void validateGetTotal1() throws InterruptedException {
        String shoppingCartPageTotal1 = scp.getTotal();
        Assert.assertEquals(shoppingCartPageTotal1, "$694.00");
        log.info(shoppingCartPageTotal1);
        log.info("Shopping cart page " + shoppingCartPageTotal1 + " total is displayed test 9 Passed");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);

    }

    @Test(priority = 9)
    public void validateCheckoutAsGuestPage() throws InterruptedException {
        cogp = scp.clickIAgreeAndCheckoutBox();
        String actual = driver.getCurrentUrl();
        String expected = checkOutasGuestpURL;
        if (actual.equals(expected))
            log.info("Check out as guest page test 9 Passed!");
        else
            log.error("Check out as guest page test 9 Failed!");

        Assert.assertEquals(checkOutasGuestPage.driver.getCurrentUrl(), checkOutasGuestpURL);
        log.info("Check out as guest page is successfully displayed test 9 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 10)
    public void testClickCheckOutAsGuestBtnAndValidateCheckOutBillingPage() throws InterruptedException {
        cobp = cogp.clickCheckoutasguestBtn();
        String actual = driver.getCurrentUrl();
        String expected = checkoutBillingPageURL;
        if (actual.equals(expected))
            log.info("check out Billing  page test 10 Passed!");
        else
            log.error("Check out Billing page test 10 Failed!");
        Assert.assertEquals(checkOutBillingPage.driver.getCurrentUrl(), checkoutBillingPageURL);
        log.info("Check out Billing page is successfully displayed test 10 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 11)
    public void validateCheckOutShippingMethodPage() throws InterruptedException {
        cosp = cobp.clickContinue1AndReturnShippingPage();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        String actual = driver.getCurrentUrl();
        String expected = checkOutShippingMethodPageUrl;
        if (actual.equals(expected))
            log.info("check out Shipping Method page test 11 Passed!");
        else
            log.error("Check out Shipping Method page test 11 Failed!");
        Assert.assertEquals(checkOutShippingMethodPage.driver.getCurrentUrl(), checkOutShippingMethodPageUrl);
        log.info("Check out Shipping Method  page is successfully displayed test 11 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 12)
    public void validateCheckOutPaymentMethodPage() throws InterruptedException {
        copp = cosp.clickContinue2AndReturnCheckOutPaymentMethodPage();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        String actual = driver.getCurrentUrl();
        String expected = checkOutPaymentMethodPageURL;
        if (actual.equals(expected))
            log.info("check out Payment Method page test 12 Passed!");
        else
            log.error("Check out Payment Method page test 12 Failed!");
        Assert.assertEquals(checkOutPaymentMethodPage.driver.getCurrentUrl(), checkOutPaymentMethodPageURL);
        log.info("Check out Payment Method  page is successfully displayed test 12 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 13)
    public void validateCheckOutPaymentInfoPage() throws InterruptedException {
        copi = copp.clickContinue3AndReturnPaymentInfoPage();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        String actual = driver.getCurrentUrl();
        String expected = checkOutPaymentInfoPageURL;
        if (actual.equals(expected))
            log.info("check out Payment Info page test 13 Passed!");
        else
            log.error("Check out Payment Info page test 13 Failed!");
        Assert.assertEquals(checkOutPaymentInfoPage.driver.getCurrentUrl(), checkOutPaymentInfoPageURL);
        log.info("Check out Payment Info  page is successfully displayed test 13 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 14)
    public void validateCheckOutConfirmOrderPage() throws InterruptedException {
        cocop = copi.clickContinue4AndReturnCheckOutConfirmOrderPage();
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        String actual = driver.getCurrentUrl();
        String expected = checkOutConfirmOrderPageURL;
        if (actual.equals(expected))
            log.info("check out confirm order page test 14 Passed!");
        else
            log.error("Check out confirm order page test 14 Failed!");
        Assert.assertEquals(checkOutConfirmOrderPage.driver.getCurrentUrl(), checkOutConfirmOrderPageURL);
        log.info("Check out Payment Info  page is successfully displayed test 14 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);

    }

    @Test(priority = 15)
    public void validateGetBillingAddress() throws InterruptedException {
        String billingAddressText = cocop.getBillingAddressText();
        Assert.assertEquals(billingAddressText, "Billing Address");
        log.info(billingAddressText);
        log.info(" Confirm Order page " + billingAddressText + " text is displayed test 15 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);

    }

    @Test(priority = 16)
    public void validateTotal1AndTotal2() throws InterruptedException {
        String confirmOrderPageTotal2 = cocop.getTotal2();
        Assert.assertEquals(confirmOrderPageTotal2, "$694.00");
        log.info("Total 2 is : " + confirmOrderPageTotal2);
        log.info("Confirm order page " + confirmOrderPageTotal2 + " total is displayed test 16 Passed");
        String shoppingCartPageTotal1 = scp.getTotal();
        Assert.assertEquals(shoppingCartPageTotal1, confirmOrderPageTotal2);
        log.info("Shipping cart page total 1 " + shoppingCartPageTotal1 + " is equal to Confirm order page total 2 " + confirmOrderPageTotal2 + " test 17 is Passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }

    @Test(priority = 17)
    public void validateCheckOutCompletedPage() throws InterruptedException {
        cocp = cocop.clickConfirmAndReturnCheckOutCompletedPage();
        String actual = driver.getCurrentUrl();
        String expected = checkOutCompletedPageURL;
        if (actual.equals(expected))
            log.info("check out completed  page test 18 Passed!");
        else
            log.error("Check out completed page test 18 Failed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
        Assert.assertEquals(checkOutCompletedPage.driver.getCurrentUrl(), checkOutCompletedPageURL);
        log.info("Check out completed page is successfully displayed test 18 passed!");
    }
        @Test(priority = 18)
        public void validateThankYouText() throws InterruptedException {
        String thankYouText = cocp.getThankYouText();
        Assert.assertEquals(thankYouText,"Thank you");
        log.info(thankYouText);
        log.info("Check Out completed Page text "+thankYouText+" is displayed test 19 passed!");
        Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
    }
   @Test(priority = 19)
   public void validateClickNopCommerceIcon() throws InterruptedException {
        cocp.clickNopCommerceIcon();
       Thread.sleep(ThreadTimeDelay.TIME_DELAY_MS);
   }
    @AfterClass
    public void tearDown() {
        //      driver.close();
    }
}



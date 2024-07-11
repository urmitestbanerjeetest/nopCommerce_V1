package Utilities;
import nopCommerce_V1.landingPage;
import org.testng.annotations.DataProvider;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;
public class ExcelDataProviderTest {

    static Logger log = Logger.getLogger(landingPage.class.getName());
    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() {
        Object[][] data = null;
        try {
            data = excelDataRead.getTestData("Sheet1");
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Test(dataProvider = "excelData")
    public void testWithExcelData(String FirstName,String LastName, String Email) {

      //  System.out.println(FirstName + " | " + LastName + " | " + Email);
        log.info(FirstName + " | " + LastName + " | " + Email);
    }

    }






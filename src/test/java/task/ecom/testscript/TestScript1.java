package task.ecom.testscript;

import demoQaSite.SingletonChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import task.ecom.base.Utility;
import task.ecom.base.VerifyStep;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class TestScript1 {
    Utility ul=new Utility();

    WebDriver driver =ul.lunchDriver();

    @BeforeTest
    public void lunchUrl(){
        driver.get(ul.findProp("url"));
        System.out.println(driver.getTitle());
        VerifyStep.verifyPageTitle(ul.findProp("expTitle"));



    }
    @Test(priority = 0)
    public void checkAllItem(){

        WebElement element=driver.findElement(By.xpath(ul.findProp("searchText")));
        WebElement click=driver.findElement(By.xpath(ul.findProp("searchButton")));


       if( Utility.enterValueInTextBox(element,ul.findProp("expSearch"))) {


           Utility.clickButton(click);

           List<WebElement> links = driver.findElements(By.xpath(ul.findProp("listForSearch")));

           VerifyStep.verifyAllItem(links, ul.findProp("expSearch"));
       }

       }
@Test(priority = 1)
    public void findLowestPriceDetails(){
        List<WebElement> links1 = driver.findElements(By.xpath(ul.findProp("listForSearch")));
    List<WebElement> links = driver.findElements(By.xpath(ul.findProp("listForPrice")));

   // double lp=VerifyStep.getLowestPriceItem(links);
    VerifyStep.getLowestPriceItemDetails(links1,links, ul.findProp("expSearch"));
    //VerifyStep.grtLowest(links1,links,ul.findProp("expSearch"));


    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}

package task.ecom.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utility {

        static WebDriver driver ;//= SingletonChromeDriver.getInstance().driver;
        /*Method Description: This method is used to check whether the given element is present or not.
        Returns: True, if found
        false, if not found */
        public static boolean isElementPresent(WebElement locator) {
            boolean flag;
            if (locator.isDisplayed()) {
                flag = true;
                System.out.println("flag"+flag);
            } else
            {
                flag = false;
                System.out.println(flag);
            }


            return flag;

           /* System.out.println("true");

            return true;*/
        }
        public static boolean isSelected(WebElement locator) {

            return true;
        }
        /*Method Description: This method is used to get page Title.
        Returns: Page Title
        */
        public static String getPageTitle() {

            String pageText = driver.getTitle();
            // System.out.println(pageText);


            return pageText;
        }
        /*Method Description: This method is used to Enter the Value in Text box.
          Returns: Null
        */
        public static boolean enterValueInTextBox(WebElement locator, String enterText) {

            if (isElementPresent(locator)) {
                locator.sendKeys(enterText);
                System.out.println("locator is  present");
                return true;


            } else {
                System.out.println("locator is not present");
                return false;
            }

            //return false;
        }
        /*Method Description: This method is used for click action.
          Returns: Null
        */
        public static void clickButton(WebElement locator) {

            if (isElementPresent(locator)) {
                //JavascriptExecutor js = (JavascriptExecutor) driver;
                //js.executeScript("arguments[0].click();", locator);
                locator.click();

                System.out.println("locator is  present");
            } else {
                System.out.println("locator is not present");
            }
        }
    /*Method Description: This method is used for click radiobutton
      Returns: Null
    */
        public static void radioButton(WebElement locator) {

            if (isSelected(locator)) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", locator);
                //locator.click();

                System.out.println("locator is  present");
            } else {
                System.out.println("locator is not present");
            }
        }
    /*Method Description: This method is used to get data from properties file
      Returns: Key Value from file
    */
    public String findProp(String data){
        String UserDir = System.getProperty("user.dir");
        String PathSep = System.getProperty("file.separator");
        String filePath = UserDir + PathSep + "src" + PathSep+"test"+PathSep+"java"+PathSep+"task"+PathSep+"ecom"+PathSep+ "testdata" +PathSep+"ecom.properties";

        Properties prop=new Properties();
        try
        {
            FileReader reader = new FileReader(filePath);

            prop.load(reader);
        } catch (FileNotFoundException e)
        {
            System.out.println("file not found");
        }
        catch (IOException e)
        {
            System.out.println("IOException");

        }
        return prop.getProperty(data);

    }
    public static WebDriver lunchDriver(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }



}



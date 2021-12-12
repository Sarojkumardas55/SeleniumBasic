package selenium.org;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.WebDriverManagerException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumTest {

    //static WebDriver driver=new ChromeDriver();

   /* public static void main(String[] args) {
        test();
        preTest();
        proTest();
    }
    @AfterTest
    static void proTest() {

    }
    @Test
    static void test() {

    }
    @BeforeTest

    }

}*/
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://flipkart.com/");
        driver.manage().window().maximize();
        //driver.findElement(By.linkText(""))
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/input[1]")).sendKeys("sarojkumardas55@gmail.com");
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[2]/input[1]")).sendKeys("saroj@55");
        driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[4]/button[1]")).click();
        driver.findElement(By.cssSelector("input._3704LK")).sendKeys("mobiles");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button.L0Z3Pu")).click();
        driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[2]/div[1]/div[1]")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1= s1.iterator();
        while (i1.hasNext())
        {
            String childWindow= i1.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                //driver.findElement(By.xpath("//input[@class='_36yFo0']")).clear();
               // driver.findElement(By.xpath("//input[@class='_36yFo0']")).sendKeys("751002");
                driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")).click();
                driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
                //driver.findElement(By.xpath("//button[contains(text(),'Deliver Here')]")).click();
                driver.findElement(By.xpath("//button[contains(text(),'CONTINUE')]")).click();
                driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/label[1]/div[1]")).click();
                driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/label[1]/div[2]/div[1]/div[1]/div[3]/label[1]/div[1]")).click();
                driver.findElement(By.xpath("//span[contains(text(),'CONTINUE')]")).click();
                driver.findElement(By.cssSelector("#mobileNumber")).sendKeys("8270782949");
                driver.findElement(By.cssSelector("#onboardingFormSubmitBtn")).click();
                driver.findElement(By.xpath("//input[@id='otp']")).sendKeys("52891");
                driver.findElement(By.xpath("//button[@id='onboardingFormSubmitBtn']")).click();
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);
       /* driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/button[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Deliver Here')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'CONTINUE')]")).click();
        driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/label[1]/div[1]")).click();
        driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/label[1]/div[2]/div[1]/div[1]/div[3]/label[1]/div[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'CONTINUE')]")).click();
        driver.findElement(By.cssSelector("#mobileNumber")).sendKeys("8270782949");
        driver.findElement(By.cssSelector("#onboardingFormSubmitBtn")).click();*/



        //driver.quit();
        System.out.println("sucessfully open flipkart");
    }

}
//driver.findElement(By.cssSelector("button[class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
//driver.findElement(By.cssSelector("button._2KpZ6l _2ObVJD _3AWRsL")).click();
//driver.findElement(By.cssSelector("button._2KpZ6l RLM7ES _3AWRsL")).click();
//driver.findElement(By.cssSelector("button._2KpZ6l _1seccl _3AWRsL")).click();

//driver.findElement(By.xpath("//div[contains(text(),'Mobiles')]")).click();
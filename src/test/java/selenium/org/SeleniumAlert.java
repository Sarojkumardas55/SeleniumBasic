package selenium.org;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");
        driver.findElement(By.xpath("//tbody//tr[2]//td[2]/input")).sendKeys("54321");
        driver.findElement(By.name("submit")).click();
        Alert alert=driver.switchTo().alert();

        String message=driver.switchTo().alert().getText();
        System.out.println(message);
        Thread.sleep(5000);

        //alert.accept();
        alert.accept();
       // alert.dismiss();
    }
}

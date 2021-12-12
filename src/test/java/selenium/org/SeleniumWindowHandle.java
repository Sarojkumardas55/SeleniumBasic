package selenium.org;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SeleniumWindowHandle {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
        String mainWindow = driver.getWindowHandle();
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1= s1.iterator();
        while (i1.hasNext())
        {
            String childWindow = i1.next();
            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);
                driver.findElement(By.xpath("//tbody/tr[5]/td[2]/input")).sendKeys("saroj@gmail.com");
                driver.findElement(By.xpath("//tbody/tr[6]/td[2]/input")).click();
                driver.close();
            }
        }
        driver.switchTo().window(mainWindow);


    }
}

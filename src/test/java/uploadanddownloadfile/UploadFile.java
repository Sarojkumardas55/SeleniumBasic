package uploadanddownloadfile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://demo.guru99.com/test/upload/");
        driver.findElement(By.xpath("//input[@id='uploadfile_0']")).sendKeys("D:\\file1.txt");
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        driver.findElement(By.xpath("//button[@id='submitbutton']")).click();

    }
}

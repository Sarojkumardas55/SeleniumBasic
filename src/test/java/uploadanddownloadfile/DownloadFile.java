package uploadanddownloadfile;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class DownloadFile {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        String downloadFilePath = "//D//Download";
        HashMap<String,Object> chromePref= new HashMap<String,Object>();
        chromePref.put("profile.default_content_settings.pupups",0);
        chromePref.put("download.default_directory",downloadFilePath);
        ChromeOptions options=new ChromeOptions();
        options.setExperimentalOption("pref",chromePref);

        WebDriver driver=new ChromeDriver(options);
        driver.get("http://demo.borland.com/testsite/download_testpage.php");
        driver.findElement(By.xpath("//span[contains(text(),'Download')]")).click();
        driver.close();

    }
}

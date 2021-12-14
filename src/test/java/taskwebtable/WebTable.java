package taskwebtable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
        List rows_table = table.findElements(By.tagName("tr"));
        int rows_count = rows_table.size();
        System.out.println("Toatl no of row " + rows_count);
        List colum_table = table.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[1]/td"));
        int collum_count = colum_table.size();
        System.out.println("Total no of column " + collum_count);
        List column1 = table.findElements(By.tagName("th"));
        int table_header = column1.size();
        System.out.println("Stracture value is " + table_header);
        String value =driver.findElement(By.xpath("//td[contains(text(),'4 buildings')]")).getText();
        System.out.println("Value of total column "+value);

        for (int k = 1; k <= table_header; k++) {
            String Hearer = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[" + k + "]")).getText();
            System.out.println(Hearer);
        }
            for (int i = 1; i <=rows_count;i++){


            for (int j = 1; j <=collum_count;j++) {


                String Table_data = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[" + i + "]/td[" + j + "]")).getText();

                System.out.print(" "+Table_data + " ");

            }

            //System.out.println("");
            System.out.println("");


        }
        for (int row=1;row <=rows_count;row++){
            String Hight =driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+row+"]/td[3]")).getText();
            String Name=driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr["+row+"]/th")).getText();
            System.out.println(Name+" Hight is "+Hight);
        }

    }
}


package taskwebtable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {
    public static WebDriver driver;
    //public static table_header;
    WebElement table = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));
    List rows_table = table.findElements(By.tagName("tr"));
    int rows_count = rows_table.size();
      //  System.out.println("Toatl no of row " + rows_count);
    List colum_table = table.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[1]/td"));
    int collum_count = colum_table.size();
      //  System.out.println("Total no of column " + collum_count);
    List column1 = table.findElements(By.tagName("th"));
    int table_header = column1.size();

    public static void main(String[] args) {

        driverSetup();
        WebTable webTable=new WebTable();
        webTable.assignment1();
        webTable.assignment2();
        webTable.assignment3();
        assignment4();



    }
    public static void driverSetup() {
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
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
    }
    public  void assignment1() {
        System.out.println("assignment 1");
        System.out.println(" ");

        System.out.println("Stracture value is " + table_header);
        String value = driver.findElement(By.xpath("//td[contains(text(),'4 buildings')]")).getText();
        System.out.println("Value of total column " + value);
    }
    public void assignment2() {
        System.out.println("Assignment 2");
        System.out.println(" ");

        for (int k = 1; k <= table_header; k++) {
            String Hearer = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[" + k + "]")).getText();
            System.out.println(Hearer);
        }
        for (int i = 1; i <= rows_count; i++) {


            for (int j = 1; j <= collum_count; j++) {


                String Table_data = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody//tr[" + i + "]/td[" + j + "]")).getText();

                System.out.print(" " + Table_data + " ");

            }

            //System.out.println("");
            System.out.println("");


        }
    }
    public void assignment3() {
        System.out.println("Assignment 3");
        System.out.println(" ");
        for (int row = 1; row <= rows_count; row++) {
            String Hight = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + row + "]/td[3]")).getText();
            String Name = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody/tr[" + row + "]/th")).getText();
            System.out.println(Name + " Hight is " + Hight);
        }
    }
    public static void assignment4(){
        System.out.println("Assignment 4");
        System.out.println(" ");

        List lastRow=driver.findElements(By.xpath("//tfoot/tr/*"));
        int lastRowColumn= lastRow.size();
        if(lastRowColumn==2) {
            System.out.println("Last row have " + lastRowColumn + "nos of columns");
        }else {
            System.out.println("Last row have not 2 column");
            }

    }
}


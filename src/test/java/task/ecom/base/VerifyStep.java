package task.ecom.base;

import demoQaSite.UserAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.*;

public class VerifyStep {
    public static boolean verifyPageTitle(String expectedTitle) {
        String actualTitle = Utility.getPageTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("true");
            //Login.appLogin();
            //Login.appLoginDemo();
            return true;
        }
        System.out.println("false");

        return false;

    }
    public static void verifyAllItem(List list,String expSearch){
        List<WebElement> links =list;//driver.findElements(By.xpath("//h5[@itemprop='name']//a"));
        for (int index=0;index< links.size();index++){
            WebElement ele= links.get(index);
            String title=ele.getText();
            System.out.println(title);

            if ( title.toLowerCase().indexOf(expSearch.toLowerCase()) != -1 ) {

                System.out.println("product is "+expSearch);

            } else {

                System.out.println("product is not "+expSearch);

            }
        }
    }
    public static double getLowestPriceItem(List list){
        List<WebElement> price=list;
        List<Double> checkbox = new ArrayList<>();
        for (int index=0;index< price.size();index++){
            WebElement ele= price.get(index);
            String priceofitem=ele.getText();
            priceofitem=priceofitem.replace("$","");

            double newPrice = Double.parseDouble(priceofitem);
            //System.out.println(newPrice);
            checkbox.add(newPrice);

        }
        double min = checkbox.stream().min(Comparator.naturalOrder()).get();
        System.out.println("lowest price = $"+min);
        return min;
    }
    public static void getLowestPriceItemDetails(List list1,List list2,String exp){
        List<WebElement> list_of_products =list1;
        List<WebElement> list_of_products_price =list2;
        //Use of HashMaop to store Products and Their prices
        String productName ="";
        String productPrice="";
        double lowPrice = Double.MAX_VALUE;
        double Price = 0;

        HashMap<Double,String> map_final_products = new HashMap<Double,String>();
        for(int index=0;index<list_of_products.size();index++) {
            String productNameTemp = list_of_products.get(index).getText();//Iterate and fetch product name
            String productPriceTemp = list_of_products_price.get(index).getText();//Iterate and fetch product price
            productPriceTemp=productPriceTemp.replace("$","");
            if ( productNameTemp.toLowerCase().indexOf(exp.toLowerCase()) != -1 ) {
                double newPrice = Double.parseDouble(productPriceTemp);

                if (newPrice < lowPrice){
                    lowPrice = newPrice;
                    productName = productNameTemp;
                    productPrice = productPriceTemp;
                }
            }
             Price = Double.parseDouble(productPrice);

            map_final_products.put(Price,productName);
        }
        //System.out.println("all data in map "+map_final_products.toString());
        //System.out.println(productName+productPrice);

        System.out.println("Low Product Price in "+exp+" item is: $" + Price + " Product name is: " + map_final_products.get(Price));
    }
   /* public static void grtLowest(List lsit1,List list2,String str){
        List<WebElement> list_of_products =lsit1; //driver.findElements(By.xpath("//div[@class='_3wU53n']"));
        List<WebElement> list_of_products_price =list2;// driver.findElements(By.xpath("//div[@class='_1vC4OE _2rQ-NK']"));

        //Use of HashMaop to store Products and Their prices(after conversion to Integer)
        String product_name;
        String product_price = null;
        double int_product_price;
        HashMap<Double, String> map_final_products = new HashMap<Double,String>();
        for(int i=0;i<list_of_products.size();i++) {
            product_name = list_of_products.get(i).getText();
            if(product_name.toLowerCase().indexOf(str.toLowerCase()) != -1)
            product_price = list_of_products_price.get(i).getText();
            product_price=product_price.replace("$","");

            double newPrice = Double.parseDouble(product_price);


            map_final_products.put(newPrice,product_name);

        }
        System.out.println("all data in map "+map_final_products.toString() );

        Set<Double> allkeys = map_final_products.keySet();
        ArrayList<Double> array_list_values_product_prices = new ArrayList<Double>(allkeys);

        Collections.sort(array_list_values_product_prices);

        //Highest Product is
        double high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);

        //Low price is
        double low_price = array_list_values_product_prices.get(0);
        System.out.println("Low Product Price in all item is: $" + low_price + " Product name is: " + map_final_products.get(low_price));

    }*/
}

/**
*
* @author Gizem Yiğit ve gizem.yigit2@ogr.sakarya.edu.tr
* @since 20.05.2023
* <p>
* aranan ürünün fiyatlarını yüksekten düşüğe sırala işlemini kontrol eden sınıftır
* </p>
*/

package pkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PriciesPage {

    
	public static void PriceListTest(WebDriver driver) {
		
		WebElement searchbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
	    
	    searchbox.sendKeys("iphone 12");
	    
	    driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		
		driver.findElement(By.xpath("//span[@class=\"a-button a-button-dropdown a-button-small\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"s-result-sort-select_2\"]")).click();
		
		//fiyatlar yüksekten düşüğe sıralanacak şekilde filtrelenir.
		List<WebElement> product_price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		//bulunacak fiyatları tutan bir dizi oluşturduk.
		List<Double> prices = new ArrayList<>();
		
		for(WebElement productprice: product_price) {
			//WebElement cinsinden bulunan fiyatlar double formatta olacak şekilde güncellenir ve prices dizisine atanır
			
			String priceText = productprice.getText().replaceAll("[^0-9.]", "");
            
			double price = Double.parseDouble(priceText);
            
			prices.add(price);
	
		}
		//Fiyatları kontrol etmek için sıraladık
		List<Double> sortedPrices = new ArrayList<>(prices);
        
		Collections.sort(sortedPrices);

        // Sıralama kontrolü yaptık
        boolean isSorted = prices.equals(sortedPrices);

        if (isSorted) {
            System.out.println("Ürünler yüksek fiyattan düşük fiyata doğru sıralanmıştır.");
        } 
        else {
            System.out.println("Ürünler yüksek fiyattan düşük fiyata doğru sıralanmamıştır.");
        }
        driver.navigate().refresh();
	}

}

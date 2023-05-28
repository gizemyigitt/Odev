/**
*
* @author Gizem Yiğit ve gizem.yigit2@ogr.sakarya.edu.tr
* @since 20.05.2023
* <p>
* seçilen ürünün detay sayfasının açılıp açılmadığını kontrol eden sınıftır
* </p>
*/

package pkt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DetailPage {

	public void DetailPageTest(WebDriver driver) throws InterruptedException {
		
		WebElement searchbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
	       
	    searchbox.sendKeys("iphone 12");
        
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        
        WebElement productname = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]"));
		
		
		
		String expectedTitle ="Amazon.com.tr : iphone 12";
		
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
		Thread.sleep(3000);
		
		WebElement link = driver.findElement(By.partialLinkText("Apple 2021 iPad Pro (12.9 inç, Wi-Fi + Cellular, 2 TB) - Gümüş Rengi (5. nesil)"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", link);
		
		String productTitle = driver.findElement(By.id("productTitle")).getText();
		//System.out.println(productTitle);
		
		if(productTitle.equals("Apple 2021 iPad Pro (12.9 inç, Wi-Fi + Cellular, 2 TB) - Gümüş Rengi (5. nesil)")) {
			
			System.out.println("Ürün seçilmiştir.");
			System.out.println("Ürünün detay sayfası açılmıştır.");
		}
		
				
	}
	
	
}



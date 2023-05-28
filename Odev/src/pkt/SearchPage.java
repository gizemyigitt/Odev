/**
*
* @author Gizem Yiğit ve gizem.yigit2@ogr.sakarya.edu.tr
* @since 20.05.2023
* <p>
* searchbox a yazılan ürünü aratan ve bunu kontrol eden sınıftır
* </p>
*/

package pkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public static void SearchTest(WebDriver driver) {
		
		WebElement searchbox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
	       
	    searchbox.sendKeys("iphone 12");
        
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        
        WebElement productname = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/h1/div/div[1]/div/div/span[3]"));
		
		String pageTitle = driver.getTitle();
		
		String expectedTitle ="Amazon.com.tr : iphone 12";
		
		if(pageTitle.equals(expectedTitle)) {
			System.out.println("Arama sonuçları sayfası doğru bir şekilde açıldı.");
		}
		
		else {
            System.out.println("Arama sonuçları sayfası açılamadı veya başlık farklı.");
        }
		driver.navigate().refresh();
	}
}

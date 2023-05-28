/**
*
* @author Gizem Yiğit ve gizem.yigit2@ogr.sakarya.edu.tr
* @since 20.05.2023
* <p>
* sepete istenilen sayıda ürün ekledi mi sepet açıldı mı bunu kontrol eden sınıftır
* </p>
*/

package pkt;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddToCardPage {

	DetailPage detailpage = new DetailPage();
	
	public void AddToCardTest(WebDriver driver) throws InterruptedException {
	
	detailpage.DetailPageTest(driver);
	
	Select quantity = new Select(driver.findElement(By.id("quantity")));
	
	quantity.selectByValue("2");

	WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].click();", addToCartButton);
	
	driver.findElement(By.xpath("//*[@id=\"sw-gtc\"]/span/a")).click();
	
	String quantityindex = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
	
	
	if(quantityindex.equals("Ara toplam (2 ürün):")) {
		System.out.println("Seçilen ürün miktarı doğrudur ve sepete eklenmiştir.");
	}
	
	driver.navigate().refresh();
	
	
}
	
	
	
}

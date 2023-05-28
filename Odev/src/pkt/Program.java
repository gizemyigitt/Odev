/**
*
* @author Gizem Yiğit ve gizem.yigit2@ogr.sakarya.edu.tr
* @since 20.05.2023
* <p>
* login olma renk kontrolü ve çerezleri kabul eden testlerin olduğu ve konsolda seçim işleminin yapılacağı sınıftır
* </p>
*/

package pkt;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Program {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\seleniumserver\\ChromeDriver\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get("https://www.amazon.com.tr/");
	        driver.manage().window().maximize();
	        Scanner scanner = new Scanner(System.in);
	        int secim;
	        DetailPage detailpage = new DetailPage();
	        SearchPage searchpage = new SearchPage();
	        PriciesPage priciespage = new PriciesPage();
	        AddToCardPage addtocardpage= new AddToCardPage();
	        
	        do {
	        	System.out.println("----------------------------------------------");
	        	System.out.println("1. Çerezleri Kabul Et");
	            System.out.println("2. Header Rengi Kontrol Testi");
	            System.out.println("3. Arama Yapma Testi");
	            System.out.println("4. Filtre Uygulama İşlemi Testi");
	            System.out.println("5. Ürün Seçme Testi ve Detay Sayfası Testi");
	            System.out.println("6. Sepete Ürün Ekleme");
	            System.out.println("7. Login Testi");
	            System.out.println("0. Çıkış");
	            System.out.println("Seçiminizi yapın: ");
	            System.out.println("----------------------------------------------");
	            secim = scanner.nextInt();

	            switch (secim) {
	                case 1:
	                	popUpKapatmaTesti(driver);
	                	
	                    break;
	                case 2:
	                	HeaderColorTest(driver);	                	
	                    break;
	                case 3:
	                	searchpage.SearchTest(driver);
	                    break;
	                case 4:
	                	priciespage.PriceListTest(driver);
	                    break;
	                case 5:
	                	detailpage.DetailPageTest(driver);
	                    break;
	                case 6:
	                	addtocardpage.AddToCardTest(driver);
	                    break;
	                case 7:
	                	LoginTest(driver);
	                    break;
	                case 0:
	                    System.out.println("Çıkış yapılıyor...");
	                    driver.quit();
	                    break;
	                default:
	                    System.out.println("Geçersiz seçim!");
	                    break;
	            }
	            System.out.println();
	        } while (secim != 0);

	        scanner.close();
	        	        
	        
	}

	public static void HeaderColorTest(WebDriver driver) {
		WebElement header = driver.findElement(By.id("nav-logo-sprites"));
        String actualColor = header.getCssValue("color");

        String expectedColor = "rgb(0, 0, 255)"; // Beklenen renk: mavi

        if (actualColor.equals(expectedColor)) {
            System.out.println("Header rengi doğru.");
        } else {
            System.out.println("Header rengi yanlış. Beklenen renk: " + expectedColor + ", Gerçek renk: " + actualColor);
        }
		
	}

	public static void popUpKapatmaTesti(WebDriver driver) {
		 WebElement cookieAcceptButton = driver.findElement(By.id("sp-cc-accept"));
	        if (cookieAcceptButton.isDisplayed()) {
	            cookieAcceptButton.click();
	            System.out.println("Çerezler kabul edildi");
	        } else {
	            System.out.println("Çerezler görünmüyor");
	        }
		
	}


	public static void LoginTest(WebDriver driver) {
		WebElement signInButton = driver.findElement(By.id("nav-link-accountList"));
        signInButton.click();
        
        WebElement emailField = driver.findElement(By.id("ap_email"));
        emailField.sendKeys("gizem.y1883@gmail.com");
        
        // Devam butonuna tıklama
        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();
        
        WebElement passwordField = driver.findElement(By.id("ap_password"));
        passwordField.sendKeys("Gizem.18");
        
        WebElement signinbutton = driver.findElement(By.id("signInSubmit"));
        signinbutton.submit();
        
        WebElement userName = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        String username = userName.getText();
    
        String user="Gizem";
       
        if (username.equals(user)) {
            System.out.println("Login işlemi başarılı oldu. ");

        }
        else {
        	System.out.println("Login işlemi başarısız oldu.");
        	
        	
        }
        
		
	}

}

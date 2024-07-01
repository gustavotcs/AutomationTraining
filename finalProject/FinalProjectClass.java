package finalProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FinalProjectClass {
	WebDriver webDriver;
	
	//Login
	WebElement webElementLoginUserName;
	WebElement webElementLoginPassWord;
	WebElement webElementLoginSubmit;
	WebElement webElementLoginError;
	
	//Items
	List<WebElement> webElementItemsTotal;
	WebElement webElementItemsButtonCart;
	WebElement webElementTotalShoppingCart;
	
	//FirstStep
	WebElement webElementFirstStepButton;
	List<WebElement> webElementFirstStepPrice;
	
	//Address
	WebElement webElementAddressFirstName;
	WebElement webElementAddressLastName;
	WebElement webElementAddressPostalCode;
	WebElement webElementAddressContinueButton;
	WebElement webElementAddressError;
	
	//Checkout
	List<WebElement> webElementCheckoutItems;
	WebElement webElementCheckoutSubTotal;
	WebElement webElementCheckoutTax;
	WebElement webElementCheckoutTotal;
	WebElement webElementCheckoutContinue;
	
	//ThankYou
	WebElement webElementThankYouLabel;
	
	public FinalProjectClass() {
		init();
	}
	
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		
		ChromeOptions options = getOptions();
		webDriver = new ChromeDriver(options);
		
		webDriver.get("https://www.saucedemo.com/v1/");
		
		initLogin();
	}
	
	static ChromeOptions getOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		return options;
	}
	
	public void close() {
		webDriver.close();
	}
	
	public void initLogin() {
		webElementLoginUserName = webDriver.findElement(By.id("user-name"));
		webElementLoginPassWord = webDriver.findElement(By.id("password"));
		webElementLoginSubmit = webDriver.findElement(By.id("login-button"));
	}
	
	public void initItems() {
		webElementItemsTotal = webDriver.findElements(By.xpath("//button[contains(@class, 'btn_inventory')]"));
		webElementItemsButtonCart = webDriver.findElement(By.xpath("//a[contains(@class, 'shopping_cart_link')]"));
	}
	
	public void initFirstStep() {
		webElementFirstStepButton = webDriver.findElement(By.xpath("//a[contains(@class, 'btn_action')]"));
		webElementFirstStepPrice = webDriver.findElements(By.xpath("//div[contains(@class, 'inventory_item_price')]"));
	}
	
	public void initAddress() {
		webElementAddressFirstName = webDriver.findElement(By.id("first-name"));
		webElementAddressLastName = webDriver.findElement(By.id("last-name"));
		webElementAddressPostalCode = webDriver.findElement(By.id("postal-code"));
		webElementAddressContinueButton = webDriver.findElement(By.xpath("//input[contains(@class, 'cart_button')]"));
	}
	
	public void initCheckout() {
		webElementCheckoutItems = webDriver.findElements(By.xpath("//div[contains(@class, 'inventory_item_price')]"));
		webElementCheckoutSubTotal = webDriver.findElement(By.xpath("//div[contains(@class, 'summary_subtotal_label')]"));
		webElementCheckoutTax = webDriver.findElement(By.xpath("//div[contains(@class, 'summary_tax_label')]"));
		webElementCheckoutTotal = webDriver.findElement(By.xpath("//div[contains(@class, 'summary_total_label')]"));
		
		webElementCheckoutContinue = webDriver.findElement(By.xpath("//a[contains(@class, 'cart_button')]"));
	}
	
	public void initThankPage() {
		webElementThankYouLabel = webDriver.findElement(By.xpath("//h2[contains(@class, 'complete-header')]"));
	}
	
	public String loginPage(String userName, String password) {
		String session = "";
		
		webElementLoginUserName.sendKeys(userName);
		webElementLoginPassWord.sendKeys(password);
		
		webElementLoginSubmit.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			webElementLoginError = webDriver.findElement(By.xpath("//h3[contains(@data-test, 'error')]"));
			session = webElementLoginError.getText();
		} catch (Exception e) {
			session = "Success login";
		}
		
		return session;
	}
	
	public int itemsPageRandom(int elements) {
		initItems();
		
		int itemsAdded = 0;
		if(webElementItemsTotal.size() > 0) {
			Random random = new Random();
			
			if(elements > webElementItemsTotal.size()) {
				elements = webElementItemsTotal.size();
			}
			
			for(int i = 0; i < elements; i++) {
				WebElement webElementItemSelected = webElementItemsTotal.get(random.nextInt(webElementItemsTotal.size()));
				if(webElementItemSelected.getText().equalsIgnoreCase("remove")) {
					i--;
					continue;
				} else {
					webElementItemSelected.click();
				}
			}
			
			try {
				webElementTotalShoppingCart = webDriver.findElement(By.xpath("//span[contains(@class, 'shopping_cart_badge')]"));
				itemsAdded = Integer.parseInt(webElementTotalShoppingCart.getText());
			} catch (Exception e) {
				System.out.println("No item added");
				itemsAdded = 0;
			}
		}
		
		return itemsAdded;
	}
	

	public int itemsPage(List<Integer> elements) {
		initItems();
		
		int itemsAdded = 0;
		ArrayList<Integer> indexItem = new ArrayList<Integer>();
		
		if(webElementItemsTotal.size() > 0) {			
			for(int i = 0; i < elements.size(); i++) {
				if(elements.get(i) > webElementItemsTotal.size()) {
					indexItem.add(webElementItemsTotal.size() - 1);
				} else {
					indexItem.add(elements.get(i));
				}
			}
			
			for(int i = 0; i < indexItem.size(); i++) {
				WebElement webElementItemSelected = webElementItemsTotal.get(indexItem.get(i));
				if(webElementItemSelected.getText().equalsIgnoreCase("remove")) {
					continue;
				} else {
					webElementItemSelected.click();
				}
			}
			
			try {
				webElementTotalShoppingCart = webDriver.findElement(By.xpath("//span[contains(@class, 'shopping_cart_badge')]"));
				itemsAdded = Integer.parseInt(webElementTotalShoppingCart.getText());
			} catch (Exception e) {
				System.out.println("No item added");
				itemsAdded = 0;
			}
		}
		
		return itemsAdded;
	}
	
	public double firstStep() {
		webElementItemsButtonCart.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initFirstStep();
		
		double totalPrice = 0;
		
		for(int i = 0; i < webElementFirstStepPrice.size(); i++) {
			totalPrice += Double.parseDouble(webElementFirstStepPrice.get(i).getText().replace("$", ""));
		}
		
		return totalPrice;
	}
	
	public String addAddress(String firstName, String lastName, String postalCode) {
		webElementFirstStepButton.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		initAddress();
		
		webElementAddressFirstName.sendKeys(firstName);
		webElementAddressLastName.sendKeys(lastName);
		webElementAddressPostalCode.sendKeys(postalCode);
		
		webElementAddressContinueButton.click();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String success = "";
		try {
			webElementAddressError = webDriver.findElement(By.xpath("//h3[contains(@data-test, 'error')]"));
			success = webElementAddressError.getText();
		} catch (Exception e) {
			success = "Address saved successfully";
		}
		
		return success;
	}
	
	public double checkout() {
		initCheckout();
		
		return Double.parseDouble(webElementCheckoutTotal.getText().replace("$", "").replace("Total: ", ""));
	}
	
	public String thankYou() {
		webElementCheckoutContinue.click();
		
		initThankPage();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return webElementThankYouLabel.getText();
	}
}

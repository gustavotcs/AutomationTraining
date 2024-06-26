package session8;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumClass {
	
	static String firstName = "";
	static String secondName = "";
	static String jobTitle = "";
	static int schoolLevel = 0;
	static int sexOption = 0;
	static int yearsExperience = 0;
	static String date = "";

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Ingresa el nombre");
		firstName = scanner.next();
		
		System.out.println("Ingresa el segundo nombre");
		secondName = scanner.next();
		
		System.out.println("Ingresa tu cargo");
		jobTitle = scanner.next();
		
		System.out.println("Highest level of education\n1) HighSchool\n2) College\n3) Grad School");
		schoolLevel = scanner.nextInt();
		
		System.out.println("Which your sex?\n1) Male\n2) Female\n3) Prefer not to say");
		sexOption = scanner.nextInt();
		
		System.out.println("What is your experience on years?\n1) 0-1\n2)2-4\n3)5-9\n4)10+");
		yearsExperience = scanner.nextInt();
		
		System.out.println("What's your birth of day? (mm/dd/yyyy)");
		date = scanner.next();
		
		try {
			System.out.println("Uploading info..... Wait!");
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
		// TODO Auto-generated method stub
		
		ChromeOptions options = getOptions();
		WebDriver webdriver = new ChromeDriver(options);
		
		webdriver.get("https://formy-project.herokuapp.com/form");
		
		WebElement webElementFirstName = webdriver.findElement(By.id("first-name"));
		webElementFirstName.sendKeys(firstName);
		
		WebElement webElementLastName = webdriver.findElement(By.id("last-name"));
		webElementLastName.sendKeys(secondName);
		
		WebElement webElementJobTitle = webdriver.findElement(By.id("job-title"));
		webElementJobTitle.sendKeys(jobTitle);
		
		WebElement webElementSchoolLevelHighSchool = webdriver.findElement(By.id("radio-button-1"));
		WebElement webElementSchoolLevelCollege = webdriver.findElement(By.id("radio-button-2"));
		WebElement webElementSchoolLevelGradSchool = webdriver.findElement(By.id("radio-button-3"));
		
		switch(schoolLevel) {
			case 1:
				webElementSchoolLevelHighSchool.click();
				break;
			case 2:
				webElementSchoolLevelCollege.click();
				break;
			default:
				webElementSchoolLevelGradSchool.click();
				break;
		}
		
		WebElement webElementSexMale = webdriver.findElement(By.id("checkbox-1"));
		WebElement webElementSexFemale = webdriver.findElement(By.id("checkbox-2"));
		WebElement webElementSexPreferNotSay = webdriver.findElement(By.id("checkbox-3"));
		
		switch(sexOption) {
			case 1:
				webElementSexMale.click();
				break;
			case 2:
				webElementSexFemale.click();
				break;
			default:
				webElementSexPreferNotSay.click();
				break;
		}
		
		WebElement webElementYears = webdriver.findElement(By.id("select-menu"));
		Select selectYears = new Select(webElementYears);
		//List<WebElement> optionList = selectYears.getOptions();
		selectYears.selectByValue(""+yearsExperience);
		
		WebElement webElementDate = webdriver.findElement(By.id("datepicker"));
		webElementDate.sendKeys(date);
		webElementDate.sendKeys(Keys.RETURN);
		
		WebElement webElementSubmit = webdriver.findElement(By.xpath("//a[@href='/thanks']"));
		webElementSubmit.click();
		
	}

	static ChromeOptions getOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		return options;
	}
}

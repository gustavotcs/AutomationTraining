package finalProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

class FinalProjectTest {
	
	FinalProjectClass finalProjectClass = new FinalProjectClass();
	
	@Ignore
	private void init() {
		finalProjectClass = new FinalProjectClass();
	}
	
	@Ignore
	private String login(String username, String password) {
		return finalProjectClass.loginPage(username, password);
	}

	@Ignore
	private int getItemsRandom(int itemsToBuy) {
		return finalProjectClass.itemsPageRandom(itemsToBuy);
	}

	@Ignore
	private int getItems(ArrayList<Integer> itemsToBuy) {
		return finalProjectClass.itemsPage(itemsToBuy);
	}
	
	@Ignore
	private double getFirstStep() {
		return finalProjectClass.firstStep();
	}
	
	@Ignore
	private String getAddress(String firstName, String lastName, String postalCode) {
		return finalProjectClass.addAddress(firstName, lastName, postalCode);
	}
	
	@Ignore
	private double calculateTaxes(double totalValue) {
		double tax = 8.0;
		double result = tax * totalValue; 
		return Double.parseDouble(String.format("%.2f", result));
	}
	
	@Ignore
	private double getCheckout() {
		return finalProjectClass.checkout();
	}
	
	@Ignore
	private String getThankYou() {
		return finalProjectClass.thankYou();
	}
	
	@Ignore
	void closeProject() {
		finalProjectClass.close();
	}
	
	@Test
	void testLoginPage() throws Exception {	
		String estimatedLogin = "Success login";
		
		String resultLogin = login("standard_user", "secret_sauce");
		assertEquals(resultLogin, estimatedLogin);
				
		Thread.sleep(1000);
		
		closeProject();
	}
	
	@Test
	void testItemsPage() throws Exception {
		int itemsToGet = 3;
		
		login("standard_user", "secret_sauce");
		
		int resultItemAdded = getItemsRandom(itemsToGet);
		assertEquals(itemsToGet, resultItemAdded);
				
		Thread.sleep(1000);
		
		closeProject();
	}
	
	@Test
	void testFirstStep() throws Exception {
		double estimatedPrice = 55.97;
		ArrayList<Integer> itemsToGet = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
		
		login("standard_user", "secret_sauce");
		getItems(itemsToGet);
		
		double resultFirstStep = getFirstStep();
		assertEquals(estimatedPrice, resultFirstStep);		
		
		Thread.sleep(1000);
		
		closeProject();
	}
	
	@Test
	void testAddress() throws Exception {
		String estimatedAddress = "Address saved successfully";
		int itemsToGet = 3;
		
		login("standard_user", "secret_sauce");	
		getItemsRandom(itemsToGet);
		getFirstStep();
		
		String resultAddress = getAddress("Gustavo", "Aguirre", "52924");
		assertEquals(estimatedAddress, resultAddress);
		
		Thread.sleep(1000);
		
		closeProject();
	}
	
	@Test
	void testCheckout() throws Exception {
		double estimatedTotal = 60.45;
		ArrayList<Integer> itemsToGet = new ArrayList<Integer>(Arrays.asList(0, 1, 2));
		
		login("standard_user", "secret_sauce");
		getItems(itemsToGet);
		getFirstStep();
		getAddress("Gustavo", "Aguirre", "52924");
		
		double resultTotal = getCheckout();
		assertEquals(estimatedTotal, resultTotal);
		
		Thread.sleep(1000);
		
		closeProject();
	}
	
	@Test
	void testThankYou() throws Exception {
		String estimatedMessage = "THANK YOU FOR YOUR ORDER";
		int itemsToGet = 3;
		
		login("standard_user", "secret_sauce");	
		getItemsRandom(itemsToGet);
		getFirstStep();
		getAddress("Gustavo", "Aguirre", "52924");
		getCheckout();
		
		String resultMessage = getThankYou();
		assertEquals(estimatedMessage.toLowerCase(), resultMessage.toLowerCase());
		
		Thread.sleep(1000);
		
		closeProject();
	}
}

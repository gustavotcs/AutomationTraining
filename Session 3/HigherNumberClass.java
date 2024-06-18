import java.util.Scanner;

public class HigherNumberClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input first number: ");
		int num1 = scanner.nextInt();
		
		System.out.println("Input second number: ");
		int num2 = scanner.nextInt();
		
		System.out.println("Input third number: ");
		int num3 = scanner.nextInt();
		
		int greatestNumber = getGreatestNumber(num1, num2, num3);
		
		System.out.println("The greatest number from ["+num1+", "+num2+", "+num3+"] is: " + greatestNumber);
		
	}
	
	static int getGreatestNumber(int num1, int num2, int num3) {
		int greatestNumber = num1;
		
		if(greatestNumber < num2) {
			greatestNumber = num2;
		}
		
		if(greatestNumber < num3) {
			greatestNumber = num3;
		}
		
		return greatestNumber;
	}

}

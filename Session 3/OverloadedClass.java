import java.util.Scanner;

public class OverloadedClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input first number: ");
		int num1 = scanner.nextInt();
		
		System.out.println("Input second number: ");
		int num2 = scanner.nextInt();//"2" -> "23"
		
		System.out.println("Input third number: ");
		int num3 = scanner.nextInt();//"3"
		
		System.out.println("Input fourth number: ");
		String num4 = scanner.nextLine();//"45, "o2"

		if(scanner.hasNextLine()) {
			num4 = scanner.nextLine();
		} else {
			num4 = null;
		}
		
		if(num4.isEmpty()) {
			onlyThreeNumbersFunctions(num1, num2, num3);
		} else {
			try {
				int numNew = Integer.parseInt(num4);
				int greatestNumber = getGreatestNumber(num1, num2, num3, numNew);
				System.out.println("The greatest number from [" + num1 + ", " + num2 + ", " + num3 + ", " + numNew + "] is: " + greatestNumber);
			} catch (Exception e) {
				System.out.println("The fourth number was expected but we found a non-number, only take the three numbers");
				onlyThreeNumbersFunctions(num1, num2, num3);
			}
		}		
	}
	
	static void onlyThreeNumbersFunctions(int num1, int num2, int num3) {
		int greatestNumber = getGreatestNumber(num1, num2, num3);
		System.out.println("The greatest number from [" + num1 + ", " + num2 + ", " + num3 + "] is: " + greatestNumber);
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
	
	static int getGreatestNumber(int num1, int num2, int num3, int num4) {
		int greatestNumber = num1;
		
		if(greatestNumber < num2) {
			greatestNumber = num2;
		}
		
		if(greatestNumber < num3) {
			greatestNumber = num3;
		}
		
		if(greatestNumber < num4) {
			greatestNumber = num4;
		}
		
		return greatestNumber;
	}
}

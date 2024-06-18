import java.util.Scanner;

public class FibonacciClass {

	public static void main(String[] args) {		
		System.out.println("Input a number");
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		printFibonacciNum(num);
	}

	static void printFibonacciNum(int count) {
		int n1 = 0, n2 = 1, n3 = 0;
		
		System.out.print("Result of printFibonacci: ");
		for(int i = 0; i < count; i++) {
			n3 = n1 + n2;
			
			if(count - 1 == i) {
				System.out.print(n3 + "");
			} else {
				System.out.print(n3 + ", ");
			}
			
			n1 = n2;
			n2 = n3;
		}
	}
}

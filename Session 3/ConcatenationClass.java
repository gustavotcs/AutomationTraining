
public class ConcatenationClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "hot", str2 = "dog";
		String result = getConcatenate(str1, str2);
		
		System.out.println("Result of Strings: " + result);
	}
	
	static String getConcatenate(String str1, String str2) {
		String str3 = "";
		str3 = str1 + str2;
		return str3;
	}

}

import java.util.Random;

public class Student {
	
	int StudentID = 0;
	String firstName = "";
	String middleName = "";
	String lastName = "";
	String dateOfBirth = "";
	
	public Student(String firstName, String middleName, String lastName, String dateOfBirth) {
		Random random = new Random();
		
		this.StudentID = random.nextInt(1000);
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}
	
	private String getFullName() {
		String fullName = "";
		
		if(!this.firstName.isEmpty()) {
			fullName = this.firstName;
		}
		
		if(!this.middleName.isEmpty()) {
			if(!fullName.isEmpty()) {
				fullName += " " + this.middleName;
			} else {
				fullName = this.middleName;
			}
		}
		
		if(!this.lastName.isEmpty()) {
			if(!fullName.isEmpty()) {
				fullName += " " + this.lastName;
			} else {
				fullName = this.lastName;
			}
		}
		
		return fullName;
	}
	
	public void displayInformationStudent() {
		System.out.println("Information Student with ID: " + this.StudentID);
		System.out.println("Name: " + getFullName());
		System.out.println("Date of Birth: " + this.dateOfBirth);
		System.out.println("-------------------------------------");
	}
}


public class School {

	public static void main(String args[]) {
		Student student1 = new Student("Gustavo", "Angel", "Aguirre", "20-07-1996");
		Student student2 = new Student("Melisa", "Robles", "Perez", "21-05-1986");
		Student student3 = new Student("Hugo", "", "Quintanar", "02-09-1976");
		
		student1.displayInformationStudent();
		student2.displayInformationStudent();
		student3.displayInformationStudent();
	}
}

package unit2;

public class TestStudent {

    public static void main(String[] args) {
	Student s1 = new Student("Tom Harris");
	Student s2 = new Student("Tim Davis", 12345);
	s1.setGrade("A-");
	//s1.setGrade(3.00);//Does not work; method private and we are outside of Student class
	s1.setGrade("B");

	System.out.println(s1.getName());
	//System.out.println(s1.sid());//Does not work; sid not a method; no paranthesis needed
	System.out.println(s1.sid);
	System.out.println(s1.getGPA());

	//System.out.println(Student.getGPA());//Does not work; getGPA
	//not a static method; whose GPA are you talking about?
	
	//System.out.println(s2.name);//Does not work; name is private
	System.out.println(s2.getName());
	System.out.println(s2.sid);
	System.out.println(s2.getGPA());


	System.out.println(Student.noOfStudents);//Example of
						 //accessing a class
						 //variable;
						 //paranthesis were
						 //needed if
						 //noOfStudents were a
						 //static method
						 //instead of a static
						 //(class) variable
	
    }
}
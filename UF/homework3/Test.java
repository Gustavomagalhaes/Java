package homework3;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
//		double[] array = {2.0, 1.0, 4.0, 3.0, 5.0, 6.0, 7.0};
//		System.out.println(Util.min(array));
//		System.out.println(Util.max(array));
//		System.out.println(Util.mean(array));
//		System.out.println(Util.median(array));
//		
//		Person gus = new Person("Gustavo");
//		System.out.println(gus.getName());
//		System.out.println(gus.calcBMI(270, 72));
//		gus.readFromKB();
		
		Person[] p = Student.readFile("/Users/gustavopereira/Documents/Eclipse/UF/src/homework3/data.txt");
		
	    System.out.println("Min, max, mean and median of BMI: " +
	        Arrays.toString((Person.getStats(p))));
	    
		System.out.println("Average GPA of class is: " + Student.calcAvgGPA(p));
	}

}

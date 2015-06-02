package unit2;

public class Student {

    public int sid = -1;
    private String name = null;
    private int noOfGrades = 0;
    private double[] grades = new double[100];
    public static int noOfStudents = 0;


    public Student(String s) {
	this.name = s;
	noOfStudents = noOfStudents + 1;
    }

    public Student(int a) {
	this.sid = a;       
	noOfStudents = noOfStudents + 1;
    }

    public Student(String s, int a) {
	this.name = s;
	this.sid = a;
	noOfStudents = noOfStudents + 1;
    }
    
    public String getName() {
      return this.name;
    }
       
    public void setSid(int a) {
	this.sid = a;
    }


    private double getValue(String g) {
	double val = 0;
	switch(g) {
	case "A": val = 4.00; break;
	case "A-": val = 3.66; break;
	case "A+": val = 3.33; break;
	case "B": val = 3.00; break;
	case "B-": val = 2.66; break;
	case "C": val = 2.00; break;
	case "D": val = 1.00; break;
	default: val = -1.00; break;
	}
	return val;
    }

    // private double getValue(String g) {
    // 	double val = 0;
    // 	if (g.equals("A"))
    // 	    val = 4.00;
    // 	else if (g.equals("B"))
    // 	    val = 3.00;
    // 	else if (g.equals("C"))
    // 	    val = 2.00;
    // 	else if (g.equals("D"))
    // 	    val = 1.00;
    // 	else {
    // 	    val = -1.0;
    // 	    System.out.println("Warning: invalid grade");		 
    // 	}
    // 	return val;
    // }
    


    public void setGrade(String g) {
	double v = getValue(g);
	if (v < 0)
	    System.out.println("Warning: grade not set.");
	else
	    setGrade(v);
    }

    private void setGrade(double d) {
	if (noOfGrades < this.grades.length) {
	    noOfGrades = noOfGrades + 1;
	    this.grades[noOfGrades - 1] = d;
	}
      else
        System.out.println("Warning: the grade not set");
    }
   
    public double getGPA() {
      double sum = 0;
      for (int i = 0; i < noOfGrades; i++)
        sum = sum + grades[i];
      
      if (noOfGrades == 0)
	  return 0.0;
      else
	  return sum/noOfGrades;
    }

}

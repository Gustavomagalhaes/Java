package homework3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Student extends Person {

    public int sid = -1;
    private int noOfGrades = 0;
    private double[] grades = new double[100];
    public static int noOfStudents = 0;

    public Student(String s, int id) {
    	super(s);
    	this.sid = id;
    	noOfStudents = noOfStudents + 1;
    }
    
    public Student(String s, int id, int weight, int height) {
    	super(s, weight, height);
    	this.sid = id;
    	noOfStudents = noOfStudents + 1;
    }

    private double getValue(String g) {
	double val = 0;
	switch(g) {
	case "A+": val = 4.00; break;
	case "A": val = 3.66; break;
	case "A-": val = 3.33; break;
	case "B+": val = 3.00; break;
	case "B": val = 2.66; break;
	case "B-": val = 2.33; break;
	case "C+": val = 2.00; break;
	case "C": val = 1.66; break;
	case "C-": val = 1.33; break;
	case "D+": val = 1.00; break;
	case "D": val = 0.66; break;
	case "D-": val = 0.33; break;
	default: val = -1.00; break;
	}
	return val;
    }

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
    
    public double calcAvgGPA(Student[] arr) {
    	return Student.getAveGPA(arr);	
    }
    
    public static double calcAvgGPA(Person[] arr) {
    	double[] AllGPAs = new double[arr.length];
    	for (int i=0; i < arr.length; i++) {
    		AllGPAs[i] = ((Student) arr[i]).getGPA();
    	}
    	return Util.mean(AllGPAs);
    }
    
    public static Person[] readFile(String filename) {
    	String content = null;
    	File file = new File(filename);
    	try {
    		FileReader reader = new FileReader(file);
    	      char[] chars = new char[(int) file.length()];
    	       reader.read(chars);
    	       content = new String(chars);
    	       reader.close();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	String[] splits = content.split("\n");
    	Person[] p = new Person[splits.length];
    	
    	for (int i=0; i < splits.length; i++) {
    		String[] splitline = splits[i].split(" ");
    		Student s1 = new Student(splitline[0]+" "+splitline[1], Integer.parseInt(splitline[2]),
    				Integer.parseInt(splitline[6]), Integer.parseInt(splitline[7]));
    		
    		s1.setGrade(splitline[3]);
    		s1.setGrade(splitline[4]);
    		s1.setGrade(splitline[5]);
    		p[i] = s1;
    	}
    	return p;
    }
    
    public static double getAveGPA(Student[] arr) {
    	double[] AllGPAs = new double[arr.length];
    	for (int i=0; i < arr.length; i++) {
    		AllGPAs[i] = arr[i].getGPA();
    	}
    	return Util.mean(AllGPAs);
    }

}

package homework3;
import java.util.Scanner;

public class Person {
	
    private String name;
    public int weight;
    public int height;

    public Person(String name) {
	this.name = name;
    }
    
    public Person(String name, int weight, int height) {
	this.name = name;
	this.weight = weight;
	this.height = height;
    }
	
	public String getName() {
		return name;
	}

	public double calcBMI(double weight, double height) {
		return (weight/Math.pow(height, 2))*703;
	}
	
	public void readFromKB() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String text = input.nextLine();
		while (text != "end") {
			String[] splits = text.split(" ");
			int weight = Integer.parseInt(splits[1]);
			int height = Integer.parseInt(splits[2]);
			
			System.out.println(this.calcBMI(weight, height));
			text = input.nextLine();
		}
	}
	
	public static double[] getStats(Person[] p) {
		double[] bmi = new double[p.length];
		for (int i=0; i < p.length; i++) {
			bmi[i] = p[i].calcBMI(p[i].weight, p[i].height);
		}
		
		double[] results = new double[4];
		results[0] = Util.min(bmi);
		results[1] = Util.max(bmi);
		results[2] = Util.mean(bmi);
		results[3] = Util.median(bmi);
		
		return results;
	}
}

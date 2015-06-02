package homework3;
import java.util.Arrays;

public class Util {
	
	
	public static double min(double[] array) {
		Arrays.sort(array);
		return array[0];
	}
	
	public static double max(double[] array) {
		Arrays.sort(array);
		return array[array.length-1];
	}
	
	public static double mean(double[] array) {
		double sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum/array.length;
	}
	
	public static double median(double[] array) {
		Arrays.sort(array);
		int middle = (array.length+1)/2;
		double median;
		if (array.length % 2 == 0) {
			median = (array[middle-1]+array[middle])/2.0;
		} else {
			median = array[middle-1];
		}
		return median;
	}
	
}

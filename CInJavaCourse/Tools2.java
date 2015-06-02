package ModelsCIn;

public class Tools2 {
	public static void main(String[] args){
		
		/* Arrays e loops */
		
//		int[] valores = new int[3];
//		String[] nomes = new String[3];
		
		int[] valores = {10,20,30};
//		String[] nomes = {"Gustavo","Daniel","Mario"};
		
		boolean google = false;
		int i = 0;
		
		/* WHILE */
		while (google == false && i < valores.length){
			if (valores[i] == 20){
				google = true;
			} else {
				i++;
			}
		}
		System.out.println(google);
		
		/* DO-WHILE */
		do {
			if (valores[i] == 20){
				google = true;
			} else {
				i++;
			}
		} while (google == false && i < valores.length);
		
		/* FOR */
		int[] lista = new int[10];
		for (int j = 0; j < lista.length; j++){
			lista[j] = j*2;
		}
		
		/* FOR (FOREACH) */
		for (int x: lista){
			System.out.println(x);
		}
		
		int[][] matrix = new int[3][3];
		int spot = 0;
		for (int m = 0; m < 3; m++){
			System.out.println();
			for (int n = 0; n < 3; n++){
				matrix[m][n] = spot++;
				System.out.print(matrix[m][n]+" ");
			}
		}
	}
}

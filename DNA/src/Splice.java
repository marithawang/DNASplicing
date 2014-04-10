import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		String[][] strand = new String[2][10];
		
		System.out.println("Original strand Sequence:");
		for (int i = 0; i<strand[0].length; i++){
			int baseNum = (int) (Math.random() * 4);
			String baseLet = "";
			switch(baseNum){
			case 0: baseLet = "A";
			break;
			case 1: baseLet = "T";
			break;
			case 2: baseLet = "C";
			break;
			case 3: baseLet = "G";
			}
			strand[0][i] = baseLet;
		}
		toHelix(strand);
		toDNA(strand);

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Sequence to Cut At:");
		System.out.println("For Example: \nG AAC \nCA TG");
		String input=scan.nextLine();

		splice(strand, input);
	}

	public static String[][] toHelix(String[][] strand) {
		for(int i = 0; i<strand[1].length; i++){
			String basePair = "";
			switch(strand[0][i]){
			case "A": basePair = "T";
			break;
			case "T": basePair = "A";
			break;
			case "C": basePair = "G";
			break;
			case "G": basePair = "C";
			break;
			}
			strand[1][i] = basePair;
		}
		return strand;
		// TODO Auto-generated method stub
		
	}

	public static String[][] splice(String[][] strand, String splitPos){
		return strand;

	}
	public String[][] transcribe(String[][] strand){
		return strand;

	}
	public String[][] translate(String[][] strand){
		return strand;

	}
	public static void toDNA(String[][] strand){

		for(int i = 0; i<2; i++){
			if (i == 1){
				System.out.println("");
			}
			for(int k = 0; k<strand[i].length; k++){
				System.out.print(strand[i][k]);
		}
		System.out.println("");
	}
}

}

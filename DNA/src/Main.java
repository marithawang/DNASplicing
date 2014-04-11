import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		ArrayList<String> strand = new ArrayList<String>();
		ArrayList<String> strand2 = new ArrayList<String>();
		System.out.println("Original strand Sequence:");
		for (int i = 0; i<10; i++){
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
			strand.add(baseLet);
		}
		toHelix(strand, strand2);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("Choose Restriction Enzyme (Indicate Number):");
		System.out.println("1. EcoRI \n2. MscI \n3. PsiI");
		String input = scan.nextLine();


		splice(strand, input);
	}

	private static ArrayList<String> toHelix(ArrayList<String> strand, ArrayList<String> strand2) {
		for(int k = 0; k<strand.size(); k++){
			System.out.print(strand.get(k));
		}
		System.out.println("");
		for(int i = 0; i<strand.size(); i++){
			String basePair = "";
			switch(strand.get(i)){
			case "A": basePair = "T";
			break;
			case "T": basePair = "A";
			break;
			case "C": basePair = "G";
			break;
			case "G": basePair = "C";
			break;
			}
			strand2.add(basePair);
			System.out.print(strand2.get(i));
		}
		System.out.println("");
		return strand2;
		
	}
	
	public static void insert(String nucleotide, ArrayList<String> strand, ArrayList<String> strand2){
		
	}

	public static ArrayList<String> splice(ArrayList<String> strand, String splitPos){
		return strand;
		
	}
	public int[] transcribe(int[] strand){
		return strand;
		
	}
	public int[] translate(int[] strand){
		return strand;
		
	}
	
}

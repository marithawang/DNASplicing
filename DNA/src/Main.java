import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		ArrayList<String> strand = new ArrayList<String>();
		System.out.println("Original strand Sequence:");
		for (int i = 0; i<20; i++){
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
			System.out.print(strand.get(i));
		}
		
		System.out.println("");
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("Choose Restriction Enzyme (Indicate Number):");
		System.out.println("1. EcoRI \n2. MscI \n3. PsiI");
		String input = scan.nextLine();


		splice(strand, input);
	}
	
	public static void insert(String nucleotide, ArrayList<String> strand){
		
		
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

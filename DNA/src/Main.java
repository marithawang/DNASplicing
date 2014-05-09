import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		String strand = "";
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
			strand = strand.substring(0) + baseLet;
			System.out.print(strand.charAt(i));
		}
		
		System.out.println("");
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("Choose Restriction Enzyme (Indicate Number):");
		System.out.println("1. EcoRI \n2. MscI \n3. PsiI");
		String input = scan.nextLine();
		System.out.println("Foreign Strand to Insert:");
		String insert = scan.nextLine();


		insert(input, insert, strand);
	}
	
	public static void insert(String input, String insert, String strand){
		
		
	}

	public String transcribe(String strand){
		return strand;
		
	}
	public String translate(String strand){
		return strand;
		
	}
	
}

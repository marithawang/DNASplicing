import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		int[] DNA = new int[20];
		
		System.out.println("Original DNA Sequence:");
		for (int i = 0; i<DNA.length; i++){
			DNA[i]=(int)(Math.random()*4);
		}
		toDNA(DNA);
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Sequence to Cut At (Indicate Split Position with Space):");
		System.out.println("For Example: G AAT");
		String input=scan.nextLine();
		
		splice(DNA, input);
	}

	public static int[] splice(int[] strand, String splitPos){
		return strand;
		
	}
	public int[] transcribe(int[] strand){
		return strand;
		
	}
	public int[] translate(int[] strand){
		return strand;
		
	}
	
	public static void toDNA(int[] a){
		
		for(int i = 0; i<a.length; i++){
			String nucleotide = "";
			switch (a[i]){
			case 0: nucleotide = "A";
			break;
			case 1: nucleotide = "T";
			break;
			case 2: nucleotide = "C";
			break;
			case 3: nucleotide = "G";
			}
			System.out.print(nucleotide);
		}
		System.out.println("");
	}
}

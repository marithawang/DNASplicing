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
//		
//		System.out.println("");
//		Scanner scan = new Scanner(System.in);
//		System.out.println("");
//		System.out.println("Choose Restriction Enzyme (Indicate Number):");
//		System.out.println("1. EcoRI \n2. MscI \n3. PsiI");
//		String input = scan.nextLine();
//		System.out.println("Foreign Strand to Insert:");
//		String insert = scan.nextLine();
//

	//	insert(input, insert, strand);
		System.out.println("");
		System.out.println(transcribe(strand));
		translate(transcribe(strand));

	}

	public static void insert(String input, String insert, String strand){


	}

	public static String transcribe(String strand){
		ArrayList<String> s = new ArrayList<String>();
		ArrayList<String> t = new ArrayList<String>();

		for (int i = 0; i < strand.length(); i++) {
			s.add(strand.substring(i, i + 1));
		}

		for (int j = 0; j < s.size(); j++) {
			if (s.get(j).equals("A")) {
				t.add("U");
			} else if (s.get(j).equals("T")) {
				t.add("A");
			} else if (s.get(j).equals("C")) {
				t.add("G");
			} else {
				t.add("C");
			}
		}
		String transcribedStrand = "";

		for (int k = 0; k < t.size(); k++){
			transcribedStrand = transcribedStrand + t.get(k);
		}
		return transcribedStrand;

	}
	
	public static void translate(String strand){
		for (int i = 0; i < strand.length()/3; i++) {
			if (aminoAcid(strand.substring(i*3, i*3+3)).equals("Stop")) {
				break;
			} else {
				System.out.println(aminoAcid(strand.substring(i*3, i*3+3)));
			}
		}
	}
	
	public static String aminoAcid(String codon) {
		char nucleotide1 = codon.charAt(0);
		char nucleotide2 = codon.charAt(1);
		char nucleotide3 = codon.charAt(2);
		
		if (nucleotide1 == 'G') {
			if (nucleotide2 == 'G') {
				return "Glycine";
			} else if (nucleotide2 == 'U') {
				return "Valine";
			} else if (nucleotide2 == 'C') {
				return "Alanine";
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Aspartic Acid";
				} else {
					return "Glutamic Acid";
				}
			}
		} else if (nucleotide1 == 'C') {
			if (nucleotide2 == 'G') {
				return "Arginine";
			} else if (nucleotide2 == 'U') {
				return "Leucine";
			} else if (nucleotide2 == 'C') {
				return "Proline";
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Histidine";
				} else {
					return "Glutamine";
				}
			}
		} else if (nucleotide1 == 'A'){
			if (nucleotide2 == 'C') {
				return "Threonine";
			} else if (nucleotide2 == 'G') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Serine";
				} else {
					return "Arginine";
				}
			} else if (nucleotide2 == 'A') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Asparagine";
				} else {
					return "Lysine";
				}
			} else {
				if (nucleotide3 == 'A' || nucleotide3 == 'C' || nucleotide3 == 'U') {
					return "Isoleucine";
				} else {
					return "Methionine";
				}
			}
		} else {
			if (nucleotide2 == 'C') {
				return "Serine";
			} else if (nucleotide2 == 'U') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Phenyl-alanine";
				} else {
					return "Leucine";
				}
			} else if (nucleotide2 == 'A') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Tyrosine";
				} else {
					return "Stop";
				}
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Cysteine";
				} else if (nucleotide3 == 'G') {
					return "Tryptophan";
				} else {
					return "Stop";
				}
			}
		}
	}

}

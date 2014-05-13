import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static String input;
	private static String insert;
	private static String total = "";

	public static void main(String[] args){
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

			total = total + baseLet;
			System.out.print(total.charAt(i));
		}

		System.out.println("");
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("Enter Sequence to Insert New DNA At:");
		input = scan.nextLine();
		System.out.println("Foreign Strand to Insert:");
		insert = scan.nextLine();

		insertDNA();
		transcribe();
		translate();
		System.out.println("");
	}

	public static void insertDNA(){
		System.out.println("New DNA Strand:");
		if(total.contains(input)){
			int index = total.indexOf(input);
			total = total.substring(0, index+3) + insert + total.substring(index+3);
		}
		System.out.print(total);
	}

	public static void transcribe(){
		ArrayList<String> s = new ArrayList<String>();
		ArrayList<String> t = new ArrayList<String>();

		for (int i = 0; i < total.length(); i++) {
			s.add(total.substring(i, i + 1));
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
		total = transcribedStrand;
		System.out.println("");
		System.out.println("Transcribed Strand:");
		System.out.println(total);
	}
	public static void translate(){
		System.out.println("");
		System.out.println("Amino Acids:");
		for (int i = 0; i < total.length()/3; i++) {
			if (aminoAcid(total.substring(i*3, i*3+3)).equals("Stop")) {
				System.out.print("Stop");
				break;
			} else {
				System.out.print(aminoAcid(total.substring(i*3, i*3+3)));
			}
		}
		System.out.println("End");
	}

	public static String aminoAcid(String codon) {
		char nucleotide1 = codon.charAt(0);
		char nucleotide2 = codon.charAt(1);
		char nucleotide3 = codon.charAt(2);

		if (nucleotide1 == 'G') {
			if (nucleotide2 == 'G') {
				return "Glycine, ";
			} else if (nucleotide2 == 'U') {
				return "Valine, ";
			} else if (nucleotide2 == 'C') {
				return "Alanine, ";
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Aspartic Acid, ";
				} else {
					return "Glutamic Acid, ";
				}
			}
		} else if (nucleotide1 == 'C') {
			if (nucleotide2 == 'G') {
				return "Arginine, ";
			} else if (nucleotide2 == 'U') {
				return "Leucine, ";
			} else if (nucleotide2 == 'C') {
				return "Proline, ";
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Histidine ";
				} else {
					return "Glutamine, ";
				}
			}
		} else if (nucleotide1 == 'A'){
			if (nucleotide2 == 'C') {
				return "Threonine, ";
			} else if (nucleotide2 == 'G') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Serine, ";
				} else {
					return "Arginine, ";
				}
			} else if (nucleotide2 == 'A') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Asparagine, ";
				} else {
					return "Lysine, ";
				}
			} else {
				if (nucleotide3 == 'A' || nucleotide3 == 'C' || nucleotide3 == 'U') {
					return "Isoleucine, ";
				} else {
					return "Methionine, ";
				}
			}
		} else {
			if (nucleotide2 == 'C') {
				return "Serine ";
			} else if (nucleotide2 == 'U') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Phenyl-alanine, ";
				} else {
					return "Leucine, ";
				}
			} else if (nucleotide2 == 'A') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Tyrosine, ";
				} else {
					return "Stop";
				}
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Cysteine ";
				} else if (nucleotide3 == 'G') {
					return "Tryptophan, ";
				} else {
					return "Stop";
				}
			}
		}
	}
}

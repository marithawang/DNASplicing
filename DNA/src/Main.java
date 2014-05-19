import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static String restrictionEnzyme = "";
	private static String num;
	private static String insert;
	private static String total = "";

	public static void main(String[] args) throws Exception{
		System.out.println("Original DNA Strand:");
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

			total = total + baseLet;
			System.out.print(total.charAt(i));
		}

		System.out.println("");
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("Enter Restriction Enzyme: (Choose a number)");
		System.out.println("1. SmaI");
		System.out.println("2. BamHI");
		System.out.println("3. AluI");
		System.out.println("4. StuI");
		num = scan.nextLine();
		System.out.println("Foreign Strand to Insert:");
		insert = scan.nextLine();
		
		if (isOkay()){
		enzymeSelector();
		insertDNA();
		transcribe();
		translate();
		System.out.println("");
		}
		else{
			throw new Exception("Invalid restrictionEnzyme/s");
		}

	}

	private static void enzymeSelector() {
		if (num.equals("1")) { // SmaI
			restrictionEnzyme = "CCCGGG";
		} else if (num.equals("2")) { // BamHI
			restrictionEnzyme = "GGCC";
		} else if (num.equals("3")){
			restrictionEnzyme = "AGCT";
		} else if (num.equals("4")){
			restrictionEnzyme = "AGGCCT";
		}
		else {
			System.out.println("Restriction enzyme does not exist.");
		}
		
	}

	private static boolean isOkay() {
		if(num.matches("^[1-2]+$") && insert.matches("^[A,C,T,G]+$")){
			return true;
		}
		else{
			return false;
		}
	}

	public static void insertDNA(){
		System.out.println("New DNA Strand:");
		System.out.println(total);
		if(total.contains(restrictionEnzyme)){
			int index = total.indexOf(restrictionEnzyme);
			total = total.substring(0, index+restrictionEnzyme.length()/2) + insert + total.substring(index + restrictionEnzyme.length()/2);
		}
		System.out.print(total);
		System.out.println("");
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
			if (aminoAcid(total.substring(i*3, i*3+3)).equals("Stop ")) {
				System.out.println("Stop");
				break;
			} else {
				System.out.print(aminoAcid(total.substring(i*3, i*3+3)));
			}
		}
	}

	public static String aminoAcid(String codon) {
		char nucleotide1 = codon.charAt(0);
		char nucleotide2 = codon.charAt(1);
		char nucleotide3 = codon.charAt(2);

		if (nucleotide1 == 'G') {
			if (nucleotide2 == 'G') {
				return "Glycine ";
			} else if (nucleotide2 == 'U') {
				return "Valine ";
			} else if (nucleotide2 == 'C') {
				return "Alanine ";
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Aspartic Acid ";
				} else {
					return "Glutamic Acid ";
				}
			}
		} else if (nucleotide1 == 'C') {
			if (nucleotide2 == 'G') {
				return "Arginine ";
			} else if (nucleotide2 == 'U') {
				return "Leucine ";
			} else if (nucleotide2 == 'C') {
				return "Proline ";
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Histidine ";
				} else {
					return "Glutamine ";
				}
			}
		} else if (nucleotide1 == 'A'){
			if (nucleotide2 == 'C') {
				return "Threonine ";
			} else if (nucleotide2 == 'G') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Serine ";
				} else {
					return "Arginine ";
				}
			} else if (nucleotide2 == 'A') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Asparagine ";
				} else {
					return "Lysine ";
				}
			} else {
				if (nucleotide3 == 'A' || nucleotide3 == 'C' || nucleotide3 == 'U') {
					return "Isoleucine ";
				} else {
					return "Methionine ";
				}
			}
		} else {
			if (nucleotide2 == 'C') {
				return "Serine ";
			} else if (nucleotide2 == 'U') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Phenyl-alanine ";
				} else {
					return "Leucine ";
				}
			} else if (nucleotide2 == 'A') {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Tyrosine ";
				} else {
					return "Stop ";
				}
			} else {
				if (nucleotide3 == 'U' || nucleotide3 == 'C') {
					return "Cysteine ";
				} else if (nucleotide3 == 'G') {
					return "Tryptophan ";
				} else {
					return "Stop ";
				}
			}
		}
	}

}

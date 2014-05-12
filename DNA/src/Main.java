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
		System.out.print(transcribe(strand));
		
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
	public static String translate(String strand){
		String temp = " ";
		for (int i= 1; i<= strand.length(); i++){
		temp += strand.substring(i-1, i);
		if (i%3 == 0){
			anticodon(temp);
			temp = " ";
		}
		}
		return strand;
		
	}
	
	public static String anticodon(String temp){
		String print = " ";
		if(temp == null){
			return print;
		}
		switch (temp.toLowerCase()){
		case "uuu":
			print = Phe;
			break;
		case "uuc":
			print= Phe;
			break;
		case "uua":
			print = Leu;
			break;
		case "uug":
			print = Leu;
			break;
			
		}
		
	}
	
}

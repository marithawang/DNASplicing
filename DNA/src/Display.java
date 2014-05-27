import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;

public class Display extends JComponent {
	private final int DISPLAY_WIDTH;   
	private final int DISPLAY_HEIGHT;

	private static String restrictionEnzyme = "";
	private static String enzyme;
	private static String insert;
	private static String DNA = "";
	private static String mRNA = "";

	private InsertButton insButt;

	private InsertText insText;
	private EnzymeText enText;

	private JLabel DNALabel;
	private JLabel mRNALabel;
	private JLabel insLabel;
	private JLabel enLabel;

	private Image test = null;

	public Display(int width, int height) {
		DISPLAY_WIDTH = width;
		DISPLAY_HEIGHT = height;
		init();
	}

	public void init() {
		setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);

		// DNA Label
		DNALabel = new JLabel("DNA Strand:");
		DNALabel.setBounds(20, 20, 100, 20);
		add(DNALabel);
		DNALabel.setVisible(true);

		// mRNA Label
		mRNALabel = new JLabel("mRNA Strand:");
		mRNALabel.setBounds(20, 165, 100, 20);
		add(mRNALabel);
		mRNALabel.setVisible(true);

		// Enzyme Label
		enLabel = new JLabel("Restriction Enzyme:");
		enLabel.setBounds(50, 330, 150, 20);
		add(enLabel);
		enLabel.setVisible(true);

		// Insert Label
		insLabel = new JLabel("Strand:");
		insLabel.setBounds(50, 380, 100, 20);
		add(insLabel);
		insLabel.setVisible(true);

		// Enzyme Text Box Setup
		enText = new EnzymeText();
		enText.setBounds(50, 350, 400, 30);
		add(enText);
		enText.setVisible(true);

		// Insert Text Box Setup
		insText = new InsertText();
		insText.setBounds(50, 400, 400, 30);
		add(insText);
		insText.setVisible(true);

		// Insert Button Setup
		insButt = new InsertButton();
		insButt.setBounds(50, 450, 400, 40);
		add(insButt);
		insButt.setVisible(true);

		System.out.println("Original strand Sequence:");
		for (int i = 0; i < 20; i++) {

			int baseNum = (int) (Math.random() * 4);

			String baseLet = "";
			switch(baseNum) {
			case 0: baseLet = "A";
			break;
			case 1: baseLet = "T";
			break;
			case 2: baseLet = "C";
			break;
			case 3: baseLet = "G";
			}

			DNA += baseLet;
			System.out.print(DNA.charAt(i));
		}
		System.out.println("");
		System.out.println("Enter Sequence to Insert New DNA At:");

		repaint();
	}

	public void paintComponent(Graphics g) {
		// Render DNA
		for (int i = 0; i < DNA.length(); i++) {
			if (DNA.charAt(i) == 'A') {
				test = getImage("DNA/DNA_A.png");
			} else if (DNA.charAt(i) == 'T') {
				test = getImage("DNA/DNA_T.png");
			} else if (DNA.charAt(i) == 'C') {
				test = getImage("DNA/DNA_C.png");
			} else {
				test = getImage("DNA/DNA_G.png");
			}

			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(test, 50+51*i, 50, test.getWidth(null)/5, test.getHeight(null)/5, null);
		}

		// Render mRNA
		if (mRNA.equals("")) {
		} else {
			for (int i = 0; i < mRNA.length(); i++) {
				if (mRNA.charAt(i) == 'A') {
					test = getImage("mRNA/mRNA_A.png");
				} else if (mRNA.charAt(i) == 'U') {
					test = getImage("mRNA/mRNA_U.png");
				} else if (mRNA.charAt(i) == 'C') {
					test = getImage("mRNA/mRNA_C.png");
				} else {
					test = getImage("mRNA/mRNA_G.png");
				}

				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(test, 50+51*i, 300-test.getHeight(null)/5, test.getWidth(null)/5, test.getHeight(null)/5, null);
			}
		}

		repaint();
	}

	// Gets image
	public Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Display.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			System.out.println("An error occured: " + e.getMessage());
		}
		return tempImage;
	}

	// Selects enzyme
	private static void enzymeSelector() {
		if (enzyme.equals("SmaI")) { // SmaI
			restrictionEnzyme = "CCCGGG";
		} else if (enzyme.equals("BamHI")) { // BamHI
			restrictionEnzyme = "GGCC";
		} else if (enzyme.equals("AluI")){
			restrictionEnzyme = "AGCT";
		} else if (enzyme.equals("StuI")){
			restrictionEnzyme = "AGGCCT";
		}
		else {
			System.out.println("Restriction enzyme does not exist.");
		}

	}

	private static boolean isOkay() {
		System.out.println("dasdf " + enzyme + " " + insert);
		return enzyme.matches("^(BamHI|SmaI|AluI|StuI)$")
				&& insert.matches("^[ACTG]+$");
	}

	// Inserts given DNA strand into current DNA
	public static void insertDNA(){
		System.out.println("New DNA Strand:");
		if(DNA.contains(restrictionEnzyme)){
			int index = DNA.indexOf(restrictionEnzyme) + restrictionEnzyme.length()/2;
			String a = DNA.substring(0, index);
			String b = DNA.substring(index);
			DNA = a + insert + b;
		}
		System.out.print(DNA);
	}

	// Transcribes DNA strand to an mRNA strand
	public static void transcribe(){
		mRNA = DNA;
		ArrayList<String> s = new ArrayList<String>();
		ArrayList<String> t = new ArrayList<String>();

		for (int i = 0; i < mRNA.length(); i++) {
			s.add(mRNA.substring(i, i + 1));
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
		mRNA = transcribedStrand;
		System.out.println("");
		System.out.println("Transcribed Strand:");
		System.out.println(mRNA);
	}

	// Translates codons of mRNA into amino acids
	public static void translate(){
		System.out.println("");
		System.out.println("Amino Acids:");
		for (int i = 0; i < mRNA.length()/3; i++) {
			if (aminoAcid(mRNA.substring(i*3, i*3+3)).equals("Stop")) {
				break;
			} else {
				System.out.print(aminoAcid(mRNA.substring(i*3, i*3+3)));
			}
		}
		System.out.println("Stop");
	}

	// Identifies proper amino acid for given codon
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

	// Button to activate insertion process
	private class InsertButton extends JButton implements ActionListener {
		InsertButton() {
			super("Insert");
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			enzyme = enText.getText();
			insert = insText.getText();
			if (isOkay()) {
				enzymeSelector();
				insertDNA();
				transcribe();
				translate();
			}
		}
	}

	// Text box for the DNA strand to be inserted
	private class InsertText extends JTextField implements ActionListener {
		InsertText() {
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}

	}

	// Text box for selecting enzyme
	private class EnzymeText extends JTextField implements ActionListener {
		EnzymeText() {
			addActionListener(this);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}

	}
}


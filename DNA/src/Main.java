import javax.swing.JFrame;

public class Main {
	public static void main(String[] args){
		JFrame f = new JFrame();
		
		final int DISPLAY_WIDTH = 1800;
		final int DISPLAY_HEIGHT = 550;
		
		f.setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT);
		f.setTitle("DNA Splicer");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Display display = new Display(DISPLAY_WIDTH, DISPLAY_HEIGHT);
		f.setLayout(null);
		f.add(display);
		
		f.setVisible(true);
	}
}

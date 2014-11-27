package jisuu.gui;
import javax.swing.SwingConstants;

public class JisuuDesc extends JisuuWindow {
	
	
	
	
	public JisuuDesc() {
		
		
		panDict.scrollpaneConflicts.setSize(598, 200);
		panDict.scrollpaneConflicts.setLocation(200, 0);
		panDict.setSize(798, 200);
		panStats.scrollpaneStats.setBounds(0, 0, 788, 69);
		panStats.setBounds(0, 0, 788, 69);
		panDict.setLocation(0, 105);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static final long serialVersionUID = 7742568969067445090L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JisuuDesc f = new JisuuDesc();
		f.setVisible(true);
	}

}

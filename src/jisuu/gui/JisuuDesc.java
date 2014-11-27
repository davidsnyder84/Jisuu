package jisuu.gui;

public class JisuuDesc extends JisuuWindow {
	public JisuuDesc() {
		panUnkKanji.setLocation(182, 27);
		panStoryKanji.setLocation(129, 292);
		panDict.setLocation(392, 60);
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

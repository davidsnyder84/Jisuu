package jisuu.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class JisuuWindow extends JFrame{
	private static final long serialVersionUID = 5106812075459526627L;
	
	private static final int WINDOW_WIDTH = 500;
	private static final int WINDOW_HEIGHT = 300;
	
	private static final int WINDOW_TOP_BORDER_SIZE = 26;
	private static final int WINDOW_SIDE_BORDER_SIZE = 2;
	private static final int WINDOW_BOTTOM_BORDER_SIZE = 2;
//	private static final int WINDOW_MENU_SIZE = 23;
	
	
	
	public JisuuWindow() {
		
		
		
		final int WINDOW_BOUND_WIDTH = WINDOW_WIDTH + 2*WINDOW_SIDE_BORDER_SIZE;
		final int WINDOW_BOUND_HEIGHT = WINDOW_HEIGHT + WINDOW_TOP_BORDER_SIZE + WINDOW_BOTTOM_BORDER_SIZE;
		
		
		setBounds(100, 100, WINDOW_BOUND_WIDTH, WINDOW_BOUND_HEIGHT);
		setTitle("Jisuu - Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		

		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		
		String message = "This\nShould\nBe\nFive\nLines";
		String longMessage = "This\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines\nShould\nBe\nFive\nLines";
		String horizMessage = "This is a long ass line that keeps going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and going and ";
		String sampleLong = "贔屓\t(ひいき) (贔屓,贔負) (n,vs) favor; patronage; partiality; (P)   [贔屓贔屓 - (n) each person supporting (patronizing) his (her) own favorite]   [依怙贔屓 - (えこひいき) (adj-na,n,vs) favoritism; favouritism; partiality; prejudice; bias]   [贔屓にする - (exp,vs-i) to favor; to show favor to;to be partial to; to be a regular customer of]   [身贔屓 - (みびいき) (n) favoritism (towards relatives); favouritism; nepotism]   [縁者贔屓 - (えんじゃびいき) (n) nepotism]";
		String lotsLong = sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n" + sampleLong + "\n";
		
		
		
		
		
		JTextArea tArea = new JTextArea();
		tArea.setEditable(false);
		tArea.setText(message);
		tArea.setLineWrap(false);
		tArea.setText(longMessage);
//		tArea.setText(horizMessage);
//		tArea.setText(sampleLong);
		tArea.setText(lotsLong);
		tArea.setBounds(33, 293, 351, 180);
//		contentPane.add(tArea);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 454, 264);
		scrollPane.setViewportView(tArea);
		contentPane.add(scrollPane);
		
		
		
		
		
		KanjiReportPanel dictReport;
		
		
	}
	
	
	
	
	
	public class KanjiReportPanel extends JPanel{
		private static final long serialVersionUID = -8234225565280333992L;
		
		public KanjiReportPanel(){
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JisuuWindow();
		frame.setVisible(true);
	}
}

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;


public class JisuuMenu extends JFrame{
	private static final long serialVersionUID = 5106812075459526627L;
	
	
	
	
	
	public JisuuMenu() {
		
		setSize(480, 600);
		
		
		
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
		
		
		
		
		
		
		JTextPane tPane = new JTextPane();
		tPane.setText(message);
		tPane.setText(longMessage);
		tPane.setText(horizMessage);
//		tPane.setText(sampleLong);
		tPane.setText(lotsLong);
		tPane.setBounds(26, 64, 416, 196);
//		contentPane.add(tPane);
		
		JTextArea tArea = new JTextArea();
		tArea.setText(message);
		tArea.setText(longMessage);
//		tArea.setText(horizMessage);
//		tArea.setText(sampleLong);
		tArea.setText(lotsLong);
		tArea.setBounds(33, 293, 351, 180);
		contentPane.add(tArea);
		
		JLabel label = new JLabel();
		label.setText(message);
		label.setText(longMessage);
		label.setBounds(43, 481, 328, 80);
		contentPane.add(label);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 454, 264);
//		scrollPane.setViewportView(tPane);
		scrollPane.setViewportView(tArea);
		contentPane.add(scrollPane);
	}
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JisuuMenu();
		frame.setVisible(true);
	}
}

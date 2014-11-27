package jisuu.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import jisuu.kanji.KanjiSet;
import jisuu.story.StoryReport;
import jisuu.vocab.TangoDictionary;


public class JisuuWindow extends JFrame{
	private static final long serialVersionUID = 5106812075459526627L;
	
	private static final int WINDOW_WIDTH = 800, WINDOW_HEIGHT = 600;
	
	private static final int WINDOW_TOP_BORDER_SIZE = 26;
	private static final int WINDOW_SIDE_BORDER_SIZE = 2;
	private static final int WINDOW_BOTTOM_BORDER_SIZE = 2;
//	private static final int WINDOW_MENU_SIZE = 23;
	
	private static final String TITLE_KANJI_DICT = "Dictionary Kanji:", TITLE_KANJI_STORY = "Story Kanji:", TITLE_KANJI_UNK = "Unknown Kanji:";
	
	
	
	
	
	
	private DictionaryPanel panDict;
	
	private KanjiSetPanel panDictKanji;
	private KanjiSetPanel panStoryKanji;
	private KanjiSetPanel panUnkKanji;
	
	
	
	
	
	
	
	
	
	
	
	
	
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
		
		
		
		
		
		
		
		
		

		panDict = new DictionaryPanel();
		
		panStoryKanji = new KanjiSetPanel();
		panUnkKanji = new KanjiSetPanel();
		
		
		

		panDict.setLocation(0,0);
		
		panStoryKanji.setLocation(0,0);
		panUnkKanji.setLocation(0,0);
		
		
		
	}
	
	

	
	public void displayInfo(TangoDictionary dict, StoryReport story, KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
		
		panStoryKanji.updateInfo(TITLE_KANJI_STORY, storyKanji);
		panUnkKanji.updateInfo(TITLE_KANJI_UNK, unkownKanji);
		
		panDict.updateInfo(dict);
		
		
		//update window, etc
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public class StatsPanel extends JPanel{
		private static final long serialVersionUID = 3900762501958533847L;
		
		private static final int WIDTH = 200, HEIGHT = 200;
		private static final int STATPANE_WIDTH = 180, STATPANE_HEIGHT = 100;

		private TangoDictionary pDict;
		private StoryReport pStory;
		
		
		private JTextArea txtStats = new JTextArea();
		private JScrollPane scrollpaneStats = new JScrollPane();
		
		public StatsPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			
			
			JLabel lblTitle = new JLabel("Stats");
			lblTitle.setBounds(0,0,0,0);
			
			
			scrollpaneStats.setViewportView(txtStats);
			scrollpaneStats.setBounds(0, 0, STATPANE_WIDTH, STATPANE_HEIGHT);
			
			
			add(lblTitle);
			add(scrollpaneStats);
		}
		
		public void updateInfo(TangoDictionary dict, StoryReport story){
			if (dict != null) pDict = dict;
			else pDict = new TangoDictionary();
			if (story != null) pStory = story;
			else pStory = new StoryReport();
			
			//update
			//add stats method to Dictionary
		}
	}
	
	
	
	
	
	
	
	
	
	public class DictionaryPanel extends JPanel{
		private static final long serialVersionUID = 4408450891634950601L;
		
		private static final int WIDTH = 200, HEIGHT = 200;
		private static final int CONFLICTPANE_WIDTH = 180, CONFLICTPANE_HEIGHT = 100;
		
		
		private TangoDictionary pDict;
		
		private KanjiSetPanel pKanjiPanel = new KanjiSetPanel();
		private JTextArea txtConflicts = new JTextArea();
		private JScrollPane scrollpaneConflicts = new JScrollPane();
		
		public DictionaryPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			
			

			//add text area to scroll pane
			scrollpaneConflicts.setViewportView(txtConflicts);
			
			
			pKanjiPanel.setLocation(0, 0);
			scrollpaneConflicts.setBounds(0, 0, CONFLICTPANE_WIDTH, CONFLICTPANE_HEIGHT);
			
			add(pKanjiPanel);
			add(scrollpaneConflicts);
			
			
		}
		
		public void updateInfo(TangoDictionary dict){
			if (dict != null) pDict = dict;
			else pDict = new TangoDictionary();
			
			pKanjiPanel.updateInfo(TITLE_KANJI_DICT, dict.getKanjiSet());
			
			//set conflicts
			txtConflicts.setText(dict.getConflicts());
		}
		
	}
	
	
	
	
	
	
	public class KanjiSetPanel extends JPanel{
		private static final long serialVersionUID = -8234225565280333992L;
		
		private static final int WIDTH = 200, HEIGHT = 200;
		private static final int KANJIPANE_WIDTH = 180, KANJIPANE_HEIGHT = 100;
		
		
		private String pTitle;
		private KanjiSet pKanji;
		
		private JLabel lblNumKanji = new JLabel();
		private JTextArea txtKanji = new JTextArea();
		private JScrollPane scrollpaneKanji = new JScrollPane();
		
		
		public KanjiSetPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			
			
			final JLabel lblKanNumLabel = new JLabel("Number of Kanji: ");
			final JLabel lblKanTextLabel = new JLabel("Set of Kanji: ");
			
			
			
			//add text area to scroll pane
			scrollpaneKanji.setViewportView(txtKanji);
			
			
			
			
			lblNumKanji.setLocation(0, 0);
			scrollpaneKanji.setBounds(0, 0, KANJIPANE_WIDTH, KANJIPANE_HEIGHT);
			lblKanNumLabel.setBounds(0, 0, 0, 0);
			lblKanTextLabel.setBounds(0, 0, 0, 0);
			
			add(lblNumKanji);
			add(scrollpaneKanji);
			add(lblKanNumLabel);
			add(lblKanTextLabel);
		}

		
		
		public void updateInfo(String title, KanjiSet kanji){
			setTitle(title);
			setKanjiSet(kanji);
			
			//number of kanji
			lblNumKanji.setText(Integer.toString(kanji.size()));
			//set of kanji
			txtKanji.setText(kanji.toString());
		}
		
		public void setKanjiSet(KanjiSet kanji){
			if (kanji != null) pKanji = kanji;
			else pKanji = new KanjiSet();
		}
		
		public void setTitle(String title){
			pTitle = title;
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		JFrame frame = new JisuuWindow();
		frame.setVisible(true);
	}
}

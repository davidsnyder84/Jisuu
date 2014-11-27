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
	
	
	private static final String WINDOW_TITLE = "Jisuu - Main Menu";
	private static final String TITLE_KANJI_DICT = "Dictionary Kanji:", TITLE_KANJI_STORY = "Story Kanji:", TITLE_KANJI_UNK = "Unknown Kanji:";
	
	
	
	
	
	
	protected DictionaryPanel panDict;
	
	protected KanjiSetPanel panDictKanji;
	protected KanjiSetPanel panStoryKanji;
	protected KanjiSetPanel panUnkKanji;
	
	protected StatsPanel panStats;
	
	
	
	
	
	
	
	
	
	
	
	public JisuuWindow() {
		
		
		
		final int WINDOW_BOUND_WIDTH = WINDOW_WIDTH + 2*WINDOW_SIDE_BORDER_SIZE;
		final int WINDOW_BOUND_HEIGHT = WINDOW_HEIGHT + WINDOW_TOP_BORDER_SIZE + WINDOW_BOTTOM_BORDER_SIZE;
		
		
		setBounds(100, 100, WINDOW_BOUND_WIDTH, WINDOW_BOUND_HEIGHT);
		setTitle(WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		

		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		

		panDict = new DictionaryPanel();
		
		panStoryKanji = new KanjiSetPanel();
		panUnkKanji = new KanjiSetPanel();
		
		panStats = new StatsPanel();
		
		

		panDict.setLocation(0,0);
		
		panStoryKanji.setLocation(0,0);
		panUnkKanji.setLocation(0,0);
		
		
		
		
		contentPane.add(panDict);
		contentPane.add(panStoryKanji);
		contentPane.add(panUnkKanji);
		contentPane.add(panStats);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		panUnkKanji.setLocation(182, 27);
		panStoryKanji.setLocation(129, 292);
		panDict.setLocation(392, 60);
		
		displayInfo(null, null, null, null, null);
	}
	
	

	
	public void displayInfo(TangoDictionary dict, StoryReport story, KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
		
		panStoryKanji.updateInfo(TITLE_KANJI_STORY, storyKanji);
		panUnkKanji.updateInfo(TITLE_KANJI_UNK, unkownKanji);
		
		panDict.updateInfo(dict);
		panStats.updateInfo(dict, story);
		
		
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
			setLayout(null);
			
			
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
			
			
			txtStats.setText(pDict.getFileStats() + "\n" + pStory.getFileStats());
			
			
			//update
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
			setLayout(null);
			
			

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
			
			pKanjiPanel.updateInfo(TITLE_KANJI_DICT, pDict.getKanjiSet());
			
			//set conflicts
			txtConflicts.setText(pDict.getConflicts());
		}
		
	}
	
	
	
	
	
	
	public class KanjiSetPanel extends JPanel{
		private static final long serialVersionUID = -8234225565280333992L;
		
		private static final int WIDTH = 200, HEIGHT = 200;
		private static final int KANJIPANE_WIDTH = 180, KANJIPANE_HEIGHT = 100;
		
		
		private String pTitle;
		private KanjiSet pKanji;
		
		private JLabel lblTitle = new JLabel();
		private JLabel lblNumKanji = new JLabel();
		private JTextArea txtKanji = new JTextArea();
		private JScrollPane scrollpaneKanji = new JScrollPane();
		
		
		public KanjiSetPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			setLayout(null);
			
			
			final JLabel lblKanNumLabel = new JLabel("Number of Kanji: "), lblKanTextLabel = new JLabel("Set of Kanji: ");
			
			
			
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
			lblNumKanji.setText(Integer.toString(pKanji.size()));
			//set of kanji
			txtKanji.setText(pKanji.toString());
			
			lblTitle.setText(pTitle);
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

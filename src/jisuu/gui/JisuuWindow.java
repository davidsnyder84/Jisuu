package jisuu.gui;

import java.awt.Color;

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

	private static final int WINDOW_BOUND_WIDTH = WINDOW_WIDTH + 2*WINDOW_SIDE_BORDER_SIZE;
	private static final int WINDOW_BOUND_HEIGHT = WINDOW_HEIGHT + WINDOW_TOP_BORDER_SIZE + WINDOW_BOTTOM_BORDER_SIZE;
	
	private static final Color COLOR_TRANSPARENT = new Color(0, 0, 0, 0);
	
	
	
	private static final String WINDOW_TITLE = "Jisuu - Main Menu";
	private static final String TITLE_KANJI_DICT = "Dictionary Kanji:", TITLE_KANJI_STORY = "Story Kanji:", TITLE_KANJI_UNK = "Unknown Kanji:";
	
	
	
	
	
	
	protected DictionaryPanel panDict;
	protected TripleKanjiPanel panKanjis;
	
	protected StatsPanel panStats;
	
	
	
	
	
	
	
	
	
	
	
	public JisuuWindow() {
		
		
		
		
		
		setBounds(100, 100, WINDOW_BOUND_WIDTH, WINDOW_BOUND_HEIGHT);
		setTitle(WINDOW_TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		

		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		
		
		
		
		
		
		
		
		
		

		panDict = new DictionaryPanel();
		panStats = new StatsPanel();
		panKanjis = new TripleKanjiPanel();
		

		panStats.setLocation(0, 0);
		panDict.setLocation(0, panStats.getHeight());
		panKanjis.setLocation(0, panStats.getHeight() + panDict.getHeight());
		
		contentPane.add(panDict);
		contentPane.add(panStats);
		contentPane.add(panKanjis);
		
		
		
		
		displayInfo(null, null, null, null, null);
	}
	
	

	
	public void displayInfo(TangoDictionary dict, StoryReport story, KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
		
		
		
		panDict.updateInfo(dict);
		panStats.updateInfo(dict, story);
		panKanjis.updateInfo(dictKanji, storyKanji, unkownKanji);
		
		
		//update window, etc
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public class TripleKanjiPanel extends JPanel{
		private static final long serialVersionUID = -2228035782444422423L;
		
		private static final int WIDTH = KanjiSetPanel.WIDTH*3, HEIGHT = KanjiSetPanel.HEIGHT;
		
		protected KanjiSetPanel panDictKanji = new KanjiSetPanel();
		protected KanjiSetPanel panStoryKanji = new KanjiSetPanel();
		protected KanjiSetPanel panUnkKanji = new KanjiSetPanel();
		
		public TripleKanjiPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			setLayout(null);
			
			
			
			panDictKanji.setLocation(0, 0);
			panStoryKanji.setLocation(KanjiSetPanel.WIDTH, 0);
			panUnkKanji.setLocation(KanjiSetPanel.WIDTH * 2, 0);
			
			
			add(panDictKanji);
			add(panStoryKanji);
			add(panUnkKanji);
		}
		
		
		
		

		
		public void updateInfo(KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
			
			panDictKanji.updateInfo(TITLE_KANJI_DICT, dictKanji);
			panStoryKanji.updateInfo(TITLE_KANJI_STORY, storyKanji);
			panUnkKanji.updateInfo(TITLE_KANJI_UNK, unkownKanji);
			
			//update
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public class StatsPanel extends JPanel{
		private static final long serialVersionUID = 3900762501958533847L;
		
		private static final int WIDTH = WINDOW_WIDTH, HEIGHT = 150;
		private static final int STATPANE_WIDTH = WIDTH, STATPANE_HEIGHT = HEIGHT;

		protected TangoDictionary pDict;
		protected StoryReport pStory;
		
		
		protected JTextArea txtStats = new JTextArea();
		protected JScrollPane scrollpaneStats = new JScrollPane();
		
		public StatsPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			setLayout(null);
			
			
			scrollpaneStats.setViewportView(txtStats);
			txtStats.setEditable(false);
			
			scrollpaneStats.setBounds(0, 0, STATPANE_WIDTH, STATPANE_HEIGHT);
			
			
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
		
		private static final int WIDTH = WINDOW_WIDTH, HEIGHT = 350;
		private static final int CONFLICTPANE_WIDTH = WINDOW_WIDTH - 10, CONFLICTPANE_HEIGHT = HEIGHT - 20;
		
		
		protected TangoDictionary pDict;
		
		protected JTextArea txtConflicts = new JTextArea();
		protected JScrollPane scrollpaneConflicts = new JScrollPane();
		
		public DictionaryPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			setLayout(null);
			
			

			//add text area to scroll pane
			scrollpaneConflicts.setViewportView(txtConflicts);
			txtConflicts.setEditable(false);
			
			scrollpaneConflicts.setBounds(5, 10, CONFLICTPANE_WIDTH, CONFLICTPANE_HEIGHT);
			
			add(scrollpaneConflicts);
			
			
		}
		
		public void updateInfo(TangoDictionary dict){
			if (dict != null) pDict = dict;
			else pDict = new TangoDictionary();
			
			//set conflicts
			txtConflicts.setText(pDict.getConflicts());
		}
		
	}
	
	
	
	
	
	
	public class KanjiSetPanel extends JPanel{
		private static final long serialVersionUID = -8234225565280333992L;
		
		public static final int WIDTH = 266, HEIGHT = 100;
		private static final int KANJIPANE_WIDTH = WIDTH - 10, KANJIPANE_HEIGHT = 60;
		
		
		protected String pTitle;
		protected KanjiSet pKanji;
		
		protected JLabel lblTitle = new JLabel();
		protected JLabel lblNumKanji = new JLabel();
		protected JTextArea txtKanji = new JTextArea();
		protected JScrollPane scrollpaneKanji = new JScrollPane();
		
		
		public KanjiSetPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			setLayout(null);
			
			
			final JLabel lblKanNumLabel = new JLabel("Number of Kanji: ");
			
			
			
			//add text area to scroll pane
			scrollpaneKanji.setViewportView(txtKanji);
			
			
			
			lblKanNumLabel.setBackground(COLOR_TRANSPARENT);
			lblNumKanji.setBackground(COLOR_TRANSPARENT);
			
			lblKanNumLabel.setBounds(10, 2, 130, 20);
			lblNumKanji.setBounds(140, 2, 50, 20);
			scrollpaneKanji.setBounds(5, 25, KANJIPANE_WIDTH, KANJIPANE_HEIGHT);
			
			
			add(lblNumKanji);
			add(scrollpaneKanji);
			add(lblKanNumLabel);
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

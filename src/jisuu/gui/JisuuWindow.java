package jisuu.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import jisuu.fileio.FileWriterReport;
import jisuu.kanji.KanjiSet;
import jisuu.story.StoryReport;
import jisuu.vocab.TangoDictionary;



/*
 * CS697B Project
 * David Snyder
 * A247A342
 * 
 * 
 * JisuuWindow
 * The main GUI window of the program
 * 		displays reports and statistics
 * 		presents the user with a button to save the reports if they want
 * 
 * 
 */
public class JisuuWindow extends JFrame{
	private static final long serialVersionUID = 5106812075459526627L;
	
	
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Begin Display Constants~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	private static final int WINDOW_WIDTH = 796, WINDOW_HEIGHT = 650;
	
	private static final Color COLOR_TRANSPARENT = new Color(0, 0, 0, 0);
	
	private static final String WINDOW_TITLE = "字数 Jisuu";
	private static final String TITLE_KANJI_DICT = "Dictionary Kanji:", TITLE_KANJI_STORY = "Story Kanji:", TITLE_KANJI_UNK = "Unknown Kanji:";
	private static final String SAVED_NOTIFICATION = "...Report Saved", SAVED_FAIL_NOTIFICATION = "!!!Error while saving";
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~End Display Constants~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	
	
	
	//panels
	private StatsPanel panStats;
	private DictionaryPanel panDict;
	private TripleKanjiPanel panKanjis;
	
	//a string containing a report, and a button to save the report
	private String mReport = "";
	private JButton buttonReport;
	
	
	
	
	
	public JisuuWindow() {
		
		//set attributes for frame
		setTitle(WINDOW_TITLE);
		setLocation(0, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		
		//create content pane
		JPanel contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//set preferred size of content pane
		contentPane.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
		
		
		
		
		//initialize panels
		panDict = new DictionaryPanel();
		panStats = new StatsPanel();
		panKanjis = new TripleKanjiPanel();
		
		//set positions of panels
		panStats.setLocation(0, 0);
		panDict.setLocation(0, panStats.getHeight());
		panKanjis.setLocation(0, panStats.getHeight() + panDict.getHeight());
		
		//add panels
		contentPane.add(panDict);
		contentPane.add(panStats);
		contentPane.add(panKanjis);
		
		
		//initialize and add report button
		buttonReport = new JButton("Save Report");
		buttonReport.addActionListener(new ReportButtonListener());
		buttonReport.setSize(187,35);
		buttonReport.setLocation(580,600);
		contentPane.add(buttonReport);
		
		
		//pack to make the frame the desired size
		pack();
	}
	
	
	
	/*
	 * display info
	 * (update all panels on the frame with the received information)
	 */
	public void displayInfo(TangoDictionary dict, StoryReport story, KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
		
		//create a full report string (to be saved to a file if the user desires)
		mReport = "";
		mReport += dict.getFileStats() + "\n";
		mReport += story.getFileStats() + "\n\n\n\n\n";
		mReport += "~~~~~Conflicts:\n" + dict.getConflicts() + "\n\n\n";
		mReport += "\n\n~~~~~Dictionary kanji:\n" + dictKanji.toString() + "\n";
		mReport += "\n\n~~~~~Story kanji:\n" + storyKanji.toString() + "\n";
		mReport += "\n\n~~~~~Unkown kanji:\n" + unkownKanji.toString() + "\n";
		
		panDict.updateInfo(dict);
		panStats.updateInfo(dict, story);
		panKanjis.updateInfo(dictKanji, storyKanji, unkownKanji);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * action listener for the "save report" button
	 * in response to the button click, writes the report to a file
	 */
	private class ReportButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			
			//try to write the report to the file
			boolean success = FileWriterReport.writeReportToFile(mReport);
			
			//display result
			if (success)
				buttonReport.setText(SAVED_NOTIFICATION);
			else
				buttonReport.setText(SAVED_FAIL_NOTIFICATION);
		}
	}
	
	
	
	
	
	
	
	
	

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Begin Panel Classes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	
	
	
	/*
	 * panel displaying file statistics
	 */
	private static class StatsPanel extends JPanel{
		private static final long serialVersionUID = 3900762501958533847L;
		
		private static final int WIDTH = WINDOW_WIDTH, HEIGHT = 150;
		private static final int STATPANE_WIDTH = WIDTH - 2, STATPANE_HEIGHT = HEIGHT;
		
		//has a dictionary and a story report associated with the panel
		private TangoDictionary pDict;
		private StoryReport pStory;
		
		//text area and scrollpane for displaying information
		private JTextArea txtStats = new JTextArea();
		private JScrollPane scrollpaneStats = new JScrollPane();
		
		public StatsPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			setLayout(null);
			
			//add text area to scroll pane
			scrollpaneStats.setViewportView(txtStats);
			scrollpaneStats.setBounds(0, 0, STATPANE_WIDTH, STATPANE_HEIGHT);
			txtStats.setEditable(false);
			
			add(scrollpaneStats);
		}
		
		
		//update the panel to display the information
		public void updateInfo(TangoDictionary dict, StoryReport story){
			if (dict != null) pDict = dict;
			else pDict = new TangoDictionary();
			if (story != null) pStory = story;
			else pStory = new StoryReport();
			
			txtStats.setText(pDict.getFileStats() + "\n" + pStory.getFileStats());
		}
	}
	
	
	
	
	
	
	
	
	/*
	 * panel displaying dictionary conflicts
	 */
	private static class DictionaryPanel extends JPanel{
		private static final long serialVersionUID = 4408450891634950601L;
		
		private static final int WIDTH = WINDOW_WIDTH, HEIGHT = 350;
		private static final int CONFLICTPANE_WIDTH = WINDOW_WIDTH - 10, CONFLICTPANE_HEIGHT = HEIGHT - 20;
		
		//has a dictionary associated with the panel
		private TangoDictionary pDict;
		
		//text area and scroll pane to display the information
		private JTextArea txtConflicts = new JTextArea();
		private JScrollPane scrollpaneConflicts = new JScrollPane();
		
		public DictionaryPanel(){
			super();
			setBounds(0, 0, WIDTH, HEIGHT);
			setLayout(null);
			
			//add text area to scroll pane
			scrollpaneConflicts.setViewportView(txtConflicts);
			scrollpaneConflicts.setBounds(5, 10, CONFLICTPANE_WIDTH, CONFLICTPANE_HEIGHT);
			txtConflicts.setEditable(false);
			
			add(scrollpaneConflicts);
		}
		
		
		//update the panel to display information for the received dictionary
		public void updateInfo(TangoDictionary dict){
			if (dict != null) pDict = dict;
			else pDict = new TangoDictionary();
			
			//set conflicts
			txtConflicts.setText(pDict.getConflicts());
		}
	}

	
	
	
	
	
	/*
	 * panel displaying the 3 kanji sets
	 * (shows dictionary kanji, story kanji, and unkown kanji)
	 */
	private static class TripleKanjiPanel extends JPanel{
		private static final long serialVersionUID = -2228035782444422423L;
		
		private static final int WIDTH = KanjiSetPanel.WIDTH*3, HEIGHT = KanjiSetPanel.HEIGHT;
		
		//contains 3 individuals kanji panels
		private KanjiSetPanel panDictKanji = new KanjiSetPanel();
		private KanjiSetPanel panStoryKanji = new KanjiSetPanel();
		private KanjiSetPanel panUnkKanji = new KanjiSetPanel();
		
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
		
		
		
		//update info for each of the 3 kanji panels to reflect the 3 sets
		public void updateInfo(KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
			panDictKanji.updateInfo(TITLE_KANJI_DICT, dictKanji);
			panStoryKanji.updateInfo(TITLE_KANJI_STORY, storyKanji);
			panUnkKanji.updateInfo(TITLE_KANJI_UNK, unkownKanji);
		}
	}
	
	
	
	
	
	
	
	
	
	/*
	 * a panel that displays a single set of kanji
	 * (shows the set of kanji, the title for the set, and the size of the set)
	 */
	private static class KanjiSetPanel extends JPanel{
		private static final long serialVersionUID = -8234225565280333992L;
		
		public static final int WIDTH = 266, HEIGHT = 100;
		private static final int KANJIPANE_WIDTH = WIDTH - 10, KANJIPANE_HEIGHT = 60;
		
		
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
			
			
			//add text area to scroll pane
			scrollpaneKanji.setViewportView(txtKanji);
			
			lblTitle.setBackground(COLOR_TRANSPARENT);
			lblNumKanji.setBackground(COLOR_TRANSPARENT);
			
			//position components
			lblTitle.setBounds(10, 2, 130, 20);
			lblNumKanji.setBounds(140, 2, 50, 20);
			scrollpaneKanji.setBounds(5, 25, KANJIPANE_WIDTH, KANJIPANE_HEIGHT);
			
			
			//add components
			add(lblTitle);
			add(lblNumKanji);
			add(scrollpaneKanji);
		}

		
		//methods to update the panel to display the received information
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
	

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~End Panel Classes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
}

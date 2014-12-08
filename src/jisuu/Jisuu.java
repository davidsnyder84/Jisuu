package jisuu;

import jisuu.fileio.FileLoaderStory;
import jisuu.fileio.FileLoaderVocab;
import jisuu.gui.JisuuWindow;
import jisuu.kanji.KanjiSet;
import jisuu.story.StoryReport;
import jisuu.vocab.TangoDictionary;


/*
 * CS697B Project
 * David Snyder
 * A247A342
 * 
 * 
 * Jisuu (main class of the program)
 * 
 * Program descrtipion
 * 		loads vocab from all the files in the dictionary directory
 * 		reads information from story.txt
 * 		displays reports for all of the information read (GUI)
 * 
 */
public class Jisuu {
	
	
	private JisuuWindow mWindow;
	private TangoDictionary mDict;
	private StoryReport mStory;
	
	
	public Jisuu(){	//constructor creates a window
		mWindow = new JisuuWindow();
		mDict = null;
		mStory = null;
	}
	
	
	
	
	/*
	 * launches the program
	 * loads the dictionaries, the story, and displays a report
	 */
	public void launch(){
		
		//load dictionaries
		mDict = FileLoaderVocab.loadAllVocabFiles();
		
		//load story
		mStory = FileLoaderStory.loadStoryFromFile();
		
		//if one of them failed to load, use an empty dictionary or story
		if (mDict == null) mDict = new TangoDictionary();
		if (mStory == null) mStory = new StoryReport();
		
		
		
		
		//get the kanji sets from the dictionary and story
		KanjiSet dictKanji, storyKanji, unkownKanji;
		dictKanji = mDict.getKanjiSet();
		storyKanji = mStory.getKanjiSet();

		//find unkown kanji (kanji which are in the story. but not in the dictionary)
		unkownKanji = new KanjiSet(storyKanji);
		unkownKanji.removeAll(dictKanji);
		
		
		//display reports
		displayReport(dictKanji, storyKanji, unkownKanji);
		System.out.println("\n");
	}
	
	
	
	
	
	
	/*
	 * displays all of the info
	 * displays dictionary conflicts, and the kanji sets for the dictionary and story
	 */
	public void displayReport(KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
		
		
		//print dictionary conflicts
		System.out.println("\n\n~~~~~Conflicts: ");
		System.out.println(mDict.getConflicts());
		
		//print kanji reports
		System.out.println("\n\n\n\n");

		System.out.println("\n\n~~~~~Dictionary kanji: ");
		System.out.println(dictKanji.getReport());
		
		System.out.println("\n\n~~~~~Story kanji: ");
		System.out.println(storyKanji.getReport());
		
		System.out.println("\n\n~~~~~Unkown kanji (absent from the dictionaries): ");
		System.out.println(unkownKanji.getReport());
		
		
		
		//display in GUI
		mWindow.displayInfo(mDict, mStory, dictKanji, storyKanji, unkownKanji);
		mWindow.setVisible(true);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Jisuu j = new Jisuu();
		j.launch();
	}
}

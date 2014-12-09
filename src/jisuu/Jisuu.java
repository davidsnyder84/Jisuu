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
	
	private KanjiSet mDictKanji, mStoryKanji, mUnkownKanji;
	
	
	public Jisuu(){	//constructor creates a window
		mWindow = new JisuuWindow();
		mDict = null;
		mStory = null;
		mDictKanji = mStoryKanji = mUnkownKanji = null;
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
		mDictKanji = mDict.getKanjiSet();
		mStoryKanji = mStory.getKanjiSet();

		//find unkown kanji (kanji which are in the story, but not in the dictionary)
		mUnkownKanji = new KanjiSet(mStoryKanji);
		mUnkownKanji.removeAll(mDictKanji);
		
		
		//display reports
		displayReport();
		System.out.println("\n");
	}
	
	
	
	
	
	
	/*
	 * displays all of the info
	 * displays dictionary conflicts, and the kanji sets for the dictionary and story
	 */
	private void displayReport(){
		
		//print dictionary conflicts
		System.out.println("\n\n~~~~~Conflicts: ");
		System.out.println(mDict.getConflicts());
		System.out.println("\n\n\n\n");
		
		
		//print kanji reports
		System.out.println("\n\n~~~~~Dictionary kanji: ");
		System.out.println(mDictKanji.getReport());
		
		System.out.println("\n\n~~~~~Story kanji: ");
		System.out.println(mStoryKanji.getReport());
		
		System.out.println("\n\n~~~~~Unkown kanji (absent from the dictionaries): ");
		System.out.println(mUnkownKanji.getReport());
		
		
		//display in GUI
		mWindow.displayInfo(mDict, mStory, mDictKanji, mStoryKanji, mUnkownKanji);
		mWindow.setVisible(true);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Jisuu j = new Jisuu();
		j.launch();
	}
}

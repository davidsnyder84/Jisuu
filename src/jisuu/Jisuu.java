package jisuu;

import jisuu.gui.JisuuWindow;
import jisuu.kanji.KanjiSet;
import jisuu.story.StoryReport;
import jisuu.vocab.TangoDictionary;

public class Jisuu {
	
	
	
	private JisuuWindow mWindow;
	
	
	public Jisuu(){	//constructor creates a window
		mWindow = new JisuuWindow();
	}
	
	
	
	
	/*
	 * launches the program
	 * loads the dictionaries, the story, and displays a report
	 */
	public void launch(){
		
		TangoDictionary dict = null;
		StoryReport story = null;
		KanjiSet dictKanji, storyKanji, unkownKanji;
		
		
		//load dictionaries
		dict = FileLoaderVocab.loadAllVocabFiles();
		
		//load story
		story = FileLoaderStory.loadStoryFromFile();
		
		//if one of them failed to load, use an empty dictionary or story
		if (dict == null) dict = new TangoDictionary();
		if (story == null) story = new StoryReport();
		
		
		
		
		//get the kanji sets from the dictionary and story
		dictKanji = dict.getKanjiSet();
		storyKanji = story.getKanjiSet();

		//find unkown kanji (kanji which are in the story. but not in the dictionary)
		unkownKanji = new KanjiSet(storyKanji);
		unkownKanji.removeAll(dictKanji);
		
		
		//display reports
		displayReport(dict, story, dictKanji, storyKanji, unkownKanji);
		System.out.println("\n");
	}
	
	
	
	
	
	
	/*
	 * displays all of the info
	 * displays dictionary conflicts, and the kanji sets for the dictionary and story
	 */
	public void displayReport(TangoDictionary dict, StoryReport story, KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
		
		
		//print dictionary conflicts
		System.out.println("\n\n~~~~~Conflicts: ");
		System.out.println(dict.getConflicts());
		
		//print kanji reports
		System.out.println("\n\n\n\n");

		System.out.println("\n\n~~~~~Dictionary kanji: ");
		System.out.println(dictKanji.getReport());
		
		System.out.println("\n\n~~~~~Story kanji: ");
		System.out.println(storyKanji.getReport());
		
		System.out.println("\n\n~~~~~Unkown kanji (absent from the dictionaries): ");
		System.out.println(unkownKanji.getReport());
		
		
		
		//display in GUI
		mWindow.displayInfo(dict, story, dictKanji, storyKanji, unkownKanji);
		mWindow.setVisible(true);
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Jisuu j = new Jisuu();
		j.launch();
	}
}

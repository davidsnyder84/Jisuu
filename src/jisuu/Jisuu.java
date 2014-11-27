package jisuu;

import jisuu.gui.JisuuWindow;
import jisuu.kanji.KanjiSet;
import jisuu.story.StoryReport;
import jisuu.vocab.TangoDictionary;

public class Jisuu {
	
	
	
	private JisuuWindow mWindow;
	
	
	public Jisuu(){
		mWindow = new JisuuWindow();
	}
	
	
	
	
	
	public void launch(){
		
		TangoDictionary dict = null;
		StoryReport story = null;
		KanjiSet dictKanji, storyKanji, unkownKanji;
		
		
		//load dictionaries
		dict = FileLoaderVocab.loadAllVocabFiles();
		
		//load story
		story = FileLoaderStory.loadStoryFromFile();
		
		
		//if null, just use an empty dictionary/story
		if (dict == null) dict = new TangoDictionary();
		if (story == null) story = new StoryReport();
		
		
		
		//find new kanji (kanji which are in the story. but not in the dictionary)
		dictKanji = dict.getKanjiSet();
		storyKanji = story.getKanjiSet();
		
		unkownKanji = new KanjiSet(storyKanji);
		unkownKanji.removeAll(dictKanji);
		
		
		//print info
		printInfo(dict, story, dictKanji, storyKanji, unkownKanji);
		
	}
	
	
	
	
	
	
	public void printInfo(TangoDictionary dict, StoryReport story, KanjiSet dictKanji, KanjiSet storyKanji, KanjiSet unkownKanji){
		
		
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
		
		
		System.out.println(dict.getFileStats());
		System.out.println(story.getFileStats());
		
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Jisuu jisuu = new Jisuu();
		jisuu.launch();
	}
}

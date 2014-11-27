package jisuu;

import jisuu.kanji.KanjiSet;
import jisuu.story.StoryReport;
import jisuu.vocab.TangoDictionary;

public class Jisuu {
	
	public static void main(String[] args) {
		
		
		TangoDictionary dict = new TangoDictionary();
		StoryReport storyRep = null;
		
		
		
		dict = loadDictionary();
		
		
		
		System.out.println("\n\n\n\n");
		
		
		
		
	}
	
	
	
	
	
	

	public static void storyReport(){
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static TangoDictionary loadDictionary(){
		
		
		TangoDictionary dict = FileLoaderVocab.loadAllVocabFiles();
		if (dict == null) return null;
		
		

		System.out.println(dict.getConflicts());
		
		
		
		KanjiSet dictKanji = dict.getKanjiSet();
		
		System.out.println("Unique kanji: " + dictKanji.size());
		System.out.println(dictKanji.toString());
		
		return dict;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

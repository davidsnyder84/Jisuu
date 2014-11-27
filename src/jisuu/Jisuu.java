package jisuu;

import jisuu.vocab.DupeFinder;
import jisuu.kanji.KanjiSet;
import jisuu.vocab.TangoDictionary;

public class Jisuu {
	
	public static void main(String[] args) {
		
		
		TangoDictionary dictionary = new TangoDictionary();
		
		
		
		dictionaryReport();

		System.out.println("\n\n\n\n");
		
		
		
		
	}
	
	
	
	
	
	

	public static void storyReport(){
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void dictionaryReport(TangoDictionary overallDictionary){
		
//		TangoDictionary overallList = new TangoList();
		
		overallList = FileLoader.loadAllVocabFiles();
		if (overallList == null) return;
		
		DupeFinder dupeFinder = new DupeFinder(overallList);
		dupeFinder.printConflicts();
		
		
		
		KanjiSet dictKanji = overallList.getKanjiSet();
		
		System.out.println("Unique kanji: " + dictKanji.size());
		System.out.println(dictKanji.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

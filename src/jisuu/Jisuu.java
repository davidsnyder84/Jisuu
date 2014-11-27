package jisuu;

import jisuu.vocab.DupeFinder;
import jisuu.vocab.KanjiSet;
import jisuu.vocab.TangoList;

public class Jisuu {
	
	public static void main(String[] args) {
		
		
		dictionaryReport();

		System.out.println("\n\n\n\n");
		
		
		
		
	}
	
	
	
	
	
	

	public static void storyReport(){
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void dictionaryReport(){
		
		TangoList overallList = new TangoList();
		
		overallList = FileLoader.loadAllVocabFiles();
		if (overallList == null) return;
		
		DupeFinder dupeFinder = new DupeFinder(overallList);
		dupeFinder.printConflicts();
		
		
		KanjiSet dictKanji = overallList.getKanjiSet();
		
		System.out.println("Unique kanji: " + dictKanji.size());
		System.out.println(dictKanji.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

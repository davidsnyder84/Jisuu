package jisuu;

import jisuu.vocab.DupeFinder;
import jisuu.vocab.TangoList;

public class Jisuu {
	
	public static void main(String[] args) {
		
		
		findVocabDupes();
		
		
		
	}
	
	
	
	
	public static void findVocabDupes(){
		long time = System.currentTimeMillis();
		long tSortLoad, tConf, tUniqk;
		
		
		TangoList overallList = new TangoList();
		
		overallList = FileLoader.loadAllVocabFiles();
		if (overallList == null) return;
		
		tSortLoad = System.currentTimeMillis() - time;
		System.out.println("\n\nTime elapsed for load/sort: " + tSortLoad);
		
		
//		System.out.println(overallList.toString());
//		System.out.println(overallList.getUniqueKanjiString());
		
		
		DupeFinder dupeFinder = new DupeFinder(overallList);
		dupeFinder.printConflicts();
		

		tConf = System.currentTimeMillis() - time;
		System.out.println("\n\nTime elapsed for conflicts: " + tConf);
		
		
		System.out.println("Unique kanji: " + overallList.getUniqueKanjiString("").length());
		System.out.println(overallList.getUniqueKanjiString(""));
		
		tUniqk = System.currentTimeMillis() - time;
		System.out.println("\n\nTime elapsed for uniqueK: " + tUniqk);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

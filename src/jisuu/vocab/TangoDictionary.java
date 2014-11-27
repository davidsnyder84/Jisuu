package jisuu.vocab;

import jisuu.FileLoader;
import jisuu.kanji.KanjiSet;

public class TangoDictionary {
	
	
	private TangoList mTangoList;
	
	private String mLoadStats;
	
	
	
	
	
	
	
	
	
	public TangoDictionary(){
	}
	
	
	
	
	
	
	
	public String getConflicts(){
//		TangoList overallList = new TangoList();
//		
//		overallList = FileLoader.loadAllVocabFiles();
//		if (overallList == null) return;
		
		DupeFinder dupeFinder = new DupeFinder(mTangoList);
		dupeFinder.printConflicts();
		return null;
	}
	
	
	
	
	
	
	public KanjiSet getKanjiSet(){
		return mTangoList.getKanjiSet();
	}
	
	public int size(){
		return mTangoList.size();
	}
	
	public String getLoadStats(){
		return mLoadStats;
	}
	
	
	
}

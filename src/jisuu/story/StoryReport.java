package jisuu.story;

import jisuu.kanji.KanjiSet;

public class StoryReport {
	
	
	private KanjiSet mKanjiSet;
	private int mLines;
	
	
	public StoryReport(KanjiSet kanji, int lines){
		mKanjiSet = kanji;
		mLines = lines;
	}
	
	
	
	
	
	
	
	
	/*
	 * returns (a copy of) the set of unique kanji for all the vocab cards
	 */
	public KanjiSet getKanjiSet(){
		return new KanjiSet(mKanjiSet);
	}
	
	public int getNumLines(){
		return mLines;
	}
	
	
	
	
}

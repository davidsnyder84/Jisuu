package jisuu.story;

import jisuu.kanji.KanjiSet;

public class StoryReport {
	
	
	private KanjiSet mKanjiSet;
	private int mLines;
	private String mFilename;
	
	
	public StoryReport(KanjiSet kanji, int lines, String filename){
		if (kanji != null)
			mKanjiSet = kanji;
		else
			mKanjiSet = new KanjiSet();
		
		mLines = lines;
		mFilename = filename;
	}
	public StoryReport(){
		mKanjiSet = new KanjiSet();
		mLines = 0;
		mFilename = "";
	}
	
	
	
	
	
	
	public String getFileStats(){
		String statString = "";
		
		statString += ".........Loaded " + mLines + " lines from " + mFilename;
		return statString;
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
	
	public String getFilename(){
		return mFilename;
	}
	
	
	
	
	
	
	
}

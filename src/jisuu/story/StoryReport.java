package jisuu.story;

import jisuu.kanji.KanjiSet;

public class StoryReport {
	
	
	private KanjiSet mKanjiSet;
	private int mLines;
	private String mFilename;
	
	
	
	//to create the report, requires a kanji set, number of lines read, and the filename
	public StoryReport(KanjiSet kanji, int lines, String filename){
		if (kanji != null)
			mKanjiSet = kanji;
		else
			mKanjiSet = new KanjiSet();
		
		mLines = lines;
		mFilename = filename;
	}
	public StoryReport(){	//creates an empty report
		mKanjiSet = new KanjiSet();
		mLines = 0;
		mFilename = "";
	}
	
	
	
	
	
	
	
	
	/*
	 * returns (a copy of) the set of unique kanji for all the vocab cards
	 */
	public KanjiSet getKanjiSet(){
		return new KanjiSet(mKanjiSet);
	}
	//accessors
	public int getNumLines(){
		return mLines;
	}
	public String getFilename(){
		return mFilename;
	}
	
	
	
	
	
	/*
	 * returns some statistics for the file the story was loaded from
	 */
	public String getFileStats(){
		String statString = "";
		
		statString += ".........Loaded " + mLines + " lines from " + mFilename;
		return statString;
	}
	
	
	
}

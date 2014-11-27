package jisuu.vocab;

import java.util.ArrayList;
import java.util.List;

import jisuu.kanji.KanjiSet;

public class TangoDictionary extends ArrayList<Tango>{
	private static final long serialVersionUID = -6432715930946054694L;
	
	
	
	
	private final DupeFinder mDupeFinder;
	
	
	
	
	
	
	public TangoDictionary(){
		mDupeFinder = new DupeFinder(this);
	}
	
	
	
	
	
	
	
	
	

	/*
	 * returns the set of unique kanji for all the vocab cards
	 */
	public KanjiSet getKanjiSet(){
		return new KanjiSet(getFronts());
	}
	
	
	
	
	/*
	 * returns a list of the fronts of all the vocab cards
	 */
	public List<String> getFronts(){
		List<String> fronts = new ArrayList<String>(size());
		for (Tango t: this) fronts.add(t.getFront());
		return fronts;
	}
	
	
	
	
	
	
	

	
	
	
	public String getConflicts(){
		return mDupeFinder.getConflictsAsString();
	}

	public boolean containsConflicts(){
		return mDupeFinder.containsConflicts();
	}
	
	
	
	
	
	
	
	
	
	
	public String toString(){
		String listString = "";
		for (Tango t: this) listString += t.toString() + "\n";
			
		return listString;
	}
	
	
}

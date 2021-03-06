package jisuu.vocab;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import jisuu.kanji.KanjiSet;



/*
 * CS697B Project
 * David Snyder
 * A247A342
 * 
 * 
 * TangoDictionary
 * Represents a dictionary of vocab cards
 * 
 * derived class of ArrayList<Tango>
 * added functionality:	look up a word in the dictionary
 * 						get a list of the fronts of all the cards
 * 						get the set of unique kanji from the dictionary's cards
 * 						check for conflicts among the vocab cards
 * 						get statistics for the files the vocab cards were loaded from
 * 						
 * 
 */
public class TangoDictionary extends ArrayList<Tango>{
	private static final long serialVersionUID = -6432715930946054694L;
	
	
	
	private final DupeFinder mDupeFinder;
	
	public TangoDictionary(){
		//associates a dupe finder with this dictionary
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
	
	
	
	/*
	 * returns the vocab card for the first instance of the word found in the dictionary
	 */
	public Tango findWord(String  word){
		for (Tango t: this)
			if (t.getFront().equalsIgnoreCase(word))
				return t;
		
		return null;
	}
	
	
	
	
	
	

	
	
	//returns true if the dictionary contains conflicts
	public boolean containsConflicts(){
		return mDupeFinder.containsConflicts();
	}
	
	//returns all conflicts as a string
	public String getConflicts(){
		return mDupeFinder.getConflictsAsString();
	}
	
	
	
	//returns all conflicts as a string
	public String getAllDupes(){
		return mDupeFinder.getDupesAsString();
	}
	
	
	
	
	
	/*
	 * returns some statistics for the file(s) the dictionary was loaded from
	 */
	public String getFileStats(){
		
		String statString = "";
		
		TreeMap<String, Integer> freqMap = new TreeMap<String, Integer>();
		
		for (Tango t: this){
			String fname = t.getFileOrigin();
			if (freqMap.containsKey(fname))
				freqMap.put(fname, freqMap.get(fname) + 1);
			else
				freqMap.put(fname, 1);
		}
		
		
		for (String s: freqMap.keySet())
			statString += "...Loaded " + freqMap.get(s) + " vocab cards from " + s + "\n";
		
		statString += ".........Loaded " + size() + " vocab cards total\n";
		
		return statString;
	}
	
	
	
	
	
	/*
	 * returns all entries in the dictionary as a string
	 */
	public String toString(){
		String listString = "";
		for (Tango t: this) listString += t.toString() + "\n";
			
		return listString;
	}
	
	
}

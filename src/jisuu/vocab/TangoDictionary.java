package jisuu.vocab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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
//	public String getFileStats(){
//		String statString = "";
//		
//		
//		HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
//		
//		for (Tango t: this){
//			String fname = t.getFileOrigin();
//			if (freqMap.containsKey(fname))
//				freqMap.put(fname, freqMap.get(fname) + 1);
//			else
//				freqMap.put(fname, 1);
//		}
//		
//		
//		List<String> freqs = new ArrayList<String>(freqMap.keySet());
//		Collections.sort(freqs);
//		for (String s: freqs)
//			statString += "...Loaded " + freqMap.get(s) + " vocab cards from " + s + "\n";
//		
//		return statString;
//	}
	
	
	
	
	
	
	public String toString(){
		String listString = "";
		for (Tango t: this) listString += t.toString() + "\n";
			
		return listString;
	}
	
	
}

package jisuu.vocab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import jisuu.kanji.KanjiChar;
import jisuu.kanji.KanjiSet;
import jisuu.vocab.dupe.Dupe;
import jisuu.vocab.dupe.DupeList;

public class TangoList extends ArrayList<Tango>{
	private static final long serialVersionUID = 230419051499078827L;
	
	public static final String DEFAULT_UNIQUE_KANJI_SPLITTER = "\n";
	
	
	
//	private final KanjiSet mKanjiSet;
	
	
	
	
	public TangoList(){
//		mKanjiSet = new KanjiSet();
	}
	
	
	
	
	
	
	
	
	
	
	
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
	 * no need for this yet
	 */
	@Override
	public boolean add(Tango t){
		boolean res = super.add(t);
		
		return res;
	}
	
	
	
	
	public boolean containsConflicts(){
		return findAllConflicts().isEmpty();
	}
	
	public DupeList findAllConflicts(){
		
		DupeList conflicts = new DupeList();
		
		for (int curr = 0; curr < size() - 1; curr++)
			if (get(curr).conflictsWith(get(curr + 1)))
				conflicts.add(new Dupe(true, get(curr), get(curr + 1)));
		
		return conflicts;
	}
	
	
	
	
	
	
	
	
	public String toString(){
		String listString = "";
		for (Tango t: this) listString += t.toString() + "\n";
			
		return listString;
	}
	
	
}

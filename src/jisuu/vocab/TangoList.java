package jisuu.vocab;

import java.util.ArrayList;
import java.util.List;

import jisuu.kanji.KanjiSet;

public class TangoList extends ArrayList<Tango>{
	private static final long serialVersionUID = 230419051499078827L;
	
	
	
	
	
	
	public TangoList(){}
	
	
	
	
	
	
	
	
	
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
	
	
	
	
	
	
	
	
	
	public String toString(){
		String listString = "";
		for (Tango t: this) listString += t.toString() + "\n";
			
		return listString;
	}
	
	
}

package jisuu.kanji;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import jisuu.kanji.KanjiChar;

public class KanjiSet extends HashSet<Character>{
	private static final long serialVersionUID = -3252352541857029942L;
	
	
	private static final String DEFAULT_UNIQUE_KANJI_SPLITTER = "";	//used for output
	
	
	
	

	public KanjiSet(){
		super();
	}
	public KanjiSet(List<String> strings){	//constructor to add the kanji from a list of strings
		this();
		add(strings);
	}
	public KanjiSet(Collection<? extends Character> col){	//constructor to add kanji from another collection of characters
		this();
		addAll(col);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * add a character to the set
	 * Overridden to allow only Kanji characters to be added to the set
	 */
	@Override
	public boolean add(Character c){
		return (KanjiChar.isKanji(c) && super.add(c));
	}
	
	
	/*
	 * adds all the kanji in a given string to the set
	 */
	public boolean add(String string){
		boolean changed = false;
		for (Character c: string.toCharArray())
			changed = add(c) || changed;
		
		return changed;
	}
	
	
	/*
	 * for each string in the list of strings, adds all the kanji in the string to the set
	 */
	public boolean add(List<String> strings){
		boolean changed = false;
		for (String s: strings)
			changed = add(s) || changed;
			
		return changed;
	}
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * returns (as a String) a report containing the size of the set and the contents of the set
	 */
	public String getReport(){
		String report = "";
		
		report = "Unique kanji: " + size() + "\n";
		report += toString();
		
		return report;
	}
	
	
	
	
	/*
	 * returns all of the set's kanji in a sorted order
	 */
	public String toString(){
		
		//sort here
		List<Character> uniqueKList = new ArrayList<Character>(this);
		Collections.sort(uniqueKList);
		
		String listString = "";
		for (Character c: uniqueKList) listString += c + DEFAULT_UNIQUE_KANJI_SPLITTER;
			
		return listString;
	}
	
}

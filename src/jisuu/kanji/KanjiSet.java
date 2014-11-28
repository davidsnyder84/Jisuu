package jisuu.kanji;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import jisuu.kanji.KanjiChar;

public class KanjiSet extends HashSet<Character>{
	private static final long serialVersionUID = -3252352541857029942L;
	
	
	
	public static final String DEFAULT_UNIQUE_KANJI_SPLITTER = "";
	
	
	
	

	public KanjiSet(){
		super();
	}
	public KanjiSet(List<String> strings){
		this();
		add(strings);
	}
	public KanjiSet(Collection<? extends Character> col){
		this();
		addAll(col);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public boolean add(Character c){
		if (KanjiChar.isKanji(c))
			return super.add(c);
		
		return false;
	}
	
	
	@Override
	public boolean addAll(Collection<? extends Character> col){
		boolean changed = false;
		for (Character c: col)
			changed = add(c) || changed;
		return changed;
	}
	
	
	
	public boolean add(String string){

		boolean changed = false;
		char[] charArray = string.toCharArray();
		for (Character c: charArray)
			changed = add(c) || changed;
		
		return changed;
	}
	
	public boolean add(List<String> strings){
		
		boolean changed = false;
		for (String s: strings)
			changed = add(s) || changed;
			
		return changed;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getReport(){
		String report = "";
		
		report = "Unique kanji: " + size() + "\n";
		report += toString();
		
		return report;
	}
	
	
	
	
	public String toString(){
		
		//sort here
		List<Character> uniqueKList = new ArrayList<Character>(this);
		Collections.sort(uniqueKList);
		
		String listString = "";
		for (Character c: uniqueKList) listString += c + DEFAULT_UNIQUE_KANJI_SPLITTER;
		
			
		return listString;
	}
	
}

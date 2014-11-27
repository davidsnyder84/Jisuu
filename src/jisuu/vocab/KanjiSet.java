package jisuu.vocab;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import jisuu.kanji.KanjiChar;

public class KanjiSet extends HashSet<Character>{
	private static final long serialVersionUID = -3252352541857029942L;
	
	
	
	public static final String DEFAULT_UNIQUE_KANJI_SPLITTER = "";
	
	
	
	
	
	
	
	
	public boolean add(String string){
		
		Collection<Character> uniqueK = new HashSet<Character>();

		//add unique characters
		char[] charArray = string.toCharArray();
		for (Character c: charArray)
			uniqueK.add(c);
		
		
		//remove non-kanji characters
		uniqueK.removeAll(KanjiChar.setOfNonKanji());
		
		
		
		return addAll(uniqueK);
	}
	
	public boolean add(List<String> strings){
		
		boolean changed = false;
		for (String s: strings)
			changed = add(s) || changed;
			
		return changed;
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

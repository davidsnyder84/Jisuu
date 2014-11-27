package jisuu.vocab;

import java.util.Iterator;

import jisuu.kanji.KanjiSet;

public class TangoDictionary implements Iterable<Tango> {
	
	
	private final TangoList mTangoList;
	private final DupeFinder mDupeFinder;
	
//	private String mLoadStats;
	
	
	
	
	
	
	
	
	
	public TangoDictionary(){
		mTangoList = new TangoList();
		mDupeFinder = new DupeFinder(mTangoList);
	}
	
	
	
	
	
	
	
	public boolean addAll(TangoDictionary other){
		return mTangoList.addAll(other.mTangoList);
	}
	
	
	
	
	
	
	
	
	
	
	

	
	public boolean containsConflicts(){
		return mDupeFinder.containsConflicts();
	}
	
	
	public String getConflicts(){
		return mDupeFinder.getConflictsAsString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public KanjiSet getKanjiSet(){
		return mTangoList.getKanjiSet();
	}
	
	public int size(){
		return mTangoList.size();
	}
	
	
	
	
	
	
	
	
	
	public Iterator<Tango> iterator() {
		return mTangoList.iterator();
	}
	
	
	
//	public String getLoadStats(){
//		return mLoadStats;
//	}
	
	
	
}

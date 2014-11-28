package jisuu.vocab;

import jisuu.vocab.Tango;

public class Dupe {
	
	private final Tango mTango1;
	private final Tango mTango2;
	
	private final boolean mIsConflict;

	
	public Dupe(boolean isConflict, Tango t1, Tango t2){
		mTango1 = t1; mTango2 = t2;
		mIsConflict = isConflict;
	}
	public Dupe(Tango t1, Tango t2){
		mTango1 = t1; mTango2 = t2;
		mIsConflict = __checkForConflict();
	}
	
	
	
	
	private boolean __checkForConflict(){
		return mTango1.conflictsWith(mTango2);
	}
	
	
	
	
	
	
	public boolean isConflict(){return mIsConflict;}
	
	
	
	
	
	/*
	 * returns (as a String) the type of Dupe (duplicate vs conflict), and the vocab cards involved with the Dupe
	 */
	public String toString(){
		String dString = "";
		if (mIsConflict) dString += "!!!!!Conflict!!!!!\n";
		else dString += "Duplicate\n";
		
		dString += "\t" + mTango1.toString() + "\n";
		dString += "\t" + mTango2.toString() + "\n";
		
		return dString;
	}
	
}

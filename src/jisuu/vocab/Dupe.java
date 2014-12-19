package jisuu.vocab;

import jisuu.vocab.Tango;




/*
 * CS697B Project
 * David Snyder
 * A247A342
 * 
 * 
 * Dupe
 * Used to represent an incident where duplicate entries for the same vocab card are found
 * Immutable class
 * 
 * Data: 2 vocab cards (the cards involved in the dupe)
 * 		 a flag indicating if the dupe involves a conflicting definitions (there is no conflict if the cards have the same definitions)
 * 
 */
public class Dupe implements Comparable<Dupe>{
	
	private final Tango mTango1;
	private final Tango mTango2;
	
	private final boolean mIsConflict;

	
	//constructor takes the 2 cards involved in the dupe, and a flag for whether or not it is a conflicting dupe 
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
	
	
	
	
	
	/*
	 * returns true if the dupe is a conflicting dupe
	 */
	public boolean isConflict(){return mIsConflict;}
	
	
	
	
	
	/*
	 * returns (as a String) the type of Dupe (duplicate vs conflict), and the vocab cards involved with the Dupe
	 */
	public String toString(){
		String dString = "";
		if (mIsConflict) dString += "!!!!!!!!!!Conflict!!!!!!!!!!\n";
		else dString += ",,,,,Duplicate\n";
		
		dString += "\t" + mTango1.toString() + "\n";
		dString += "\t" + mTango2.toString() + "\n";
		
		return dString;
	}
	
	@Override
	public int compareTo(Dupe other) {
		
		//compare by type (duplicate vs conflict)
		if (Boolean.compare(other.mIsConflict, mIsConflict) != 0)
			return Boolean.compare(other.mIsConflict, mIsConflict);
		
		//if the dupes are the same type (both duplicate, or both conflict), compare by name
		return mTango1.compareTo(other.mTango1);
	}
	
	
	
	
}

package jisuu.vocab;



public class Tango implements Comparable<Tango>{
	
	
	private String mFront;
	private String mBack;
	
	private String mFileOrigin;
	
	
	
	
	public Tango(String front, String back, String fileOrigin){
		mFront = front;
		mBack = back;
		
		mFileOrigin = fileOrigin;
	}
	public Tango(String front, String back){
		this(front, back, null);
	}
	
	
	
	
	
	
	//accessors
	public String getFront(){return mFront;}
	public String getBack(){return mBack;}
	public String getFileOrigin(){return mFileOrigin;}

	
	
	
	
	
	
	
	
	
	
	//checks for duplicates with different backs
	public boolean conflictsWith(Tango other){
		
		if (other == null) return false;	//return false if other is null
		
		//return true if the cards have the same front, but different backs
		return (mFront.equals(other.mFront) && !mBack.equals(other.mBack));
	}
	
	
	
	
	
	
	//compare by front name
	public int compareTo(Tango other){
		return mFront.compareTo(other.mFront);
	}
	
	//if two cards have the same front, they are considered equal
	public boolean equals(Object other){
		if (other == null || !(other instanceof Tango))
			return false;
		
		return mFront.equals(((Tango)other).mFront);
	}
	
	
	//returns true if the cards have the same front and same back
	public boolean equalsExactly(Tango other){
		if (other == null) return false;
		
		return (mFront.equals(other.mFront) && mBack.equals(other.mBack));
	}
	
	
	
	
	//toString
	public String toString(){
		final int PAD_LENGTH = 15;
		char[] arrayFO = new char[PAD_LENGTH];
		for (int i = 0; i < mFileOrigin.length() && i < PAD_LENGTH; i++){
			arrayFO[i] = mFileOrigin.charAt(i);
		}
		String paddedFO = String.valueOf(arrayFO);
		
		return (paddedFO + ":   " + mFront + "\t" + mBack);
	}
	
}

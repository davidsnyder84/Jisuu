package jisuu.vocab;

import java.util.ArrayList;
import java.util.List;

import jisuu.vocab.Dupe;



/*
 * CS697B Project
 * David Snyder
 * A247A342
 * 
 * 
 * DupeFinder
 * a helper class used to find dupes within a vocab dictionary
 * 
 */
public class DupeFinder {
	

	private final TangoDictionary mDict;
	
	
	//contructor requires a dictionary to be associated with the DupeFinder object
	public DupeFinder(TangoDictionary dict){
		if (dict != null)
			mDict = dict;
		else
			mDict = new TangoDictionary();
	}
	
	
	
	
	
	
	
	
	/*
	 * returns a list of all conflicts in the associated dictionary
	 */
	public List<Dupe> findAllConflicts(){
		
		List<Dupe> conflicts = new ArrayList<Dupe>();
		
		for (int curr = 0; curr < mDict.size() - 1; curr++)
			if (mDict.get(curr).conflictsWith(mDict.get(curr + 1)))
				conflicts.add(new Dupe(true, mDict.get(curr), mDict.get(curr + 1)));
		
		return conflicts;
	}
	
	
	
	//returns true if the dictionary contains any conflicts
	public boolean containsConflicts(){
		return !findAllConflicts().isEmpty();
	}
	
	
	
	//returns a list of all conflicts as a string
	public String getConflictsAsString(){
		String conflictsString = "";

		
		List<Dupe> conflicts = findAllConflicts();
		
		if (conflicts.isEmpty())
			conflictsString = "No conflicts found!";
		else
			for (Dupe d: conflicts)
				conflictsString += d.toString();
		
		
		return conflictsString;
	}
	
	
	
}

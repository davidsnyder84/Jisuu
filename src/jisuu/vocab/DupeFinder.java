package jisuu.vocab;

import java.util.ArrayList;
import java.util.List;

import jisuu.vocab.Dupe;

public class DupeFinder {
	

	private final TangoDictionary mDict;
	
	
	public DupeFinder(TangoDictionary dict){
		if (dict != null)
			mDict = dict;
		else
			mDict = new TangoDictionary();
	}
	
	
	
	
	
	
	
	
	
	
	
	public List<Dupe> findAllConflicts(){
		
		List<Dupe> conflicts = new ArrayList<Dupe>();
		
		for (int curr = 0; curr < mDict.size() - 1; curr++)
			if (mDict.get(curr).conflictsWith(mDict.get(curr + 1)))
				conflicts.add(new Dupe(true, mDict.get(curr), mDict.get(curr + 1)));
		
		return conflicts;
	}
	
	

	
	public boolean containsConflicts(){
		return !findAllConflicts().isEmpty();
	}
	
	
	
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

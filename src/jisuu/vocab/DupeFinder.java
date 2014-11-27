package jisuu.vocab;

import java.util.ArrayList;
import java.util.List;

import jisuu.vocab.dupe.Dupe;

public class DupeFinder {
	

	private final TangoList mTangoList;
	
	
	public DupeFinder(TangoList list){
		if (list != null)
			mTangoList = list;
		else
			mTangoList = new TangoList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Dupe> findAllConflicts(){
		
		List<Dupe> conflicts = new ArrayList<Dupe>();
		
		for (int curr = 0; curr < mTangoList.size() - 1; curr++)
			if (mTangoList.get(curr).conflictsWith(mTangoList.get(curr + 1)))
				conflicts.add(new Dupe(true, mTangoList.get(curr), mTangoList.get(curr + 1)));
		
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
